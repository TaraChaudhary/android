package com.example.traffic_rule_and_sign_quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import retrofit2.Retrofit;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener {
    private LinearLayout linearName, linearGender,linearDob,linearEmail,linearPassword,linearSignup;
    private TextView toolbarhead;
    private RelativeLayout Finish;
    private Button btnStart,btnDob,btnGender,btnEmail,btnPassword,btnBack,btnSigup;
    TextInputEditText fname,lname,phone,email,password;
    DatePicker dob;
    RadioGroup gender;

    Retrofit retrofit;

    String udob,uname,ugender,uphone,uemail,upassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnStart = findViewById(R.id.start);
        btnGender = findViewById(R.id.second);
        btnDob=findViewById(R.id.third);
        btnEmail=findViewById(R.id.fourth);
        btnPassword=findViewById(R.id.fifth);
        btnBack=findViewById(R.id.back);
        btnSigup=findViewById(R.id.btnTakeSignup);


        linearName = findViewById(R.id.linear1);
        toolbarhead = findViewById(R.id.toolbarhead);
        linearGender = findViewById(R.id.linear2);
        linearDob=findViewById(R.id.linear3);
        linearEmail=findViewById(R.id.linear4);
        linearPassword=findViewById(R.id.linear5);
        linearSignup=findViewById(R.id.lsignup);


        btnStart.setOnClickListener(this);
        btnGender.setOnClickListener(this);
        btnDob.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnPassword.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnSigup.setOnClickListener(this);

        dob = findViewById(R.id.datePicker);
        Calendar c = Calendar.getInstance();
        c.set(2000, 11, 31);//Year,Mounth -1,Day
        dob.setMaxDate(c.getTimeInMillis());
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.start:

                linearName.setVisibility(View.GONE);
                linearGender.setVisibility(View.VISIBLE);
                toolbarhead.setText("Gender");
                break;


            case R.id.second:
                linearDob.setVisibility(View.VISIBLE);
                linearGender.setVisibility(View.GONE);
                toolbarhead.setText("Birthday");


                break;

            case R.id.third:
                linearEmail.setVisibility(View.VISIBLE);
                linearDob.setVisibility(View.GONE);
                toolbarhead.setText("Email");


                break;

            case R.id.fourth:
                linearPassword.setVisibility(View.VISIBLE);
                linearEmail.setVisibility(View.GONE);
                toolbarhead.setText("Login");

            case R.id.fifth:
                linearPassword.setVisibility(View.GONE);
                linearSignup.setVisibility(View.VISIBLE);
                toolbarhead.setText("Terms & Privacy");


                break;
            case R.id.back:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btnTakeSignup:


                break;
        }
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
        if (i == R.id.rbMale) {
            ugender = "Male";
            Toast.makeText(this, "Male", Toast.LENGTH_SHORT).show();
        }
        if (i == R.id.rbFemale) {
            ugender = "Female";
            Toast.makeText(this, "Female", Toast.LENGTH_SHORT).show();
        }
        if (i == R.id.rbOther) {
            ugender = "Other";
            Toast.makeText(this, "Others", Toast.LENGTH_SHORT).show();
        }
    }
}
