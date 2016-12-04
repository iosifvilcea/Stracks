package blankthings.strack.Services;

import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.google.android.gms.gcm.GcmListenerService;

import blankthings.strack.R;

/**
 * Created by iosifvilcea on 7/24/16.
 */
public class AppGcmListenerService extends GcmListenerService {

    private final static String NOTIFICATION_GROUP = "notification_group";
    private NotificationManagerCompat notificationManager;
    private static int notificationId = 1;

    @Override
    public void onCreate() {
        super.onCreate();
        notificationManager
                = (NotificationManagerCompat) NotificationManagerCompat.from(getApplicationContext());
    }

    @Override
    public void onMessageReceived(String s, Bundle bundle) {
        final String message = bundle.getString("message");

        sendNotification();
    }


    private void sendNotification() {
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        final Notification notification = builder
                .setContentTitle("Title " + notificationId)
                .setContentText("Descc here .. etc etc.")
                .setSmallIcon(R.drawable.ic_notifications_white_18dp)
                .setGroup(NOTIFICATION_GROUP)
                .build();

        notificationManager.notify(notificationId, notification);
        notificationId++;
    }


    private void buildSummaryNotification() {
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        final Notification summaryNotification = builder
                .setContentTitle(notificationId + " new notifications!")
                .setSmallIcon(R.drawable.ic_notifications_white_18dp)
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("n 1 here")
                        .addLine("n 2 here")
                        .setBigContentTitle("big content title")
                        .setSummaryText("some summary."))
                .setGroup(NOTIFICATION_GROUP)
                .setGroupSummary(true)
                .build();

        notificationManager.notify(notificationId, summaryNotification);
    }
}
