package com.example.traffic_rule_and_sign_quiz_app.API;

import com.example.traffic_rule_and_sign_quiz_app.Model.User_model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface User {
    @POST("signup")
    Call<Void> registerUser(@Body User_model user);

}
