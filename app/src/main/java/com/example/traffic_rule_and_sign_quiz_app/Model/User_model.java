package com.example.traffic_rule_and_sign_quiz_app.Model;

public class User_model {

    String _id;
    String Firstname;
    String Lastname;
    String Phone;
    String Gender;
    String Dob;
    String Email;
    String Username;
    String Password;
    String Token;

    public User_model(String firstname, String lastname, String phone, String gender, String dob, String email, String username, String password, String token) {
        Firstname = firstname;
        Lastname = lastname;
        Phone = phone;
        Gender = gender;
        Dob = dob;
        Email = email;
        Username = username;
        Password = password;
        Token = token;
    }

    public User_model( String username, String password) {

        Username = username;
        Password = password;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
