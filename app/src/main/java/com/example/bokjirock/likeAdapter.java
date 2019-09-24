package com.example.bokjirock;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class likeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private ArrayList<policyInfo> policyInfoArrayList;
    private int positions;
    private likeDBHelper helper;
    private policyInfo item;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView text_title;
        private TextView text_content;
        private ImageButton delete_button;

        MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            text_title = view.findViewById(R.id.tv_policyname);
            text_content = view.findViewById(R.id.tv_policycontent);
            delete_button=view.findViewById(R.id.ib_deletebtn);
            delete_button.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = getAdapterPosition() ;
                    if (pos != RecyclerView.NO_POSITION) {
                        positions=getAdapterPosition();
                        helper.delete(policyInfoArrayList.get(pos).getId());
                        Toast.makeText(context,"관심정책에서 삭제합니다.",Toast.LENGTH_LONG).show();
                        policyInfoArrayList.remove(positions);
                        notifyDataSetChanged();
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {
            positions=getAdapterPosition();
            String add=getdetailnum(policyInfoArrayList,positions);
            Intent intent=new Intent(context, detailInfo.class);
            intent.putExtra("address",add);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public likeAdapter(Context context, ArrayList<policyInfo> policyInfoArrayList) {
        this.context = context;
        this.policyInfoArrayList = policyInfoArrayList;
        helper=new likeDBHelper(context, "Likes.db", null, 1);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.frag_cardview_like, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        final MyViewHolder myViewHolder = (MyViewHolder) holder;
        item = policyInfoArrayList.get(position);

        myViewHolder.text_title.setText(policyInfoArrayList.get(position).getpTitle());
        myViewHolder.text_content.setText(policyInfoArrayList.get(position).getpContent());
    }

    @Override
    public int getItemCount() {
        return policyInfoArrayList.size();
    }

    public String getdetailnum(List<policyInfo> policyInfos, int position) {

        List<policyInfo> policyInfos1 = policyInfos;

        String address= policyInfos1.get(position).getId();
        return address;
    }
}