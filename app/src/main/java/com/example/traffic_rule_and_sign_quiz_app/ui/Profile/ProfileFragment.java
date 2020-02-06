package com.example.traffic_rule_and_sign_quiz_app.ui.Profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.traffic_rule_and_sign_quiz_app.API.User;
import com.example.traffic_rule_and_sign_quiz_app.Methods.Strick;
import com.example.traffic_rule_and_sign_quiz_app.Model.User_model;
import com.example.traffic_rule_and_sign_quiz_app.R;
import com.example.traffic_rule_and_sign_quiz_app.Url.Url;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Response;

public class ProfileFragment extends Fragment {
    String id, token;
    SharedPreferences prfs;

    TextView firstname,lastname, dobtext, gendertext, emailtext, phonetext,username;
    ImageView imageView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        firstname = root.findViewById(R.id.fname);
        lastname = root.findViewById(R.id.lname);
        dobtext = root.findViewById(R.id.dob);
        gendertext =root. findViewById(R.id.gender);
        username=root.findViewById(R.id.username);
        emailtext = root.findViewById(R.id.email);
        phonetext = root.findViewById(R.id.phone);
        imageView = root.findViewById(R.id.recievedimage);

        prfs = getContext().getSharedPreferences("session", Context.MODE_PRIVATE);
        id = prfs.getString("id", "");
        token = prfs.getString("token", "");

        User_model user = getDetails(token,id);
        firstname.setText(user.getFirstname());
        Picasso.get().load(Url.imagePath+user.getImage()).into(imageView);



        return root;
    }

    private User_model getDetails(String token, String id){
        User api = Url.getInstance().create(User.class);
        Call<User_model> call = api.getUserDetails(token, id);
        Strick.StrictMode();
        try {
            Response<User_model> response = call.execute();
            if(response.isSuccessful()){
                return response.body();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}