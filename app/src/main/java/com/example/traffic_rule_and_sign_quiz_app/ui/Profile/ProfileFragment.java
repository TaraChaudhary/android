package com.example.traffic_rule_and_sign_quiz_app.ui.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.traffic_rule_and_sign_quiz_app.R;

public class ProfileFragment extends Fragment {


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



        return root;
    }

}