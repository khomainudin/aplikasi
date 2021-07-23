package com.example.aplikasipenjualan;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private EditText editnampel
        ,editnambar,editjmlbar, editHarga,edituangbay;
    private Button btnProses;
    private Button btnHapus;
    private Button btnKeluar;
    private TextView tvNamaPembeli;
    private TextView tvNamaBarang;
    private TextView tvJmlBarang;
    private TextView tvHarga;
    private TextView tvUangBayar;
    private TextView tvTotal;
    private TextView tvKembalian;
    private TextView tvBonus;
    private TextView tvKeterangan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        getSupportActionBar().setTitle("Aplikasi Penjualan");
        editnampel = (EditText) findViewById(R.id.etNamaPelanggan);
        editnambar = (EditText) findViewById(R.id.etNamaBarang);
        editjmlbar = (EditText) findViewById(R.id.etJmlBarang);
        editHarga = (EditText) findViewById(R.id.etHarga);
        edituangbay = (EditText) findViewById(R.id.etJmlUang);

        tvNamaPembeli =(TextView) findViewById(R.id.etNamaPelanggan);
        tvNamaBarang = (TextView)findViewById(R.id.etNamaBarang);
        tvJmlBarang = (TextView)findViewById(R.id.etJmlBarang);
        tvHarga = (TextView)findViewById(R.id.etHarga);
        tvUangBayar =(TextView) findViewById(R.id.etJmlUang);
        tvTotal = (TextView)findViewById(R.id.tvTotal);
        tvKembalian =(TextView) findViewById(R.id.tvKembalian);
        tvBonus = (TextView)findViewById(R.id.tvBonus);
        tvKeterangan =(TextView) findViewById(R.id.tvKeterangan);

        btnProses = (Button)findViewById(R.id.btnProses);
        btnHapus = (Button)findViewById(R.id.btnHapus);
        btnKeluar =(Button) findViewById(R.id.btnKeluar);

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String etNamaPelanggan = editnampel.getText().toString().trim();
                String etNamaBarang= editnambar.getText().toString().trim();
                String etJmlBarang=editjmlbar.getText().toString().trim();
                String etHarga= editHarga.getText().toString().trim();
                String etJmlUang = edituangbay.getText().toString().trim();

                double jb = Double.parseDouble(etJmlBarang);
                double h = Double.parseDouble(etHarga);
                double ub = Double.parseDouble(etJmlUang);
                double total = (jb * h);


                tvTotal.setText("Total Belanja " + total);
                if (total >= 200000) {
                    tvBonus.setText("Bonus : HardDisk 1TB");
                } else if (total >= 50000) {
                    tvBonus.setText("Bonus : Keyboard Gaming");
                } else if (total >= 40000) {
                    tvBonus.setText("Bonus : Mouse Gaming");
                } else {
                    tvBonus.setText("Bonus : Tidak ada bonus!");
                }

                double kembalian = (ub - total);
                if (ub < total) {
                    tvKeterangan.setText("Keterangan : Uang bayar kurang Rp. " + (-kembalian));
                    tvKembalian.setText("Uang Kembalian : Rp. 0");
                } else {
                    tvKeterangan.setText("Keterangan : Tunggu kembalian");
                    tvKembalian.setText("Uang Kembalian : Rp. " + kembalian);
                }

            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                tvNamaPembeli.setText("");
                tvNamaBarang.setText("");
                tvJmlBarang.setText("");
                tvHarga.setText("");
                tvUangBayar.setText("");
                tvKembalian.setText("Uang kembali : Rp. 0");
                tvKeterangan.setText("");
                tvBonus.setText("");
                tvTotal.setText("Total Belanja : Rp 0*");

                Toast.makeText(getApplicationContext(), "Data sudah dihapus", Toast.LENGTH_SHORT).show();
            }
        });

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);

            }
        });

    }
}