package com.example.practice11;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        // Анимация вращения элемента
        ImageView rotateImageView = findViewById(R.id.rotateImageView);
        ObjectAnimator rotateAnim = ObjectAnimator.ofFloat(rotateImageView, "rotation", 0f, 360f); // Создание анимации вращения для rotateImageView
        rotateAnim.setDuration(3000);
        rotateAnim.setRepeatCount(ObjectAnimator.INFINITE); // Установка бесконечного повторения анимации
        rotateAnim.setRepeatMode(ObjectAnimator.RESTART); // Установка режима повторения анимации
        rotateAnim.start();

        // Анимация перемещения элемента по экрану
        final Button moveButton = findViewById(R.id.moveButton);
        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Переопределение метода onClick
                ObjectAnimator moveAnim = ObjectAnimator.ofFloat(moveButton, "translationX", 0f, 300f); // Создание анимации перемещения для moveButton
                moveAnim.setDuration(1000);
                moveAnim.start();
            }
        });

        // Анимация изменения размера элемента
        TextView scaleTextView = findViewById(R.id.scaleTextView);
        scaleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Переопределение метода onClick
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(scaleTextView, "scaleX", 1f, 2f); // Создание анимации изменения размера по оси X для scaleTextView
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(scaleTextView, "scaleY", 1f, 2f); // Создание анимации изменения размера по оси Y для scaleTextView
                scaleX.setDuration(1000);
                scaleY.setDuration(1000);
                scaleX.start();
                scaleY.start();
            }
        });
    }
}
