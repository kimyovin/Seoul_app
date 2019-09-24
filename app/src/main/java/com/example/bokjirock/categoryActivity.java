package com.example.bokjirock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

//import com.example.bokjirock.databinding.ActivityCategoryBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class categoryActivity extends Fragment {
    ImageButton category00, category01, category02, category03, category04, category05, category06, category07, category08, category09,  category0A,  category0B;


    String key = "rdw30zhS7kTarAscsrFuTMFxGC4RKeLM69MkiAIKH9nQaTXRYtU%2FQqG3ZHQqLS4iaPvMUBPte4%2FMSApoW6j6eQ%3D%3D";
    String key_final = "http://www.bokjiro.go.kr/openapi/rest/gvmtWelSvc?crtiKey=" + key + "&callTp=L&pageNum=1&numOfRows=100";
    String str = null;
    View view = null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_category, container, false);

        category00 = view.findViewById(R.id.category00);
        category01 = view.findViewById(R.id.category01);
        category02 = view.findViewById(R.id.category02);
        category03 = view.findViewById(R.id.category03);
        category04 = view.findViewById(R.id.category04);
        category05 = view.findViewById(R.id.category05);
        category06 = view.findViewById(R.id.category06);
        category07 = view.findViewById(R.id.category07);
        category08 = view.findViewById(R.id.category08);
        category09 = view.findViewById(R.id.category09);
        category0A = view.findViewById(R.id.category0A);
        category0B = view.findViewById(R.id.category0B);



        //안전
        category00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "&desireArray=0000000";

                String query = key_final + str;

                Intent intent = new Intent(getActivity().getApplicationContext(), resultActivity.class);
                intent.putExtra("query", query);
                startActivity(intent);
            }
        });

        //건강
        category01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "&desireArray=1000000";

                String query = key_final + str;

                Intent intent = new Intent(getActivity().getApplicationContext(), resultActivity.class);
                intent.putExtra("query", query);
                startActivity(intent);
            }
        });

        //가족
        category02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "&desireArray=3000000";

                String query = key_final + str;

                Intent intent = new Intent(getActivity().getApplicationContext(), resultActivity.class);
                intent.putExtra("query", query);
                startActivity(intent);
            }
        });

        //경제
        category03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "&desireArray=5000000";

                String query = key_final + str;

                Intent intent = new Intent(getActivity().getApplicationContext(), resultActivity.class);
                intent.putExtra("query", query);
                startActivity(intent);
            }
        });

        //교육
        category04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "&desireArray=6000000";

                String query = key_final + str;

                Intent intent = new Intent(getActivity().getApplicationContext(), resultActivity.class);
                intent.putExtra("query", query);
                startActivity(intent);
            }
        });

        //고용
        category05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "&desireArray=7000000";

                String query = key_final + str;

                Intent intent = new Intent(getActivity().getApplicationContext(), resultActivity.class);
                intent.putExtra("query", query);
                startActivity(intent);
            }
        });

        //법
        category06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "&desireArray=9000000";

                String query = key_final + str;

                Intent intent = new Intent(getActivity().getApplicationContext(), resultActivity.class);
                intent.putExtra("query", query);
                startActivity(intent);
            }
        });

        //한부모
        category07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "&trgterIndvdlArray=002";

                String query = key_final + str;

                Intent intent = new Intent(getActivity().getApplicationContext(), resultActivity.class);
                intent.putExtra("query", query);
                startActivity(intent);
            }
        });


        //임산부
        category08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "&charTrgterArray=003";

                String query = key_final + str;

                Intent intent = new Intent(getActivity().getApplicationContext(), resultActivity.class);
                intent.putExtra("query", query);
                startActivity(intent);
            }
        });

        //장애
        category09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "&charTrgterArray=004";

                String query = key_final + str;

                Intent intent = new Intent(getActivity().getApplicationContext(),resultActivity.class);
                intent.putExtra("query", query);
                startActivity(intent);
            }
        });

        //다문화
        category0A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "&trgterIndvdlArray=003";

                String query = key_final + str;

                Intent intent = new Intent(getActivity().getApplicationContext(), resultActivity.class);
                intent.putExtra("query", query);
                startActivity(intent);
            }
        });

        //독거노인
        category0B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "&trgterIndvdlArray=007";

                String query = key_final + str;

                Intent intent = new Intent(getActivity().getApplicationContext(), resultActivity.class);
                intent.putExtra("query", query);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_category);


    }

}
