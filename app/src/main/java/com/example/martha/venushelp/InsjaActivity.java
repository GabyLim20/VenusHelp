package com.example.martha.venushelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InsjaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insja);
    }
    public void hola(View view){
        Intent intent = new Intent(this, InsActivity.class);
        startActivity(intent);
    }
}
