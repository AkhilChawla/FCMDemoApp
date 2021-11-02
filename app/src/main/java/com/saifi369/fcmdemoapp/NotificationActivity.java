package com.saifi369.fcmdemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setContentView(R.layout.activity_notification);
        TextView textView=(TextView)findViewById(R.id.textView);
        if (intent.hasExtra("notification_id")){
            StringBuilder builder=new StringBuilder();
            String body=getIntent().getStringExtra("body");
            String notification_id="Akhil";//getIntent().getStringExtra("notification_id");
            String title=getIntent().getStringExtra("title");
            String description=getIntent().getStringExtra("description");

            //append the data in to builder
            builder.append("Title: "+title+"\n\n");
            builder.append("Body: "+body+"\n\n");
            builder.append("Description: "+description+"\n\n");
            builder.append("Notification Id: "+notification_id+"\n\n");


            //set into textView
            textView.setText(builder.toString());

//            run the app
        }
        else {
            textView.setText("no id");
        }
    }
}
//
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_notification);
//
//        TextView textView=(TextView)findViewById(R.id.textView);
//        if (getIntent().hasExtra("notification_id")){
//            StringBuilder builder=new StringBuilder();
//            String body=getIntent().getStringExtra("body");
//            String notification_id="Akhil";//getIntent().getStringExtra("notification_id");
//            String title=getIntent().getStringExtra("title");
//            String description=getIntent().getStringExtra("description");
//
//            //append the data in to builder
//            builder.append("Title: "+title+"\n\n");
//            builder.append("Body: "+body+"\n\n");
//            builder.append("Description: "+description+"\n\n");
//            builder.append("Notification Id: "+notification_id+"\n\n");
//
//
//            //set into textView
//            textView.setText(builder.toString());
//
////            run the app
//        }
//        else {
//            textView.setText("no id");
//        }
//    }
//}