package blankthings.strack.Services;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by iosifvilcea on 7/24/16.
 */
public class AppInstanceIDListenerService extends InstanceIDListenerService {

/**
 * Called if InstanceID token is updated. This may occur if the security of
 * the previous token had been compromised. This call is initiated by the
 * InstanceID provider.
 **/
    @Override
    public void onTokenRefresh() {
        Intent intent = new Intent(this, AppGcmListenerService.class);
        startService(intent);
    }
}
