package com.example.traffic_rule_and_sign_quiz_app.Model;

import android.widget.EditText;

public class Signal {

    String name;
    String image;

    public Signal(String name, String image) {
        this.name = name;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
