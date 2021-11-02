package com.saifi369.fcmdemoapp;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
//import android.support.v4.app.NotificationCompat;
//import android.support.v4.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.IOException;
import java.net.URL;

//import static com.areena.wifi.NotificationClass.NOTIFICATION_ID;

public class MyFirebaseMessagingService extends FirebaseMessagingService {


        public static final String TAG ="DATA";
        private static final int PENDING_INTENT_REQ_CODE = 101;//any random number
        private static final CharSequence SUMMERY = "SUMMERY";
        private static final CharSequence BIG_CONTENT_TITLE = "BIG CONTENT TITLE";
        private static final int ACTION_INTENT_CODE = 102;
    //    NotificationManagerCompat managerCompat;

        @Override
        public void onMessageReceived(RemoteMessage remoteMessage) {
            super.onMessageReceived(remoteMessage);
    //        Intent intent = new Intent(this,NotificationActivity.class);
    //        if(remoteMessage.getData().size()>0){
    //            String message = remoteMessage.getData().get("message");
    //            Bundle bundle = new Bundle();
    //            bundle. putString("message",message);
    //            intent.putExtras(bundle);
    //        }
    //        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    //        PendingIntent pendingIntent = PendingIntent.getActivity(this,
    //                PENDING_INTENT_REQ_CODE,
    //                intent, PendingIntent.FLAG_ONE_SHOT);
    //        //check for null

            Log.d(TAG, "Data: " + remoteMessage.getData());
            if (remoteMessage.getNotification() != null) {
                String title = remoteMessage.getNotification().getTitle();
                String body = remoteMessage.getNotification().getBody();
    //            managerCompat = NotificationManagerCompat.from(this);
                String click_action = remoteMessage.getNotification().getClickAction();
                //remoteMessage.getNotification().getBody();//
                String notification_id = "Akhil";//remoteMessage.getData().get("image");
                //get icon and desc here
                String icon = remoteMessage.getNotification().getIcon();
                String description = remoteMessage.getNotification().getTag();
                //pass icon and description to show Notification method
                showNotification(title, body, click_action,notification_id, icon, description);
            }
        }

        private void showNotification(String title, String body, String click_action,String notification_id, String icon, String description) {

            //create intent and pending intent
            Intent intent = new Intent(click_action);
            intent.putExtra("notification_id", notification_id);
            intent.putExtra("body", body);
            intent.putExtra("title", title);
            intent.putExtra("description", description);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
    //        PendingIntent pendingIntent = PendingIntent.getActivity(this,
    //                PENDING_INTENT_REQ_CODE,
    //                intent, PendingIntent.FLAG_UPDATE_CURRENT);
    //
    //        //Action Intent
    //
    //
    //        Intent broadcastIntent = new Intent(this, NotificationActivity.class);
    //        broadcastIntent.putExtra("message", title);
    //
    //        PendingIntent actionIntent = PendingIntent.getBroadcast(this, ACTION_INTENT_CODE, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    //
    //
    //        Bitmap largeImage;
    //        try {
    //            URL url = new URL(icon);//pass image url
    //            largeImage = BitmapFactory.decodeStream(url.openConnection().getInputStream());
    //        } catch (IOException e) {
    //            //if icon url is empty or null
    //            largeImage = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_foreground);
    //        }

            //Create Notification here

            //add large image and big Text to notification
    //        Notification notification = new NotificationCompat.Builder(MyFirebaseMessagingService.this, NOTIFICATION_ID)
    //                .setContentTitle(title)
    //                .setContentText(body)
    //                .setPriority(NotificationCompat.PRIORITY_HIGH)
    //                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
    //                .setSmallIcon(R.drawable.ic_launcher_foreground)
    //                .setContentIntent(pendingIntent)
    //                .setColor(Color.BLUE)
    //                .setStyle(new NotificationCompat.BigTextStyle()
    //                        .setSummaryText(SUMMERY)
    //                        .setBigContentTitle(BIG_CONTENT_TITLE)
    //                        .bigText(description)).setAutoCancel(true)
    //                .setLargeIcon(largeImage)
    //                .addAction(R.drawable.ic_launcher_background, "VIEW", actionIntent)
    //                .addAction(R.drawable.ic_launcher_background, "DELETE", actionIntent)
    //                .build();
    //        managerCompat.notify((int) System.currentTimeMillis(), notification);
        }
}