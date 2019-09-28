package com.example.bokjirock;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class keywordActivity extends Fragment {
    public static keywordActivity newInstance() {
        Bundle args=new Bundle();
        keywordActivity fragment = new keywordActivity();
        fragment.setArguments(args);
        return fragment;
    }

    String key = "rdw30zhS7kTarAscsrFuTMFxGC4RKeLM69MkiAIKH9nQaTXRYtU%2FQqG3ZHQqLS4iaPvMUBPte4%2FMSApoW6j6eQ%3D%3D";
    String key_final = "http://www.bokjiro.go.kr/openapi/rest/gvmtWelSvc?crtiKey=" + key + "&callTp=L&pageNum=1&numOfRows=100";
    private ImageButton searchbtn;
    private EditText keywordtxt;
    String str = null;
    View view = null;
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.activity_keyword, container, false);
            searchbtn=view.findViewById(R.id.search_btn);
            keywordtxt=view.findViewById(R.id.keywordtxt);

            searchbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(keywordtxt.getText().toString().equals("")) {
                        Toast.makeText(getActivity().getApplicationContext(),"검색어를 입력해주세요",Toast.LENGTH_LONG).show();
                    }
                    else {
                        String str="&srchKeyCode=003&searchWrd="+keywordtxt.getText().toString();
                        String query = key_final + str;
                        Intent intent = new Intent(getActivity().getApplicationContext(), resultActivity.class);
                        Log.e("ident",query);
                        intent.putExtra("query", query);
                        startActivity(intent);
                    }
                }
            });
            return view;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);


        }

    }

