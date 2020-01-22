package com.example.traffic_rule_and_sign_quiz_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traffic_rule_and_sign_quiz_app.API.User;
import com.example.traffic_rule_and_sign_quiz_app.Model.User_model;

import com.example.traffic_rule_and_sign_quiz_app.Url.Url;
import com.example.traffic_rule_and_sign_quiz_app.ui.Aboutus.AboutUsFragment;
import com.example.traffic_rule_and_sign_quiz_app.ui.Profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

        BottomNavigationView home_navigation;
        private TextView toolbarhead;
        CircleImageView imageView;
        SearchView searchView;


        @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        toolbarhead=findViewById(R.id.toolbarhead);
        searchView=findViewById(R.id.btn_search);
        home_navigation = findViewById(R.id.homeNavigation);
        imageView = findViewById(R.id.post_profileimg);


        home_navigation.setOnNavigationItemSelectedListener(this);

        setFragment(new ViewDashboardActivity());
        loadCurrentUser();
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
                        case R.id.nav_home:

                                selectedFragment=new ViewDashboardActivity();


                                break;
                        case R.id.nav_notification:

                                selectedFragment=new AboutUsFragment();

                                break;


                        case R.id.nav_profile:

                                selectedFragment=new ProfileFragment();



                                break;

                }
                return setFragment(selectedFragment);
        }

        private void loadCurrentUser() {

                User user = Url.getInstance().create(User.class);
                Call<User_model> userCall = user.getUserDetails(Url.token);

                userCall.enqueue(new Callback<User_model>() {
                        @Override
                        public void onResponse(Call<User_model> call, Response<User_model> response) {
                                if (!response.isSuccessful()) {
                                        Toast.makeText(DashboardActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                                        return;
                                }
                                String imgPath = Url.imagePath +  response.body().getImage();

                                Picasso.get().load(imgPath).into(imageView);


//                StrictModeClass.StrictMode();
//                try {
//                    URL url = new URL(imgPath);
//                    imgProgileImg.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                        }

                        @Override
                        public void onFailure(Call<User_model> call, Throwable t) {
                                Toast.makeText(DashboardActivity.this, "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                        }


                });
        }
}


