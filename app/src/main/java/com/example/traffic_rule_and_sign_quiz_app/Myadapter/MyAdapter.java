package com.example.traffic_rule_and_sign_quiz_app.Myadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traffic_rule_and_sign_quiz_app.Model.Dashboard;
import com.example.traffic_rule_and_sign_quiz_app.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.Holder> {

    Context context;

    public MyAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_dashboard, parent, false);
        Holder postHolder = new Holder(view);
        return postHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class Holder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout1;


        public Holder(@NonNull View itemView) {
            super(itemView);
            linearLayout1 = itemView.findViewById(R.id.linear1);

        }
    }
}
