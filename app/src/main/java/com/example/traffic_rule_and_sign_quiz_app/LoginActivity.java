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
                    User_model user = new User_model(Username,Password);
                    // userLogin(user);

                    LoginRegister loginRegister =new LoginRegister();

                    if (loginRegister.userLogin(user))
                    {
                        SharedPreferences preferences = getSharedPreferences("session", MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();

                        editor.putString("id", Url.id);
                        editor.putString("token", Url.token);
                        editor.putString("username", Username);
                        editor.putString("password", Password);
                        editor.commit();

                        Toast.makeText(LoginActivity.this, Url.token, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this  , DashboardActivity.class );
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Username and password wrong", Toast.LENGTH_SHORT).show();

                    }
                }}
        });
    }

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




