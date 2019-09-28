package com.example.bokjirock;

import androidx.fragment.app.Fragment;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.acl.LastOwnerException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static android.content.Context.MODE_PRIVATE;


public class Fragment2 extends Fragment {
    private likeDBHelper helper;
    private Thread apiThread;
    AssetManager assetManager;
    private policyInput policyInput;
    private RecyclerView.LayoutManager LayoutManager1;
    private RecyclerView recyclerView1;
    private ArrayList<policyInput> policyInputArrayList;
    private ArrayList<policyInfo> policyInfoArrayList;
    private likeAdapter madapter;
    private static boolean signal=false;


    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message message) {
            switch (message.what) {
                case 101:
                    makePolicyInfo(policyInputArrayList);
                    recyclerView1.setAdapter(madapter);
                    break;
                case 102:
                    //오류
                    Toast.makeText(getContext(), (String) message.obj, Toast.LENGTH_SHORT).show();
                    break;
                case 103:
                    recyclerView1.setAdapter(new myAdapter(getContext(),policyInfoArrayList));
                    break;
            }
            return true;
        }
    });

    public static Fragment2 newInstance(String sig) {
        Bundle args=new Bundle();
        Fragment2 fragment = new Fragment2();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        policyInfoArrayList=new ArrayList<policyInfo>();
        policyInputArrayList = new ArrayList<>();
        madapter=new likeAdapter(getContext(),policyInfoArrayList);
        helper=new likeDBHelper(getContext(), "Likes.db", null, 1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment1, container, false);
        Log.e("안녕1","프래2");
        LayoutManager1 = new LinearLayoutManager(view.getContext());
        recyclerView1 = view.findViewById(R.id.recycle_view1);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(LayoutManager1);
        getsubwayApi();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        if (apiThread != null) {
            if (apiThread.isAlive()) {
                apiThread.interrupt();
            }
            apiThread = null;
        }
        super.onStop();
    }

    private void getsubwayApi() {
        Log.e("아아","11");
        policyInputArrayList.clear();
        apiThread = initgetAPiThread();
        apiThread.start();
    }

    private Thread initgetAPiThread() {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = mHandler.obtainMessage();
                String result=helper.getallResult();
                if(!result.equals("")) {
                    Log.e("확인1", result);
                    String policy[] = result.split(";");
                    for (int i = 0; i < policy.length; i++) {
                        policyInputArrayList.add(new policyInput(policy[i].split("&")[0], policy[i].split("&")[1], policy[i].split("&")[2]));
                    }
                    msg.what = 101;
                }
                else{
                    msg.what=103;
                }
                    mHandler.sendMessage(msg);
            }
        });
    }

    private void makePolicyInfo(ArrayList<policyInput> policyInputArrayList){
        for(int i=0;i<policyInputArrayList.size();i++) {
            String ServDgst = policyInputArrayList.get(i).getServDgst().replaceAll("[<>br/]", "");
            Log.e("여기11",ServDgst);
            policyInfoArrayList.add(new policyInfo(policyInputArrayList.get(i).getServNm(), ServDgst, "0", "0", policyInputArrayList.get(i).getServId()));
        }
    }
}