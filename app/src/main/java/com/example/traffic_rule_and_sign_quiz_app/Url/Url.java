package com.example.traffic_rule_and_sign_quiz_app.Url;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Url{

    private static final String BASE_URL="http://10.0.2.2:5000/";
    public static String token="Bearer ";
    public static String id="";
    public static String imagePath = "http://10.0.2.2:5000/uploads/" ;
    public static Retrofit getInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Url.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
