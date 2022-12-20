package com.example.martha.venushelp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.INTERNET;

public class MapaBotActivity extends AppCompatActivity implements LocationListener {
    private EditText txtLatitud, txtLongitud;
    private LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_bot);
        txtLatitud = (EditText) findViewById(R.id.txtLatitud);
        txtLongitud = (EditText) findViewById(R.id.txtLongitud);
        txtLongitud = (EditText) findViewById(R.id.txtLongitud);
        this.solicitaPermiso();
        locationManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)
                !=PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Permiso Gps no habilitado", Toast.LENGTH_SHORT).show();
            return;
        }
        locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 0, 0,  this);

    }
    private void solicitaPermiso(){
        ActivityCompat.requestPermissions(this,new String []{INTERNET, ACCESS_COARSE_LOCATION,ACCESS_FINE_LOCATION},200);
    }
    public void visualizaPosicion(View view){
        WebView webView=(WebView)findViewById(R.id.visorweb);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setGeolocationEnabled(true);
        webView.loadUrl("https://www.google.com.mx/maps/@"+txtLatitud.getText().toString()+","+txtLongitud.getText().toString()+",18z");

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;

            }
        });
    }
    @Override
    public void onLocationChanged(Location location) {
        txtLatitud.setText(String.valueOf(location.getLatitude()));
        txtLongitud.setText(String.valueOf(location.getLongitude()));
    }

  @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

  @Override
    public void onProviderEnabled(String s) {
        Toast.makeText(this, "GPS deshabilidado!", Toast.LENGTH_SHORT).show();
    }

  @Override
    public void onProviderDisabled(String s) {
        Toast.makeText(this, "GPS habilidado!", Toast.LENGTH_SHORT).show();
    }
    public void Envia(View view){
        Toast.makeText(this, "Se ha envíado tu mensaje", Toast.LENGTH_SHORT).show();
    }
}
