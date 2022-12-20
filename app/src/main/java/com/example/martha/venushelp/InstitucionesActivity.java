package com.example.martha.venushelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InstitucionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instituciones);
    }
    public void hola(View view){
        Intent intent = new Intent(this, InsjaActivity.class);
        startActivity(intent);
    }
    public void ho(View view){
        Intent intent = new Intent(this, YabActivity.class);
        startActivity(intent);
    }
    public void hol(View view){
        Intent intent = new Intent(this, ConActivity.class);
        startActivity(intent);
    }
    public void bot(View view){
        Intent intent = new Intent(this, MapaBotActivity.class);
        startActivity(intent);
    }
}
