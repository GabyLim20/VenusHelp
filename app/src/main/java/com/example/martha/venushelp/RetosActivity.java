package com.example.martha.venushelp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class RetosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retos);
    }
    public void hola(View view){
        Intent intent = new Intent(this, MapaBotActivity.class);
        startActivity(intent);
    }
    private void solicitapermiso(){
        ActivityCompat.requestPermissions(this,new String[]
                {CAMERA,WRITE_EXTERNAL_STORAGE},200);

    }
    public void tomarFoto(View view){
        solicitapermiso();
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            ImageView imagen = (ImageView) findViewById(R.id.imgFoto);
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imagen.setImageBitmap(bitmap);
        } catch (Exception ex) {
            Toast.makeText(this, "Error: " + ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
