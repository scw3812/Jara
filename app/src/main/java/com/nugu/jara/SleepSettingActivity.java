package com.nugu.jara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SleepSettingActivity extends AppCompatActivity {

    private Spinner meridiemSleepSpinner, hourSleepSpinner, minuteSleepSpinner, meridiemWakeUpSpinner, hourWakeUpSpinner, minuteWakeUpSpinner;
    private ArrayAdapter meridiemArrayAdapter, hourArrayAdapter, minuteArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        meridiemSleepSpinner = (Spinner)findViewById(R.id.meridiem_setting_sleep_spinner);
        hourSleepSpinner = (Spinner)findViewById(R.id.hour_setting_sleep_spinner);
        minuteSleepSpinner = (Spinner)findViewById(R.id.minute_setting_sleep_spinner);
        meridiemWakeUpSpinner = (Spinner)findViewById(R.id.meridiem_setting_wakeup_spinner);
        hourWakeUpSpinner = (Spinner)findViewById(R.id.hour_setting_wakeup_spinner);
        minuteWakeUpSpinner = (Spinner)findViewById(R.id.minute_setting_wakeup_spinner);

        String[] meridiemArray = getResources().getStringArray(R.array.meridiem_array);
        String[] hourArray = getResources().getStringArray(R.array.hour_array);
        List<String> minuteArray = new ArrayList<>();
        for(int i = 0; i< 60; i++){
            minuteArray.add(Integer.toString(i));
        }

        meridiemArrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, meridiemArray);
        hourArrayAdapter =  new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, hourArray);
        minuteArrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, minuteArray);

        meridiemSleepSpinner.setAdapter(meridiemArrayAdapter);
        hourSleepSpinner.setAdapter(hourArrayAdapter);
        minuteSleepSpinner.setAdapter(minuteArrayAdapter);
        meridiemWakeUpSpinner.setAdapter(meridiemArrayAdapter);
        hourWakeUpSpinner.setAdapter(hourArrayAdapter);
        minuteWakeUpSpinner.setAdapter(minuteArrayAdapter);
    }
}
