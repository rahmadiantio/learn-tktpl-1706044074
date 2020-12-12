package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.helloworld.R;

public class MainActivity extends AppCompatActivity {
    int hitung = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = findViewById(R.id.counter);
        FloatingActionButton btnTambah = findViewById(R.id.btnTambah);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(Integer.toString(hitung++));
            }
        });
    }
}