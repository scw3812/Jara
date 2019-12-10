package com.nugu.jara;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

public class SleepSettingActivity extends AppCompatActivity {

    private Spinner hourSpinner;
    private Spinner minuteSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        hourSpinner = (Spinner)findViewById(R.id.hour_setting_spinner);
        minuteSpinner = (Spinner)findViewById(R.id.minute_setting_spinner);
    }
}
