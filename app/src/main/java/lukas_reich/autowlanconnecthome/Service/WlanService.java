package lukas_reich.autowlanconnecthome.Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.net.wifi.WifiManager;


public class WlanService extends Service {
    private String wlanName;
    private WifiManager wifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);


    //Constuctor
    public WlanService(Context appliationContext) {
        super();
        Log.i("HERE", "here i am!");
    }

    public WlanService(){
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent,flags,startId);
        startWlanService(); //Start Service here
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("EXIT", "onDestroy!");
        Intent broadcastIntent = new Intent("lukas_reich.autowlanconnecthome.ActivityRecognition.RestartSensor");
        sendBroadcast(broadcastIntent);
//        stopTask()
    }

    public void startWlanService() {
//        while (1<2) {
//            Log.i("HERE", "Lüppt");
//        }
    if(!wifi.isWifiEnabled()){ // 1. Check if Wlan is enabled
//        if(wlanName)  // 2. Check if nearby Wlan is known
    }

    }

    public void stoptask() {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }
}
