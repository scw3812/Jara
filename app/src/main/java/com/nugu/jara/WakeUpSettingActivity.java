package com.nugu.jara;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;

public class WakeUpSettingActivity extends AppCompatActivity {

    private TimePicker wakeUpTimePicker;
    private Button settingButton;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wake_up_setting);

        Intent receiveIntent = getIntent();
        final int[] sleepTimeArr = receiveIntent.getIntArrayExtra("sleep_time");

        wakeUpTimePicker = (TimePicker)findViewById(R.id.setting_wake_up_time_picker);
        settingButton = (Button)findViewById(R.id.setting_button);

        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        final Calendar calendar = Calendar.getInstance();

        settingButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                calendar.set(Calendar.HOUR_OF_DAY, sleepTimeArr[0]);
                calendar.set(Calendar.MINUTE, sleepTimeArr[1]);

                Intent intent = new Intent(WakeUpSettingActivity.this, AlarmReceiver.class);
                intent.putExtra("state", "alarm on");

                pendingIntent = PendingIntent.getBroadcast(WakeUpSettingActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

                calendar.set(Calendar.HOUR_OF_DAY, wakeUpTimePicker.getHour());
                calendar.set(Calendar.MINUTE, wakeUpTimePicker.getMinute());

                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }
        });
    }
}
