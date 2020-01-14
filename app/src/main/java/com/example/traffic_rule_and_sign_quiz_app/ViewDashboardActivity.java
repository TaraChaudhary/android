package com.example.traffic_rule_and_sign_quiz_app;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.traffic_rule_and_sign_quiz_app.Fragment.ExampleFragment;
import com.example.traffic_rule_and_sign_quiz_app.Myadapter.MyAdapter;
import com.example.traffic_rule_and_sign_quiz_app.Practice.QuestionActivity;

public class ViewDashboardActivity extends Fragment {
    private RecyclerView view;
    LinearLayout practice1,example1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =inflater.inflate(R.layout.activity_view_dashboard, container, false);


        practice1=root.findViewById(R.id.practice);
        example1=root.findViewById(R.id.example);

        practice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),QuestionActivity.class);
                startActivity(intent);
            }
        });

        example1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment select=new ExampleFragment();
            }
        });

        return root;


    }




}