package lukas_reich.autowlanconnecthome.Main;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import lukas_reich.autowlanconnecthome.R;
import lukas_reich.autowlanconnecthome.Service.WlanService;

public class MainActivity extends AppCompatActivity {

    private List<String> wlanNames; // contains all known WlanNames
    Intent mServiceIntent;
    private lukas_reich.autowlanconnecthome.Service.WlanService WlanService;
    Context ctx;
    public Context getCtx() {
        return ctx;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        setContentView(R.layout.activity_main);
        WlanService = new WlanService(getCtx());
        mServiceIntent = new Intent(getCtx(), WlanService.getClass());
        if (!isMyServiceRunning(WlanService.getClass())) {
            startService(mServiceIntent);
        }
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i ("isMyServiceRunning?", true+"");
                return true;
            }
        }
        Log.i ("isMyServiceRunning?", false+"");
        return false;
    }

    @Override
    protected void onDestroy() {
        stopService(mServiceIntent);
        Log.i("MAINACT", "onDestroy!");
        super.onDestroy();

    }

    public List<String> getWlanNames() {
        return this.wlanNames;
    }

    public List<String> addWlanName(String wlanName){ // Adds Wlan to known List
        wlanNames.add(wlanName);
        return this.wlanNames;
    }

    public List<String> deleteWlanName(String wlanName) { // Deletes Wlan from known List
        wlanNames.remove(wlanName);
        return this.wlanNames;
    }
}
