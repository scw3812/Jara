package com.nugu.jara;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TimePicker;

public class SleepSettingActivity extends AppCompatActivity {

    private TimePicker sleepTimePicker;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_setting);

        sleepTimePicker = (TimePicker)findViewById(R.id.setting_sleep_time_picker);
        nextButton = (Button)findViewById(R.id.setting_next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                int hour = sleepTimePicker.getHour();
                int minute = sleepTimePicker.getMinute();
                int[] timeArr = {hour, minute};

                Intent intent = new Intent(SleepSettingActivity.this, WakeUpSettingActivity.class);
                intent.putExtra("sleep_time", timeArr);
                startActivity(intent);

//                ImageView lockMode = new ImageView(SleepSettingActivity.this);
//                lockMode.setImageResource(R.mipmap.ic_launcher);
//
//                WindowManager.LayoutParams windowLp = new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_BASE_APPLICATION);
//                windowLp.width = WindowManager.LayoutParams.MATCH_PARENT;
//                windowLp.height = WindowManager.LayoutParams.MATCH_PARENT;
//
//                WindowManager windowManager = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
//                windowManager.addView(lockMode, windowLp);
            }
        });
    }
}
