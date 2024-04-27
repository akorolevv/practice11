package com.example.practice11;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.app.NotificationManager;
import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent)
    {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, TimeNot.CHANNEL_ID) // Создание объекта NotificationCompat.Builder для построения уведомления
                .setSmallIcon(R.drawable.ic_notification) // Установка маленькой иконки уведомления
                .setContentTitle("Delayed Notification") // Установка заголовка уведомления
                .setContentText("This is your scheduled notification.") // Установка текста уведомления
                .setPriority(NotificationCompat.PRIORITY_DEFAULT); // Установка приоритета уведомления

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE); // Получение объекта NotificationManager
        notificationManager.notify(1, builder.build()); // Отправка уведомления с помощью NotificationManager
    }
}
