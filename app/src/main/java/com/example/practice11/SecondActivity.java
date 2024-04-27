package com.example.practice11;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class SecondActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private EditText urlEditText;
    private Button playButton, stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        urlEditText = findViewById(R.id.urlEditText);
        playButton = findViewById(R.id.playButton);
        stopButton = findViewById(R.id.stopButton);

        mediaPlayer = new MediaPlayer();

        playButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String audioUrl = urlEditText.getText().toString().trim(); // Получение текста из urlEditText и удаление лишних пробелов
                if (!audioUrl.isEmpty()) {
                    try
                    {
                        mediaPlayer.reset(); // Сброс mediaPlayer
                        mediaPlayer.setDataSource(audioUrl); // Установка источника данных для mediaPlayer
                        mediaPlayer.prepare(); // Подготовка mediaPlayer
                        mediaPlayer.start(); // Начало воспроизведения аудио
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(SecondActivity.this, "Ошибка при воспроизведении аудио", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SecondActivity.this, "Введите URL аудиофайла", Toast.LENGTH_SHORT).show();
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release(); // Освобождение ресурсов mediaPlayer
            mediaPlayer = null; // Уничтожение
        }
    }
}
