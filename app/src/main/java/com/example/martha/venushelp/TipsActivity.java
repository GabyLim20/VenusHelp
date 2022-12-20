package com.example.martha.venushelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
    }
    public void hola(View view){
        Intent intent = new Intent(this, MapaBotActivity.class);
        startActivity(intent);
    }
}
