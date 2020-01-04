package com.nugu.jara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SleepSettingActivity extends AppCompatActivity {

    private Spinner hourSleepSpinner, minuteSleepSpinner, hourWakeUpSpinner, minuteWakeUpSpinner;
    private ArrayAdapter hourArrayAdapter, minuteArrayAdapter;
    private Button settingButton;
    private static View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        hourSleepSpinner = (Spinner)findViewById(R.id.hour_setting_sleep_spinner);
        minuteSleepSpinner = (Spinner)findViewById(R.id.minute_setting_sleep_spinner);
        hourWakeUpSpinner = (Spinner)findViewById(R.id.hour_setting_wakeup_spinner);
        minuteWakeUpSpinner = (Spinner)findViewById(R.id.minute_setting_wakeup_spinner);
        settingButton = (Button)findViewById(R.id.setting_button);

        String[] hourArray = getResources().getStringArray(R.array.hour_array);
        List<String> minuteArray = new ArrayList<>();
        for(int i = 0; i< 60; i++){
            minuteArray.add(Integer.toString(i));
        }

        hourArrayAdapter =  new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, hourArray);
        minuteArrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, minuteArray);

        hourSleepSpinner.setAdapter(hourArrayAdapter);
        minuteSleepSpinner.setAdapter(minuteArrayAdapter);
        hourWakeUpSpinner.setAdapter(hourArrayAdapter);
        minuteWakeUpSpinner.setAdapter(minuteArrayAdapter);

        final String hourSleep = hourArray[hourSleepSpinner.getSelectedItemPosition()];
        final String minuteSleep = minuteArray.get(minuteSleepSpinner.getSelectedItemPosition());
        final String hourWakeUp = hourArray[hourWakeUpSpinner.getSelectedItemPosition()];
        final String minuteWakeUp = minuteArray.get(minuteWakeUpSpinner.getSelectedItemPosition());

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Date nowDayTime = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                String nowDayTimeStr = simpleDateFormat.format(nowDayTime);
                String sleepTime = nowDayTimeStr.substring(0,9) + " "+hourSleep+":"+minuteSleep;
                String wakeUpTime = nowDayTimeStr.substring(0,9) + " "+hourSleep+":"+minuteSleep;
                ImageView lockMode = new ImageView(SleepSettingActivity.this);
                lockMode.setImageResource(R.mipmap.ic_launcher);

                WindowManager.LayoutParams windowLp = new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_BASE_APPLICATION);
                windowLp.width = WindowManager.LayoutParams.MATCH_PARENT;
                windowLp.height = WindowManager.LayoutParams.MATCH_PARENT;

                WindowManager windowManager = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
                windowManager.addView(lockMode, windowLp);
            }
        });
    }
}
