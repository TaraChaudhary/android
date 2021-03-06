package com.example.traffic_rule_and_sign_quiz_app.Services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class CreateChannel {
    Context context;
    public static final String CHANNEL_1="Channel1";
    public static final String CHANNEL_2="Channel2";

    public CreateChannel(Context context) {
        this.context = context;
    }
    public void CreateChannel()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel channel1=new NotificationChannel(CHANNEL_1,"Channel1",
                    NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("This is Channel 1");

            NotificationChannel channel2=new NotificationChannel(CHANNEL_2,"Channel2",
                    NotificationManager.IMPORTANCE_LOW);
            channel2.setDescription("This is Channel 2");

            NotificationManager manager=context.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);

        }
    }
}
