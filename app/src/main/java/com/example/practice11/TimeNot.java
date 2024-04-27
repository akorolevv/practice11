package com.example.practice11;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class TimeNot extends AppCompatActivity
{
    public static final String CHANNEL_ID = "delayed_channel";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timenot);
        createNotificationChannel();
        final Button delayedNotifyButton = findViewById(R.id.notifyButton);
        delayedNotifyButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                scheduleNotification(10000); // 10 секунд
            }
        });
    }
    private void createNotificationChannel()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            CharSequence name = "Delayed Notifications";
            String description = "Channel for delayed example notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    @SuppressLint("ScheduleExactAlarm")
    private void scheduleNotification(long delay)
    {
        Intent notificationIntent = new Intent(this, AlarmReceiver.class);
        // Создание интента для передачи уведомления

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        // Получение объекта AlarmManager
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        // Рассчет времени срабатывания уведомления
        long futureInMillis = System.currentTimeMillis() + delay;
        // Установка точного времени срабатывания уведомления
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, futureInMillis, pendingIntent);
    }
}
