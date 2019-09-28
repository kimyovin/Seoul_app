package com.example.bokjirock;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class searchActivity extends Fragment {
    private Button btnFinish;
    private Spinner spinner1, spinner2, spinner3, spinner4, spinnerAge;
    private String sAge, sTarget, sTypeObs, sLevelObs, sTypeHome;
    private String key = "rdw30zhS7kTarAscsrFuTMFxGC4RKeLM69MkiAIKH9nQaTXRYtU%2FQqG3ZHQqLS4iaPvMUBPte4%2FMSApoW6j6eQ%3D%3D";
    private String str = null;

    CheckBox typeALL, type00, type01, type02, type03, type04, type05,type06,type07, type08, type09, type0A;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_search, container, false);

        btnFinish = view.findViewById(R.id.btnFinish);  // 검색버튼
        spinnerAge = view.findViewById(R.id.spinnerAge);  // 나이

        spinner1 = view.findViewById(R.id.spinner1);      // 대상특성 여성, 임산부, 장애, ..
        spinner2 = view.findViewById(R.id.spinner2);      // 장애 클릭시 지체...시각, 청각..등등
        spinner3 = view.findViewById(R.id.spinner3);      // 장애 클릭시 몇급인지
        spinner4 = view.findViewById(R.id.spinner4);      // 가구 유형 한부모, 다문화, 조손 등등

        switch (spinnerAge.getSelectedItem().toString()) {
            case "영유아":
                sAge = "001";
                break;
            case "아동":
                sAge = "002";
                break;
            case "청소년":
                sAge = "003";
                break;
            case "청년":
                sAge = "004";
                break;
            case "중장년":
                sAge = "005";
                break;
            case "노년":
                sAge = "006";
                break;
            default:
                sAge = "ALL";
                break;
        }
        Log.e("확인1",sAge);


        switch (spinner1.getSelectedItem().toString()) {
            case "해당없음":
                sTarget = "001";
                break;
            case "여성":
                sTarget = "002";
                break;
            case "임산부":
                sTarget = "003";
                break;
            case "장애":
                sTarget = "004";
                break;
            case "국가유공자등 보훈대상자":
                sTarget = "005";
                break;
            case "실업자":
                sTarget = "006";
                break;
            default:
                sTarget = "ALL";
                break;
        }
        Log.e("확인2",sTarget);


        switch (spinner2.getSelectedItem().toString()) {
            case "지체":
                sTypeObs = "10";
                break;
            case "시각":
                sTypeObs = "20";
                break;
            case "청각":
                sTypeObs = "30";
                break;
            case "언어":
                sTypeObs = "40";
                break;
            case "지적":
                sTypeObs = "50";
                break;
            case "뇌병변":
                sTypeObs = "60";
                break;
            case "자폐성":
                sTypeObs = "70";
                break;
            case "정신":
                sTypeObs = "80";
                break;
            case "신장":
                sTypeObs = "90";
                break;
            case "심장":
                sTypeObs = "A0";
                break;
            case "호흡기":
                sTypeObs = "B0";
                break;
            case "간":
                sTypeObs = "C0";
                break;
            case "안면":
                sTypeObs = "D0";
                break;
            case "장루":
                sTypeObs = "E0";
                break;
            case "간질":
                sTypeObs = "F0";
                break;
            default:
                sTypeObs = "NULL";
                break;
        }
        Log.e("확인3",sTypeObs);


        switch (spinner3.getSelectedItem().toString()) {
            case "1급":
                sLevelObs = "1";
                break;
            case "2급":
                sLevelObs = "2";
                break;
            case "3급":
                sLevelObs = "3";
                break;
            case "4급":
                sLevelObs = "4";
                break;
            case "5급":
                sLevelObs = "5";
                break;
            case "6급":
                sLevelObs = "6";
                break;
            default:
                sLevelObs = "NULL";
                break;
        }


        switch (spinner4.getSelectedItem().toString()) {
            case "해당없음":
                sTypeHome = "001";
                break;
            case "한부모":
                sTypeHome = "002";
                break;
            case "다문화":
                sTypeHome = "003";
                break;
            case "조손":
                sTypeHome = "004";
                break;
            case "새터민":
                sTypeHome = "005";
                break;
            case "소년소녀가장":
                sTypeHome = "006";
                break;
            case "독거노인":
                sTypeHome = "007";
                break;
            default:
                sTypeHome = "ALL";
                break;

        }

        typeALL = view.findViewById(R.id.typeALL);
        type00 = view.findViewById(R.id.type00);
        type01 = view.findViewById(R.id.type01);
        type02 = view.findViewById(R.id.type02);
        type03 = view.findViewById(R.id.type03);
        type04 = view.findViewById(R.id.type04);
        type05 = view.findViewById(R.id.type05);
        type06 = view.findViewById(R.id.type06);
        type07 = view.findViewById(R.id.type07);
        type08 = view.findViewById(R.id.type08);
        type09 = view.findViewById(R.id.type09);
        type0A = view.findViewById(R.id.type0A);


        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String option1, option2, option3, option4, option5;

                if (sAge.equals("ALL")) {
                    option1 = "";
                } else {
                    option1 = "&lifeArray=" + sAge;
                }
                if (sTarget.equals("ALL")) {
                    option2 = "";
                } else {
                    option2 = "&charTrgterArray=" + sTarget;
                }
                if (sTypeObs.equals("NULL")) {
                    option3 = "";
                } else {
                    option3 = "&obstKiArray=" + sTypeObs;
                }
                if (sLevelObs.equals("NULL")) {
                    option4 = "";
                } else {
                    option4 = "&obstLvArray=" + sLevelObs;
                }
                if (sTypeHome.equals("ALL")) {
                    option5 = "";
                } else {
                    option5 = "&trgterIndvdlArray=" + sTypeHome;
                }

                String typeUrl="";

                if(typeALL.isChecked()){
                    typeUrl.concat("");
                }else if (type00.isChecked()){
                    typeUrl.concat("&desireArray=0000000");
                }else if (type01.isChecked()){
                    typeUrl.concat("&desireArray=1000000");
                }else if (type02.isChecked()){
                    typeUrl.concat("&desireArray=2000000");
                }else if (type03.isChecked()){
                    typeUrl.concat("&desireArray=3000000");
                }else if (type04.isChecked()){
                    typeUrl.concat("&desireArray=4000000");
                }else if (type05.isChecked()){
                    typeUrl.concat("&desireArray=5000000");
                }else if (type06.isChecked()){
                    typeUrl.concat("&desireArray=6000000");
                }else if (type07.isChecked()){
                    typeUrl.concat("&desireArray=7000000");
                }else if (type08.isChecked()){
                    typeUrl.concat("&desireArray=8000000");
                }else if (type09.isChecked()){
                    typeUrl.concat("&desireArray=9000000");
                }else if (type0A.isChecked()){
                    typeUrl.concat("&desireArray=A000000");
                }else{ }

                str = "http://www.bokjiro.go.kr/openapi/rest/gvmtWelSvc?crtiKey=" + key + "&callTp=L&pageNum=1&numOfRows=100";
//                "http://www.bokjiro.go.kr/openapi/rest/gvmtWelSvc"//요청 URL
//               +"&callTp=L&pageNum=1&numOfRows=10&desireArray=0000000"+
//                "&ServiceKey="+key;

                String query = str + option1 + option2 + option3 + option4 + option5+ typeUrl;

                Intent intent = new Intent(getActivity().getApplicationContext(), resultActivity.class);
                Log.e("요청",query);
                intent.putExtra("query", query);
                startActivity(intent);

                getActivity().finish();


            }
        });

        return view;
    }

}
