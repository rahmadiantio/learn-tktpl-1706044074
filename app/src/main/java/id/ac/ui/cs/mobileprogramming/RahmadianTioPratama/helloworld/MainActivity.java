package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.helloworld.R;

public class MainActivity extends AppCompatActivity {
    public boolean selesai = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startIntent(View v){
        Intent intent = new Intent(this, StopwatchActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if(selesai){
            finish();
        }
        else {
            Toast.makeText(this, "Tekan tombol kembali sekali lagi",
            Toast.LENGTH_SHORT).show();
            selesai = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    selesai = false;
                }
            }, 3 * 1000);
        }
    }
}