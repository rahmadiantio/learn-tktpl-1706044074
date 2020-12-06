package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.helloworld.R;

public class MainActivity extends AppCompatActivity {
    int angka1;
    int angka2;
    EditText inpAngka1;
    EditText inpAngka2;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = findViewById(R.id.hasil);
        Button tombolJumlah = findViewById(R.id.btnJumlah);
        tombolJumlah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inpAngka1 = findViewById(R.id.angka1);
                inpAngka2 = findViewById(R.id.angka2);
                angka1 = Integer.parseInt(inpAngka1.getText().toString());
                angka2 = Integer.parseInt(inpAngka2.getText().toString());
                tv.setText(Integer.toString(penjumlahanFromJNI(angka1, angka2)));
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native int penjumlahanFromJNI(int x, int y);
}