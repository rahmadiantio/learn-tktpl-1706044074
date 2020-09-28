package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.helloworld.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("SetTextI18n")
    public void ganjilCheck(View v){
        EditText text = (EditText) findViewById(R.id.input);
        String input = text.getText().toString();
        int angka = Integer.parseInt(input.toString());
        TextView pesan = (TextView)findViewById(R.id.hasil);
        if (cekGanjil(angka)){
            pesan.setText("Ganjil");

        }
        else {
            pesan.setText("Bukan Ganjil");
        }
    }

    public boolean cekGanjil(int angka){
        return angka % 2 != 0;
    }
}