package com.example.traffic_rule_and_sign_quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traffic_rule_and_sign_quiz_app.Methods.LoginRegister;
import com.example.traffic_rule_and_sign_quiz_app.Model.User_model;
import com.example.traffic_rule_and_sign_quiz_app.R;
import com.example.traffic_rule_and_sign_quiz_app.Url.Url;

public class LoginActivity extends AppCompatActivity {
    EditText editUsername, editPassword;
    ImageButton btnLogin;
    Button Signup;
    TextView showPassword;
    String Username, Password;
    CheckBox remember;

    SharedPreferences sp;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);


        editUsername = findViewById(R.id.username);
        editPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.signin);
        showPassword = findViewById(R.id.eye);
        Signup = findViewById(R.id.signup);
        remember=findViewById(R.id.checkbox);

        sp = getApplicationContext().getSharedPreferences("mysp",MODE_PRIVATE);
        editor = sp.edit();

        Username = sp.getString("un","");
        Password = sp.getString("pw","");

        showPassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.eye) {

                    if (editPassword.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {

                        //Show Password
                        editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    } else {


                        //Hide Password
                        editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    }
                }
            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Username = editUsername.getText().toString();
                Password=editPassword.getText().toString();
                if(validate()){
                    User_model user
                            = new User_model(Username,Password);
                    // userLogin(user);

                    LoginRegister loginRegister =new LoginRegister();

                    if (loginRegister.userLogin(user))
                    {
                        Toast.makeText(LoginActivity.this, Url.token, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this  , DashboardActivity.class );
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "user id and password wrong", Toast.LENGTH_SHORT).show();

                    }
                }}
        });
    }




//    private void login(){
//        User_Model user_model = new User_Model(LEmail = etEm.getText().toString(),LPassword = etPass.getText().toString());
//        Call<User_Model> loginUser = user_interface.userLogin(user_model);
//        loginUser.enqueue(new Callback<User_Model>() {
//            @Override
//            public void onResponse(Call<User_Model> call, Response<User_Model> response) {
//                if (response.isSuccessful()) {
//                    sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("Token",response.body().getToken());
//                    editor.putString("Name",response.body().getName());
//
//                    editor.commit();
//                    Intent intentDashboard = new Intent(LoginActivity.this, MainActivity.class);
//                    startActivity(intentDashboard);
//                }
//                else{
//                    Toast.makeText(LoginActivity.this, "Invalid Email or Password!", Toast.LENGTH_SHORT).show();
//                    etEm.setError("incorrect email ");
//                    etPass.setError("incorrect password");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User_Model> call, Throwable t) {
//
//            }
//        });
//    }

    private boolean validate() {
        if (TextUtils.isEmpty(Username)) {
            editUsername.setError("Please Enter Username");
            editUsername.requestFocus();
            return false;

        }
        if (TextUtils.isEmpty(Password)) {
            editPassword.setError("Please Enter Passward");
            editPassword.requestFocus();
            return false;
        }
        return true;
    }
}




