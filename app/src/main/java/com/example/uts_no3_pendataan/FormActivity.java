package com.example.uts_no3_pendataan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FormActivity extends AppCompatActivity {
    private EditText etNama, etAlamat, etKota, etUsia, etPekerjaan, etGaji;
    private RadioGroup rgStatusPernikahan, rgUkuranBaju;
    private Button btClear, btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        etNama = findViewById(R.id.etNama);
        etAlamat = findViewById(R.id.etAlamat);
        etKota = findViewById(R.id.etKota);
        etUsia = findViewById(R.id.etUsia);
        etPekerjaan = findViewById(R.id.etPekerjaan);
        etGaji = findViewById(R.id.etGaji);
        rgStatusPernikahan = findViewById(R.id.rgStatusPernikahan);
        rgUkuranBaju = findViewById(R.id.rgUkuranBaju);
        btClear = findViewById(R.id.btClear);
        btSubmit = findViewById(R.id.btSubmit);
        resetForm();
        
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNama.getText().toString();
                String alamat = etAlamat.getText().toString();
                String kota = etKota.getText().toString();
                String usia = etUsia.getText().toString();
                String pekerjaan = etPekerjaan.getText().toString();
                String gaji = etGaji.getText().toString();
                int selectedStatusPernikahanId = rgStatusPernikahan.getCheckedRadioButtonId();
                int selectedUkuranBajuId = rgUkuranBaju.getCheckedRadioButtonId();
                if (selectedUkuranBajuId == -1 || selectedStatusPernikahanId == -1
                        || isStringEmpty(nama) || isStringEmpty(alamat)
                        || isStringEmpty(kota) || isStringEmpty(usia)
                        || isStringEmpty(gaji) || isStringEmpty(pekerjaan)
                ) {
                    Toast.makeText(FormActivity.this, "Please fill all forms", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton rbStatusPernikahan = findViewById(selectedStatusPernikahanId);
                RadioButton rbUkuranBaju = findViewById(selectedUkuranBajuId);
                String statusPernikahan = rbStatusPernikahan.getText().toString();
                String ukuranBaju = rbUkuranBaju.getText().toString();
                String tanggalDaftar = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy", Locale.getDefault()).format(new Date());
                Intent intent = new Intent(v.getContext(), DisplayActivity.class);
                intent.putExtra("eNama", nama);
                intent.putExtra("eAlamat", alamat);
                intent.putExtra("eKota", kota);
                intent.putExtra("eUsia", usia);
                intent.putExtra("ePekerjaan", pekerjaan);
                intent.putExtra("eGaji", gaji);
                intent.putExtra("eStatusPernikahan", statusPernikahan);
                intent.putExtra("eUkuranBaju", ukuranBaju);
                intent.putExtra("eTanggalDaftar", tanggalDaftar);
                startActivity(intent);
            }
        });
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetForm();
            }
        });
    }

    private void resetForm() {
        etNama.setText(null);
        etAlamat.setText(null);
        etKota.setText(null);
        etUsia.setText(null);
        etPekerjaan.setText(null);
        etGaji.setText(null);
        rgStatusPernikahan.clearCheck();
        rgUkuranBaju.clearCheck();
    }

    private boolean isStringEmpty(String string) {
        return string == null || string.isEmpty() || string.trim().isEmpty();
    }
}