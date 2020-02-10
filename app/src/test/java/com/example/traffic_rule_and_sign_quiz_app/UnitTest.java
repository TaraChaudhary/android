package com.example.traffic_rule_and_sign_quiz_app;

import com.example.traffic_rule_and_sign_quiz_app.API.User;
import com.example.traffic_rule_and_sign_quiz_app.Methods.LoginRegister;
import com.example.traffic_rule_and_sign_quiz_app.Model.Signal;
import com.example.traffic_rule_and_sign_quiz_app.Model.User_model;
import com.example.traffic_rule_and_sign_quiz_app.Url.Url;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;

public class UnitTest {
    LoginRegister loginRegister=null;
    @Before
    public void start_up(){
        loginRegister = new LoginRegister();
    }
    @Test
    public void testlogin()
    {

        User_model userModel=new User_model("tara","tara");
        assertTrue(loginRegister.userLogin(userModel));
    }

    @Test
    public void testregister()
    {

        User_model userModel=new User_model("","tara","chaudhary","9817509910","Male",
                "2","iamtarachaudhary@gmail.com","tara","tara","tara","");
        assertTrue(loginRegister.registerUser(userModel));
    }

    @Test
    public void testupdate()
    {

        User_model userModel=new User_model("tara","chaudhary","9817509910","9817509910","admin","asd");
        assertTrue(loginRegister.updateuser("5e41070b4d639d3188b38db0",userModel));
    }

    @Test
    public void testSignal()
    {
        Signal signal=new Signal("turn right","turn right","as");
             assertTrue(loginRegister.addSignal(signal));
    }

    @After
    public void wrap_up(){
        loginRegister = null;
    }


}
