package com.example.traffic_rule_and_sign_quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editUsername, editPassword;
    ImageButton btnLogin;
    TextView showPassword;
    String Username, Password;
    CheckBox remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        editUsername = findViewById(R.id.username);
        editPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.signin);
        showPassword = findViewById(R.id.eye);

        btnLogin.setOnClickListener(this);

        showPassword.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ResourceType")
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
    }


    @Override
    public void onClick(View v) {
        Username = editUsername.getText().toString();
        Password = editPassword.getText().toString();
        if (validate()) {
            if (Username.equals("admin") && Password.equals("admin")) {
                Toast.makeText(LoginActivity.this, "Username and Password is correct", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(LoginActivity.this, "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                editUsername.setError("Username or password is incorrect");
                editUsername.requestFocus();
            }
        }

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




