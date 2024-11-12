package com.praktikum.modul4;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VolumeActivity extends AppCompatActivity {

    Button btnHitung;
    EditText nilaiPanjang, nilaiLebar, nilaiTinggi;
    TextView hasilVolume, panjangError, lebarError, tinggiError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_volume);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nilaiPanjang = findViewById(R.id.nilai_panjang);
        nilaiLebar = findViewById(R.id.nilai_lebar);
        nilaiTinggi = findViewById(R.id.nilai_tinggi);
        hasilVolume = findViewById(R.id.tv_hasil);

        btnHitung = findViewById(R.id.btn_hitung);

        panjangError = findViewById(R.id.panjang_error);
        lebarError = findViewById(R.id.lebar_error);
        tinggiError = findViewById(R.id.tinggi_error);

        btnHitung.setOnClickListener(v -> {

            String panjangStr = nilaiPanjang.getText().toString();
            String lebarStr = nilaiLebar.getText().toString();
            String tinggiStr = nilaiTinggi.getText().toString();

            boolean isEmptyField = false;
            if(TextUtils.isEmpty(panjangStr)){
                isEmptyField = true;
                panjangError.setText("nilai Panjang tidak boleh Kosong!");
                panjangError.setVisibility(v.VISIBLE);

            }

            if(TextUtils.isEmpty(lebarStr)){
                isEmptyField = true;
                lebarError.setText("nilai Lebar tidak boleh Kosong!");
                lebarError.setVisibility(v.VISIBLE);

            }

            if(TextUtils.isEmpty(tinggiStr)){
                isEmptyField = true;
                tinggiError.setText("nilai Tinggi tidak boleh Kosong!");
                tinggiError.setVisibility(v.VISIBLE);

            }

            if(!isEmptyField){
                Double panjang = Double.parseDouble(nilaiPanjang.getText().toString());
                Double lebar = Double.parseDouble(nilaiLebar.getText().toString());
                Double tinggi = Double.parseDouble(nilaiTinggi.getText().toString());

                Double hasil = panjang * lebar * tinggi;

                hasilVolume.setText("Volume : " + ((hasil % 1 == 0) ? String.format("%.0f", hasil) : String.valueOf(hasil)));
                hasilVolume.setVisibility(v.VISIBLE);
            }

        });

    }
}