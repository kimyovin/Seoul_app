package com.example.bokjirock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

//import com.example.bokjirock.databinding.ActivityCategoryBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class categoryActivity extends Activity implements MenuItem.OnMenuItemClickListener{
    ImageButton category00, category01, category02, category03, category04, category05, category06, category07, category08, category09,  category0A,  category0B;
    BottomNavigationView navigation;

    String key = "rdw30zhS7kTarAscsrFuTMFxGC4RKeLM69MkiAIKH9nQaTXRYtU%2FQqG3ZHQqLS4iaPvMUBPte4%2FMSApoW6j6eQ%3D%3D";
    String key_final = "http://www.bokjiro.go.kr/openapi/rest/gvmtWelSvc?crtiKey=" + key + "&callTp=L&pageNum=1&numOfRows=100";
    String str = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        //ActivityCategoryBinding layout = DataBindingUtil.setContentView(this, R.layout.activity_category);


        category00 = findViewById(R.id.category00);
        category01 = findViewById(R.id.category01);
        category02 = findViewById(R.id.category02);
        category03 = findViewById(R.id.category03);
        category04 = findViewById(R.id.category04);
        category05 = findViewById(R.id.category05);
        category06 = findViewById(R.id.category06);
        category07 = findViewById(R.id.category07);
        category08 = findViewById(R.id.category08);
        category09 = findViewById(R.id.category09);
        category0A = findViewById(R.id.category0A);
        category0B = findViewById(R.id.category0B);
        navigation = findViewById(R.id.navigation);

        BottomNavigationView navigation = findViewById(R.id.navigation);

//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);  //하단바 리스너 설정
  //      BottomNavigationViewHelper.disableShiftMode(navigation);    //하단바 viewHelper 설정

        // 상대적 시도해보자. 재윤 0911
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        Log.v("알림", "height: " + height + "  width: " + width);
        
        //안전
        category00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "&desireArray=0000000";

                String query = key_final + str;

                Intent intent = new Intent(getApplicationContext(), resultActivity.class);
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

                Intent intent = new Intent(getApplicationContext(), resultActivity.class);
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

                Intent intent = new Intent(getApplicationContext(), resultActivity.class);
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

                Intent intent = new Intent(getApplicationContext(), resultActivity.class);
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

                Intent intent = new Intent(getApplicationContext(), resultActivity.class);
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

                Intent intent = new Intent(getApplicationContext(), resultActivity.class);
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

                Intent intent = new Intent(getApplicationContext(), resultActivity.class);
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

                Intent intent = new Intent(getApplicationContext(), resultActivity.class);
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

                Intent intent = new Intent(getApplicationContext(), resultActivity.class);
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

                Intent intent = new Intent(getApplicationContext(),resultActivity.class);
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

                Intent intent = new Intent(getApplicationContext(), resultActivity.class);
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

                Intent intent = new Intent(getApplicationContext(), resultActivity.class);
                intent.putExtra("query", query);
                startActivity(intent);
            }
        });

    }


    //하단바 메뉴에 대한 intent 설정
    public boolean onMenuItemClick(MenuItem menuItem) {
        if(menuItem.getItemId() == R.id.navigation_home){   //1번째 하단바 메뉴
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId() == R.id.navigation_dashboard){  //2번째 하단바 메뉴
            Intent intent = new Intent(this, searchActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId() == R.id.navigation_notifications){  //3번째 하단바 메뉴
            Intent intent = new Intent(this, categoryActivity.class);
            startActivity(intent);
        }
//        if (menuItem.getItemId() == R.id.navigation_search) {   //4번째 하단바 메뉴
//            Intent intent = new Intent(this, signin.class);
//            startActivity(intent);
//            //    finish();
//            return true;
//        }
        return false;
    }

    //하단바 리스너
    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            onMenuItemClick(item);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    // mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    // mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_search:
                    // mTextMessage.setText("Login");
                    return true;
            }
            return false;
        }
    };


}
