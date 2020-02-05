package com.example.traffic_rule_and_sign_quiz_app.Fragment;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traffic_rule_and_sign_quiz_app.Adapter.MyAdapter;
import com.example.traffic_rule_and_sign_quiz_app.Methods.LoginRegister;
import com.example.traffic_rule_and_sign_quiz_app.Model.Signal;
import com.example.traffic_rule_and_sign_quiz_app.R;

import java.util.List;

public class StepFragment extends Fragment {
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener listener;
    TextView textView;


        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view =inflater.inflate(R.layout.fragment_step, container, false);
            textView= view.findViewById(R.id.helps);



            return  view;
        }

        public boolean setFragment(Fragment fragment){
            if(fragment != null)
            {
                getChildFragmentManager().beginTransaction().replace(R.id.relative,fragment).commit();
                return true;
            }
            return false;
        }





    }

