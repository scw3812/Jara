package com.nugu.jara;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String getYoutString = intent.getExtras().getString("state");

        // RingtonePlayingService 서비스 intent 생성
        Intent serviceIntent = new Intent(context, RingtonePlayingService.class);

        // RingtonePlayinService로 extra string값 보내기
        serviceIntent.putExtra("state", getYoutString);
        // start the ringtone service

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
            context.startForegroundService(serviceIntent);
        }else {
            context.startService(serviceIntent);
        }
    }
}
