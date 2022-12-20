package com.example.martha.venushelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void login(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
 public void hola(View view){
     Intent intent = new Intent(this, MenuPrincipalActivity.class);
     startActivity(intent);
 }
    public void xe(View view){
        Intent intent = new Intent(this, CostoActivity.class);
        startActivity(intent);
    }
}
