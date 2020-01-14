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
import android.widget.TextView;

import com.example.traffic_rule_and_sign_quiz_app.Myadapter.MyAdapter;
import com.example.traffic_rule_and_sign_quiz_app.R;
import com.example.traffic_rule_and_sign_quiz_app.ui.Aboutus.AboutUsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

        BottomNavigationView home_navigation;
        private TextView toolbarhead;



@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        toolbarhead=findViewById(R.id.toolbarhead);
        home_navigation = findViewById(R.id.homeNavigation);

        home_navigation.setOnNavigationItemSelectedListener(this);

        setFragment(new ViewDashboardActivity());
        }

        public boolean setFragment(Fragment fragment){
                if(fragment != null)
                {
                        getSupportFragmentManager().beginTransaction().replace(R.id.dasboard,fragment).commit();
                        return true;
                }
                return false;
        }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment=null;


                switch (menuItem.getItemId())
                {
                        case R.id.nav_notification:
                                toolbarhead.setText("About us");
                                selectedFragment=new AboutUsFragment();
                                break;

                        case R.id.nav_home:

                                selectedFragment=new ViewDashboardActivity();

                                break;

                }
                return setFragment(selectedFragment);
        }
}
