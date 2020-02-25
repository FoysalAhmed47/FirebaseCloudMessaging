package com.example.firebasecloudmessaging;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerTopics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChannel();
        spinnerTopics = findViewById(R.id.spinnerTopics);

        //MyNotificationManager.getInstance(this).displayNotification("Greetings", "Hello how are you?");
        findViewById(R.id.buttonSuscribe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String topic = spinnerTopics.getSelectedItem().toString();
                FirebaseMessaging.getInstance().subscribeToTopic(topic);
                Toast.makeText(getApplicationContext(), "Subscribed", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void createNotificationChannel() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(Constants.CHANNEL_ID, Constants.CHANNEL_NAME, importance);
            mChannel.setDescription(Constants.CHANNEL_DESCRIPTION);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            mNotificationManager.createNotificationChannel(mChannel);
        }
    }
}

//flIEBpvg8vE:APA91bF-kwgV79R4GQHblPdehgfg6-Y01VaESxYDOc_Q9IXJqnrHS4RvSO-2n6ZmcELn54UDo-LTQ5oYHcEuUaO_YMjeVThzsZ4CXwX5p
//        7qJXh711o3MGz9c6BUOXDAW1AJQ04k_fnpx
