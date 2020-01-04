package com.example.traffic_rule_and_sign_quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traffic_rule_and_sign_quiz_app.API.User;
import com.example.traffic_rule_and_sign_quiz_app.Model.User_model;
import com.example.traffic_rule_and_sign_quiz_app.Url.Url;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener {
    private LinearLayout linearName, linearGender,linearDob,linearEmail,linearPassword,linearSignup;
    private TextView toolbarhead;
    private RelativeLayout Finish;
    private Button btnStart,btnDob,btnGender,btnEmail,btnPassword,btnBack,btnSigup,btnlogin;
   EditText fname,lname,phone,email,password,username;
    DatePicker dob;
    RadioGroup gender;

    Retrofit retrofit;

    String udob,ufname,ulname,ugender,uphone,uemail,upassword,uusername;

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
        btnSigup=findViewById(R.id.btnsignup);
        btnlogin=findViewById(R.id.login);

        fname = findViewById(R.id.firstname);
        lname = findViewById(R.id.lastname);
        gender = findViewById(R.id.rgGender);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.mobile);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);

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
        gender.setOnCheckedChangeListener(this);
        btnSigup.setOnClickListener(this);

        dob = findViewById(R.id.datePicker);
        Calendar c = Calendar.getInstance();
        c.set(2000, 11, 31);//Year,Mounth -1,Day
        dob.setMaxDate(c.getTimeInMillis());

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
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
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.start:

                String ffname = fname.getText().toString();
                String llname = lname.getText().toString();
                if (TextUtils.isEmpty(ffname) || TextUtils.isEmpty(llname)) {

                    fname.setError("Enter First Name");
                    lname.setError("Enter Last Name");
                }else
                {
                    linearName.setVisibility(View.GONE);
                    linearGender.setVisibility(View.VISIBLE);
                    toolbarhead.setText("Gender");
                    ufname = fname.getText().toString();
                    ulname=lname.getText().toString();
                }
                break;


            case R.id.second:
                if (TextUtils.isEmpty(ugender)) {
                    Toast.makeText(this, "Select Your Gender", Toast.LENGTH_SHORT).show();
                }
                else {
                    linearDob.setVisibility(View.VISIBLE);
                    linearGender.setVisibility(View.GONE);
                    toolbarhead.setText("Birthday");

                }
                break;

            case R.id.third:
                linearEmail.setVisibility(View.VISIBLE);
                linearDob.setVisibility(View.GONE);
                toolbarhead.setText("Email");
                udob= dob.getDayOfMonth()+"/"+ (dob.getMonth() + 1)+"/"+dob.getYear();


                break;


            case R.id.fourth:
                String eemail = email.getText().toString();
                String mobile = phone.getText().toString();
                if (TextUtils.isEmpty(eemail)|| TextUtils.isEmpty(mobile)) {
                    email.setError("Enter Your Email");
                    phone.setError("Enter Your Phone Number");
                }else
                {
                    linearPassword.setVisibility(View.VISIBLE);
                    linearEmail.setVisibility(View.GONE);
                    toolbarhead.setText("Login");
                    uphone = phone.getText().toString();
                    uemail= email.getText().toString();
                }

                break;
            case R.id.fifth:
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (TextUtils.isEmpty(user)|| TextUtils.isEmpty(pass)) {
                    username.setError("Enter Your Username");
                    password.setError("Enter Your Phone password");
                }else {
                    linearPassword.setVisibility(View.GONE);
                    linearSignup.setVisibility(View.VISIBLE);
                    toolbarhead.setText("Terms & Privacy");
                    uusername = username.getText().toString();
                    upassword= password.getText().toString();
                }
                break;
            case R.id.back:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btnsignup:
                Register();

                break;
        }

    }
    private void Register() {

        User_model user_model = new User_model(ufname,ulname,uphone,ugender,udob,uemail,uusername,upassword,"");

        User userapi = Url.getInstance().create(User.class);
        Call<Void> signUpCall = userapi.registerUser(user_model);

        signUpCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(RegisterActivity.this, "Registered", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }


        });

    }

}
