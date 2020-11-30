package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.helloworld;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.helloworld.R;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.helloworld.receiver.WifiReceiver;

public class MainActivity extends AppCompatActivity {
    private ListView wifiList;
    private WifiManager wifiManager;
    private final int MY_PERMISSIONS_ACCESS_COARSE_LOCATION = 1;
    private final int MY_PERMISSIONS_ACCESS_FINE_LOCATION = 2;
    FirebaseDatabase database;
    WifiReceiver receiverWifi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance();

        wifiList = findViewById(R.id.wifiList);
        Button buttonScan = findViewById(R.id.scanBtn);
        Button buttonSend = findViewById(R.id.sendButton);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (!wifiManager.isWifiEnabled()){
            Toast.makeText(getApplicationContext(), "Turning WIFI ON...", Toast.LENGTH_LONG).show();
            wifiManager.setWifiEnabled(true);
        }

        buttonScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWifi();
            }
        });

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(receiverWifi == null){
                    Toast.makeText(MainActivity.this, "Please scan the wifi first",
                            Toast.LENGTH_SHORT).show();
                }
                else if (receiverWifi.deviceList.size() == 0){
                    Toast.makeText(MainActivity.this, "We can't send nothingness to the server",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    for (String namaWifi : receiverWifi.deviceList){
                        String id = database.getReference().child("wifilist").push().getKey();
                        database.getReference().child("wifilist").child(id).setValue(namaWifi);
                    }
                    Toast.makeText(MainActivity.this, "Your wifi list has been sent!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        receiverWifi = new WifiReceiver(wifiManager, wifiList);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        registerReceiver(receiverWifi, intentFilter);
        getWifi();
    }

    private void getWifi(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            Toast.makeText(MainActivity.this, "version >- marshmallow",
                    Toast.LENGTH_SHORT).show();
            if(ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)!=
            PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_ACCESS_FINE_LOCATION);
            }
            if(ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)!=
                    PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                        Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_ACCESS_COARSE_LOCATION);
            }
            else {
                wifiManager.startScan();
            }
        }
        else {
            wifiManager.startScan();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiverWifi);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_PERMISSIONS_ACCESS_COARSE_LOCATION || requestCode == MY_PERMISSIONS_ACCESS_FINE_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                wifiManager.startScan();
            } else {
                Toast.makeText(MainActivity.this, "permission not granted", Toast.LENGTH_SHORT).show();
            }
        }
    }
}