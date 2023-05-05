package com.example.uts_no3_pendataan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    TextView tvTanggal, tvNama, tvUsia, tvAlamat, tvKota, tvPekerjaan, tvGaji, tvStatus, tvUkuranBaju;
    Button btDaftarLagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Bundle extras = getIntent().getExtras();
        String nama = extras.getString("eNama");
        String alamat = extras.getString("eAlamat");
        String kota = extras.getString("eKota");
        String usia = extras.getString("eUsia");
        String pekerjaan = extras.getString("ePekerjaan");
        String gaji = extras.getString("eGaji");
        String statusPernikahan = extras.getString("eStatusPernikahan");
        String ukuranBaju = extras.getString("eUkuranBaju");
        String tanggalDaftar = extras.getString("eTanggalDaftar");

        String[] keys = {
                "Tanggal Daftar", "Nama", "Usia", "Alamat", "Kota", "Pekerjaan", "Gaji", "Status Pernikahan", "Ukuran Baju"
        };
        String[] values = {
                tanggalDaftar, nama, usia, alamat, kota, pekerjaan, gaji, statusPernikahan, ukuranBaju
        };

        ListView lvDisplayValue, lvDisplayKey;
        lvDisplayValue = findViewById(R.id.lvDisplayValue);
        ArrayAdapter<String> valuesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);
        lvDisplayValue.setAdapter(valuesAdapter);

        lvDisplayKey = findViewById(R.id.lvDisplayKey);
        ArrayAdapter<String> keysAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, keys);
        lvDisplayKey.setAdapter(keysAdapter);

        btDaftarLagi = findViewById(R.id.btDaftarLagi);
        btDaftarLagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FormActivity.class);
                startActivity(intent);
            }
        });
    }
}