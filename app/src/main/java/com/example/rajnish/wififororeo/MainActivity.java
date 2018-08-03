package com.example.rajnish.wififororeo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    TextView WifiState;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WifiState = (TextView)findViewById(R.id.wifi_connection);

        this.registerReceiver(this.WifiStateChangedReceiver, new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION));
    }

    private BroadcastReceiver WifiStateChangedReceiver = new BroadcastReceiver()
    {

        @Override
        public void onReceive(Context context, Intent intent)
        {
            // TODO Auto-generated method stub

            int extraWifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE , WifiManager.WIFI_STATE_UNKNOWN);

            switch(extraWifiState){
                case WifiManager.WIFI_STATE_DISABLED:
                    WifiState.setText("WIFI STATE DISABLED");
                    Toast.makeText(context, "Not connected", Toast.LENGTH_SHORT).show();
                    break;

                case WifiManager.WIFI_STATE_ENABLING:
                    WifiState.setText("WIFI STATE ENABLED");
                    Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
                    break;

                case WifiManager.WIFI_STATE_UNKNOWN:
                    WifiState.setText("WIFI STATE UNKNOWN");
                    Toast.makeText(context, "Known Wifi", Toast.LENGTH_SHORT).show();
                    break;
            }

        }};
}

