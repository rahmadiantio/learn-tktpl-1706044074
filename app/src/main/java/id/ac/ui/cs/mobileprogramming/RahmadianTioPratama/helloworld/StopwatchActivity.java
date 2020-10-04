package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class StopwatchActivity extends AppCompatActivity {
    public int waktu = 0;
    public boolean jalan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        if(savedInstanceState != null){
            waktu = savedInstanceState.getInt("waktu");
            jalan = savedInstanceState.getBoolean("jalan");
        }
        stopwatch();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public void onClickStart(View v){
        jalan = true;
    }

    public void onClickStop(View v){
        jalan = false;
    }

    public void onClickReset(View v){
        jalan = false;
        waktu = 0;
    }

    public void stopwatch(){
        final TextView waktuStopwatch = (TextView) findViewById(R.id.waktu);
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int detik = waktu % 60;
                int menit = (waktu % 3600) / 60;
                int jam = (waktu / 3600);
                String tulisanWaktu = String.format(Locale.getDefault(), "%d:%02d:%02d", jam, menit, detik);
                waktuStopwatch.setText(tulisanWaktu);
                if(jalan){
                    waktu++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}