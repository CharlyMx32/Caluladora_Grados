package com.example.caluladoragrados;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private long timeLeftInMillis = 5000; // 5 segundos (5000 ms)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        // Iniciar el temporizador automáticamente cuando se cree la actividad
        startCountDown();
    }

    // Iniciar el contador
    private void startCountDown() {
        // Cambiar a MainActivity cuando el tiempo llegue a 0
        CountDownTimer countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                // Cambiar a MainActivity cuando el tiempo llegue a 0
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Cierra la SplashActivity para que no vuelva al presionar el botón de atrás
            }
        }.start();
    }

}
