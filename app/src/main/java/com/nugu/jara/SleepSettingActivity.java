package com.nugu.jara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SleepSettingActivity extends AppCompatActivity {

    private Spinner meridiemSpinner, hourSpinner, minuteSpinner;
    private ArrayAdapter meridiemArrayAdapter, hourArrayAdapter, minuteArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        meridiemSpinner = (Spinner)findViewById(R.id.meridiem_setting_spinner);
        hourSpinner = (Spinner)findViewById(R.id.hour_setting_spinner);
        minuteSpinner = (Spinner)findViewById(R.id.minute_setting_spinner);

        String[] meridiemArray = getResources().getStringArray(R.array.meridiem_array);
        String[] hourArray = getResources().getStringArray(R.array.hour_array);
        List<String> minuteArray = new ArrayList<>();
        for(int i = 0; i< 60; i++){
            minuteArray.add(Integer.toString(i));
        }

        meridiemArrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, meridiemArray);
        hourArrayAdapter =  new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, hourArray);
        minuteArrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, minuteArray);

        meridiemSpinner.setAdapter(meridiemArrayAdapter);
        hourSpinner.setAdapter(hourArrayAdapter);
        minuteSpinner.setAdapter(minuteArrayAdapter);
    }
}
