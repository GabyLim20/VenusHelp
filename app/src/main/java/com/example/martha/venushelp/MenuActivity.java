package com.example.martha.venushelp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MenuActivity extends FragmentActivity {
private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener= new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                android.support.v4.app.FragmentManager fragmentManager= MenuActivity.this.getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction transaction= fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_menu:
               transaction.replace(R.id.content,new MenuFragment());
                    return true;
                case R.id.navigation_home:
                    transaction.replace(R.id.content,new HomeFragment());
                    return true;
                case R.id.navigation_dashboard:
                    transaction.replace(R.id.content,new DashboardFragment());
                    return true;
                case R.id.navigation_notifications:
                    transaction.replace(R.id.content,new NotificacionsFragment());
                    return true;

            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}
