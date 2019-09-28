package com.example.bokjirock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class introActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_activity);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(introActivity.this, MainActivity.class);
                startActivity(intent);
                // 뒤로가기 했을경우 안나오도록 없애주기 >> finish!!
                finish();
            }
        }, 2000);
    }
}
