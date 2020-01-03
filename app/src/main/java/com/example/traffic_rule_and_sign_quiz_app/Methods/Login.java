package com.example.traffic_rule_and_sign_quiz_app.Methods;

import android.util.Log;

import com.example.traffic_rule_and_sign_quiz_app.API.User;
import com.example.traffic_rule_and_sign_quiz_app.Model.User_model;
import com.example.traffic_rule_and_sign_quiz_app.Url.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class Login {

    boolean isloggedIn=false;

    public boolean userLogin(User_model login)
    {
        User user= Url.getInstance().create(User.class);
        Call<User_model> userCall=user.userLogin(login);
        //Strick.StrictMode();

        try {
            Response<User_model>loginResponse=userCall.execute();

            if (loginResponse.isSuccessful())
            {
                isloggedIn=true;

                Url.token +=loginResponse.body().getToken();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("Myex:", e.getMessage());
        }
        return isloggedIn;
    }
}
