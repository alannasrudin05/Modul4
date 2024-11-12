package com.praktikum.modul4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    Button btnVolume;
    MaterialButton btnKelulusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        btnVolume = findViewById(R.id.btn_volume);
        btnKelulusan = findViewById(R.id.btn_kelulusan);

        btnVolume.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, VolumeActivity.class);
            startActivity(i);
        });

        btnKelulusan.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, KelulusanActivity.class);
            startActivity(i);
        });

    }
}