package com.example.traffic_rule_and_sign_quiz_app.ui.Aboutus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.traffic_rule_and_sign_quiz_app.R;

public class AboutUsFragment extends Fragment {

    TextView firstname, lastname, dobtext, gendertext, emailtext, phonetext, username;
    ImageView imageView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_aboutus, container, false);


        return root;
    }

}