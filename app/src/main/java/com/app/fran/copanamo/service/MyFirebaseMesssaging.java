package com.app.fran.copanamo.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;

import com.app.fran.copanamo.R;
import com.app.fran.copanamo.activitys.MainActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.squareup.picasso.Picasso;

import java.io.IOException;


public class MyFirebaseMesssaging extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        showNotification( remoteMessage.getNotification());
    }

    private void showNotification(RemoteMessage.Notification notification) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);


        String url = "https://instagram.ffor8-2.fna.fbcdn.net/vp/0137ef5b61b5ff8af66110c6bcdf9e39/5BC958F8/t51.2885-19/s150x150/33853149_379508135867673_2483148227084288000_n.jpg";
        Bitmap bitmap = null;
        try {
            bitmap = Picasso.with( this )
                    .load( url )
                    .get();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //seta a notificacao
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"channel_id")
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setStyle( new NotificationCompat.BigTextStyle().bigText(notification.getBody()))
                .setLargeIcon(bitmap)
                .setAutoCancel( true )
                .setVibrate(new long[] { 1000, 1000})
                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                .setContentIntent( pendingIntent );


        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());

    }



}
