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
import android.widget.TextView;

import com.example.traffic_rule_and_sign_quiz_app.Fragment.ExampleFragment;
import com.example.traffic_rule_and_sign_quiz_app.Myadapter.MyAdapter;
import com.example.traffic_rule_and_sign_quiz_app.Practice.QuestionActivity;
import com.example.traffic_rule_and_sign_quiz_app.Practice.ResultActivity;

public class ViewDashboardActivity extends Fragment {
    private RecyclerView view;
    LinearLayout practice1,example1,score1, linearLayout;

    TextView textView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root =inflater.inflate(R.layout.activity_view_dashboard, container, false);

    linearLayout=root.findViewById(R.id.lineara);
    textView=root.findViewById(R.id.toolbarhead);
        practice1=root.findViewById(R.id.practice);
        example1=root.findViewById(R.id.example);
        score1=root.findViewById(R.id.score);

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

                   linearLayout.setVisibility(View.GONE);
                   textView.setText("Example");

                setFragment(new ExampleFragment());

            }
        });

        score1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(), ResultActivity.class);
                startActivity(intent1);
            }
        });

        return root;


    }
    public boolean setFragment(Fragment fragment){
        if(fragment != null)
        {
            getChildFragmentManager().beginTransaction().replace(R.id.linearlayout,fragment).commit();
            return true;
        }
        return false;
    }




}