package blankthings.strack.fcmservices;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * App's Firebase Instance ID Service
 *   Handles creation, rotation and updating registration tokens.
 *
 * Created by iosifvilcea on 12/12/16.
 */

public class AppFirebaseInstanceIDService extends FirebaseInstanceIdService {

    public static final String TAG = AppFirebaseInstanceIDService.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        final String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        sendRegistrationToServer(refreshedToken);
    }


    private void sendRegistrationToServer(final String refreshedToken) {
        // TODO - Send Instance ID token to app server in order to manage subscriptions.
    }
}
