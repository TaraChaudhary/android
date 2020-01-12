package com.example.traffic_rule_and_sign_quiz_app.Model;

public class Dashboard {
    String _id;
    String name;
    int image;

    public Dashboard(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
