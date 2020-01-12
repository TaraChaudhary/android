package com.example.traffic_rule_and_sign_quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.traffic_rule_and_sign_quiz_app.Model.Dashboard;
import com.example.traffic_rule_and_sign_quiz_app.Myadapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewDashboardActivity extends Fragment {
    private RecyclerView view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =inflater.inflate(R.layout.activity_view_dashboard, container, false);
        view = root.findViewById(R.id.list);
        MyAdapter adapter = new MyAdapter(getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        view.setLayoutManager(layoutManager);
        view.setAdapter(adapter);
        return root;
    }

}