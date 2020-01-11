package com.example.traffic_rule_and_sign_quiz_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.traffic_rule_and_sign_quiz_app.Myadapter.MyAdapter;
import com.example.traffic_rule_and_sign_quiz_app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

        BottomNavigationView home_navigation;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        home_navigation = findViewById(R.id.homeNavigation);
        ViewDashboardActivity dashboardFragment = new ViewDashboardActivity();
        setFragment(dashboardFragment);
        }

@Override
public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
        }

public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.dasboard, fragment);
        fragmentTransaction.commit();
        }
        }
