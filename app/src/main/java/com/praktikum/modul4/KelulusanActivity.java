package com.praktikum.modul4;

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

public class KelulusanActivity extends AppCompatActivity {

    Button btnCek;
    EditText inputNama, inputNim, inputNilai;
    TextView hasilKelulusan, namaError, nimError, nilaiError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kelulusan);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        inputNama = findViewById(R.id.input_nama);
        inputNim = findViewById(R.id.input_nim);
        inputNilai = findViewById(R.id.input_nilai);
        hasilKelulusan = findViewById(R.id.tv_hasil);

        btnCek = findViewById(R.id.btn_cek);

        namaError = findViewById(R.id.nama_error);
        nimError = findViewById(R.id.nim_error);
        nilaiError = findViewById(R.id.nilai_error);

        btnCek.setOnClickListener(v -> {

            String namaStr = inputNama.getText().toString();
            String nimStr = inputNim.getText().toString();
            String nilaiStr = inputNilai.getText().toString();

            boolean isEmptyField = false;
            if(TextUtils.isEmpty(namaStr)){
                isEmptyField = true;
                namaError.setText("Nama tidak boleh Kosong!");
                namaError.setVisibility(v.VISIBLE);

            }

            if(TextUtils.isEmpty(nimStr)){
                isEmptyField = true;
                nimError.setText("Nim tidak boleh Kosong!");
                nimError.setVisibility(v.VISIBLE);

            }

            if(TextUtils.isEmpty(nilaiStr)){
                isEmptyField = true;
                nilaiError.setText("Nilai tidak boleh Kosong!");
                nilaiError.setVisibility(v.VISIBLE);

            }

            if(!isEmptyField){
                Double nilai = Double.parseDouble(inputNilai.getText().toString());
                String hasil;

                if (nilai > 100){
                    hasil = "Nilai harus diantara 1-100";
                }else if(nilai >= 90){
                    hasil = "A";
                }else if(nilai >= 80){
                    hasil = "B";
                }else if(nilai >= 70){
                    hasil = "C";
                }else if(nilai >= 60){
                    hasil = "D";
                }else {
                    hasil = "E";
                }

                hasilKelulusan.setText("Nama : " + namaStr  + "\nNIM : " + nimStr + "\nGrade : " + hasil);
                hasilKelulusan.setVisibility(v.VISIBLE); // Menampilkan TextView
            }

        });



    }
}