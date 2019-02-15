package com.example.notiftest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class TimeOutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeout);

        Intent intent4mTO = getIntent();
        String timeAndCurrentApp = intent4mTO.getStringExtra("timeAndCurrentApp");
        Log.d("int mess", timeAndCurrentApp);
        List<String> timeAppLst = Arrays.asList(timeAndCurrentApp.split(","));
        String time_spent = timeAppLst.get(0);
        String app_used = timeAppLst.get(1);

        //time spent text update
        TextView textViewTS = (TextView)findViewById(R.id.timeSpent);
        textViewTS.setText(time_spent);

        //app name text update
        TextView textViewCA = (TextView)findViewById(R.id.curApp);
        textViewCA.setText(app_used);

        //button tasks
        final Button button1 = findViewById(R.id.moreTimeButton);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Close activity, continue using cur app (maybe?)
                finish();
            }
        });



    }
}
