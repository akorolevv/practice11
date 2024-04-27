package com.example.practice11;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class StandartNot extends AppCompatActivity {

    private static final String CHANNEL_ID = "example_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stannot);
        createNotificationChannel();

        final Button notifyButton = findViewById(R.id.notifyButton);
        notifyButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(StandartNot.this, CHANNEL_ID) // Создание объекта NotificationCompat.Builder для построения уведомления
                        .setSmallIcon(R.drawable.ic_notification) // Установка маленькой иконки уведомления
                        .setContentTitle("Example Notification") // Установка заголовка уведомления
                        .setContentText("This is a test notification") // Установка текста уведомления
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT); // Установка приоритета уведомления

                NotificationManager notificationManager = getSystemService(NotificationManager.class); // Получение объекта NotificationManager
                notificationManager.notify(1, builder.build()); // Отправка уведомления с помощью NotificationManager
            }
        });
    }

    private void createNotificationChannel()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        { // Проверка версии SDK
            CharSequence name = "Example Channel"; // Название канала уведомлений
            String description = "Channel for example notifications"; // Описание канала уведомлений
            int importance = NotificationManager.IMPORTANCE_DEFAULT; // Важность канала уведомлений
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance); // Создание канала уведомлений
            channel.setDescription(description); // Установка описания канала уведомлений
            NotificationManager notificationManager = getSystemService(NotificationManager.class); // Получение объекта NotificationManager
            notificationManager.createNotificationChannel(channel); // Создание канала уведомлений
        }
    }
}
