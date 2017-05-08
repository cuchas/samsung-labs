package com.example.eduardocucharro.a4samsungpedometer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.motion.Smotion;
import com.samsung.android.sdk.motion.SmotionCall;
import com.samsung.android.sdk.motion.SmotionPedometer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.text_distancia);

        Smotion smotion = new Smotion();

        try {
            smotion.initialize(this);

           if(smotion.isFeatureEnabled(Smotion.TYPE_PEDOMETER)) {

               SmotionPedometer pedometer = new SmotionPedometer(getMainLooper(), smotion);
               pedometer.start(new SmotionPedometer.ChangeListener() {
                   @Override
                   public void onChanged(SmotionPedometer.Info info) {
                       double distance = info.getSpeed();
                       textView.setText(String.valueOf(distance));
                   }
               });
           }

           if(smotion.isFeatureEnabled(Smotion.TYPE_CALL)) {

               SmotionCall call = new SmotionCall(getMainLooper(), smotion);
               call.start(new SmotionCall.ChangeListener() {
                   @Override
                   public void onChanged(SmotionCall.Info info) {

                   }
               });
           }

        } catch (SsdkUnsupportedException e) {
            e.printStackTrace();
        }
    }
}
