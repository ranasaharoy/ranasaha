package com.notification;

import com.notification.R;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NotificationActivity extends Activity {
	   
	   private NotificationManager mNotificationManager;
	   private int SIMPLE_NOTFICATION_ID;
	   
	    /** Called when the activity is first created. */
		@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	       /* To create notifications you use the NotificationManager class which can be received from the Activity 
	        * via the getSystemService() method.  */
	        
	    mNotificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
	        
	      final Notification notifyDetails = new Notification(R.drawable.arrow,"New Alert, Click Me!",System.currentTimeMillis());
	      
	      long[] vibrate = {100,100,200,300};
          notifyDetails.vibrate = vibrate;
          notifyDetails.defaults =Notification.DEFAULT_ALL;
          Context context = getApplicationContext();

	        Button start = (Button)findViewById(R.id.btn_showsample);
	        Button cancel = (Button)findViewById(R.id.btn_clear);
	       
	        start.setOnClickListener(new OnClickListener() {
	           
	           public void onClick(View v) {
	              
	              
	              Context context = getApplicationContext();
	              CharSequence contentTitle = "Example of Simple Notification";
	              CharSequence contentText = "Get back to Application on clicking me";
	          
	              Intent notifyIntent = new Intent(context, NotificationActivity.class);
//allows the foreign application to use your application's permissions to execute a predefined piece of code.
	              PendingIntent intent =
	                PendingIntent.getActivity(NotificationActivity.this, 0,
	                 notifyIntent, android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
	              
	              notifyDetails.setLatestEventInfo(context, contentTitle, contentText, intent);
	  	     
	              mNotificationManager.notify(SIMPLE_NOTFICATION_ID, notifyDetails);
	             
	           }
	        });
	       
	        cancel.setOnClickListener(new OnClickListener() {
	           
	           public void onClick(View v) {
	              
	              mNotificationManager.cancel(SIMPLE_NOTFICATION_ID);
	           }
	        });
	        }
	}