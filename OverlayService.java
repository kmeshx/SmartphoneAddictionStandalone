package com.example.notiftest;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.util.Log;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * Service to overlay a translucent red View
 * @author Hathibelagal
 */
public class OverlayService extends Service {

    LinearLayout oView;

    @Override
    public IBinder onBind(Intent i) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        /*oView = new LinearLayout(OverlayService.this);
        oView.setBackgroundColor(0x88ff0000); // The translucent red color

        /*RelativeLayout oView = new RelativeLayout(this);

        // Defining the RelativeLayout layout parameters.
        // In this case I want to fill its parent
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        // Creating a new TextView
        TextView tv = new TextView(this);
        tv.setText("Test");

        // Defining the layout parameters of the TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.CENTER_IN_PARENT);

        // Setting the parameters on the TextView
        tv.setLayoutParams(lp);

        // Adding the TextView to the RelativeLayout as a child
        //relativeLayout.addView(tv);

        // Setting the RelativeLayout as our content view
        //setContentView(relativeLayout, rlp);

*/

        /*WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                //WindowManager.LayoutParams.TYPE_APPLICATION_PANEL,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        wm.addView(oView, params);*/
    }
    @Override
    public int onStartCommand (Intent intent, int flags, int startId) {
        String timeAndCurrentApp = intent.getStringExtra("timeAndCurrentApp");
        //Intent intent4mTO = getIntent();
        //String timeAndCurrentApp = getStringExtra("timeAndCurrentApp");
        Log.d("int mess", timeAndCurrentApp);
        List<String> timeAppLst = Arrays.asList(timeAndCurrentApp.split(","));
        String time_spent = timeAppLst.get(0);
        String app_used = timeAppLst.get(1);

        oView = new LinearLayout(OverlayService.this);
        oView.setBackgroundColor(0x88ff0000); // The translucent red color

        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        llp.setLayoutDirection(1);
        TextView tv = new TextView(this);
        tv.setText("Time Spent: "+time_spent);

        TextView tv2 = new TextView(this);
        tv2.setText("App Used: "+app_used);

        tv.setLayoutParams(llp);
        tv2.setLayoutParams(llp);

        oView.addView(tv);
        oView.addView(tv2);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                //WindowManager.LayoutParams.TYPE_APPLICATION_PANEL,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        wm.addView(oView, params);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(oView!=null){
            WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
            wm.removeView(oView);
        }
    }

}
