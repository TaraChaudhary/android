package com.example.traffic_rule_and_sign_quiz_app.ui.Profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.traffic_rule_and_sign_quiz_app.Methods.LoginRegister;
import com.example.traffic_rule_and_sign_quiz_app.Methods.Strick;
import com.example.traffic_rule_and_sign_quiz_app.Model.User_model;
import com.example.traffic_rule_and_sign_quiz_app.R;
import com.example.traffic_rule_and_sign_quiz_app.Url.Url;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {
    String id, token;
    SharedPreferences prfs;
    User_model model;
    LoginRegister loginRegister = new LoginRegister();

    TextView firstname, lastname, dobtext, gendertext, emailtext, phonetext, username,fname;
   CircleImageView imageView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        firstname = root.findViewById(R.id.firstname);
        lastname = root.findViewById(R.id.lastname);
        dobtext = root.findViewById(R.id.dob1);
        gendertext = root.findViewById(R.id.gender);
        username = root.findViewById(R.id.username);
        emailtext = root.findViewById(R.id.email1);
        phonetext = root.findViewById(R.id.phone1);
        fname=root.findViewById(R.id.fname);
        imageView = root.findViewById(R.id.post_profileimg);

        prfs = getContext().getSharedPreferences("session", Context.MODE_PRIVATE);
        id = prfs.getString("id", "");
        token = prfs.getString("token", "");
     //   Toast.makeText(getContext(), token + id, Toast.LENGTH_SHORT).show();
        model = loginRegister.userDetail(id, token);
        firstname.setText(model.getFirstname());
        username.setText(model.getUsername());
        fname.setText(model.getFirstname()+ model.getLastname());


        Strick.StrictMode();

        try {
            URL url = new URL(Url.imagePath + model.getImage());
            imageView.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return root;
    }


}