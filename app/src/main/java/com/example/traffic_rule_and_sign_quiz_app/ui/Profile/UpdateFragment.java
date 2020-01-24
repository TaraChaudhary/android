package com.example.traffic_rule_and_sign_quiz_app.ui.Profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.traffic_rule_and_sign_quiz_app.Methods.LoginRegister;
import com.example.traffic_rule_and_sign_quiz_app.Methods.Strick;
import com.example.traffic_rule_and_sign_quiz_app.Model.User_model;
import com.example.traffic_rule_and_sign_quiz_app.R;
import com.example.traffic_rule_and_sign_quiz_app.Url.Url;

import java.io.InputStream;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;

public class UpdateFragment extends Fragment {
    String id, token;
    SharedPreferences prfs;
    User_model model;
    LoginRegister loginRegister = new LoginRegister();
    TextView fname1,user;
    EditText firstname1, lastname1, dobtext, gendertext, emailtext, phonetext, username;
    CircleImageView imageView;
    RelativeLayout relativeLayout;
    Button back,update;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_update, container, false);
        firstname1 = root.findViewById(R.id.first);
        lastname1 = root.findViewById(R.id.last);
        user=root.findViewById(R.id.username);
        username = root.findViewById(R.id.username1);
        emailtext = root.findViewById(R.id.email1);
        phonetext = root.findViewById(R.id.phone1);
        fname1 = root.findViewById(R.id.fname1);
        //     edit=root.findViewById(R.id.edit);
        imageView = root.findViewById(R.id.post_profileimg);
        relativeLayout = root.findViewById(R.id.relative1);
        back=root.findViewById(R.id.back);



        prfs = getContext().getSharedPreferences("session", Context.MODE_PRIVATE);
        id = prfs.getString("id", "");
        token = prfs.getString("token", "");
        //   Toast.makeText(getContext(), token + id, Toast.LENGTH_SHORT).show();
        model = loginRegister.userDetail(id, token);
        firstname1.setText(model.getFirstname());
        username.setText(model.getUsername());
        user.setText(model.getUsername());
        fname1.setText(model.getFirstname() + " " + model.getLastname());
//        gendertext.setText(model.getGender());
        emailtext.setText(model.getEmail());
        lastname1.setText(model.getLastname());
        phonetext.setText(model.getPhone());
   //     dobtext.setText(model.getDob());


        Strick.StrictMode();

        try {
            URL url = new URL(Url.imagePath + model.getImage());
            imageView.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setVisibility(View.GONE);
                setFragment(new ProfileFragment());
            }
        });
        return root;
    }

    public boolean setFragment(Fragment fragment) {
        if (fragment != null) {
            getChildFragmentManager().beginTransaction().replace(R.id.relative, fragment).commit();
            return true;
        }
        return false;
    }
}



