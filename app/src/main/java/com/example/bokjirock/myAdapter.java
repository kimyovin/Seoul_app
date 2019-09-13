package com.example.bokjirock;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class myAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private ArrayList<policyInfo> policyInfoArrayList;
    private int positions;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView text_title;
        private TextView text_content;
        private TextView text_like_count;
        private TextView text_comment_count;
        private ImageButton like_button;
        private ImageButton scrap_button;

        MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            text_title = view.findViewById(R.id.tv_policyname);
            text_content = view.findViewById(R.id.tv_policycontent);
            text_like_count = view.findViewById(R.id.tv_likecount);
            text_comment_count = view.findViewById(R.id.tv_comentcount);
            like_button=view.findViewById(R.id.ib_likebutton);
            scrap_button=view.findViewById(R.id.ib_scrapbutton);
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

    public myAdapter(Context context, ArrayList<policyInfo> policyInfoArrayList) {
        this.context = context;
        this.policyInfoArrayList = policyInfoArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.frag_cardview, parent, false);
        return new MyViewHolder(v);
    }



    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        final MyViewHolder myViewHolder = (MyViewHolder) holder;
        policyInfo item = policyInfoArrayList.get(position);

        myViewHolder.text_title.setText(policyInfoArrayList.get(position).getpTitle());
        myViewHolder.text_content.setText(policyInfoArrayList.get(position).getpContent());
        myViewHolder.text_like_count.setText(policyInfoArrayList.get(position).getpLikeCount());
        myViewHolder.text_comment_count.setText(policyInfoArrayList.get(position).getpCommentCount());

//        myViewHolder.like_button.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                if(FirebaseAuth.getInstance().getCurrentUser().getUid()!=null) {
//                    v.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.like_button_on));
//                    String selected = String.valueOf(Integer.parseInt(policyInfoArrayList.get(position).pLikeCount) + 1);
//                    ((MyViewHolder) holder).text_like_count.setText(selected);
//                }
//                else
//                {
//                    Toast.makeText(context,"마음에 드신다면 로그인 후 표현해보세요",Toast.LENGTH_LONG).show();
//                }
//            }
//        });

        myViewHolder.scrap_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                v.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.scrap_star));
            }
        });
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