package blankthings.strack;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * App
 * - initializes LeakCanary to help detect memory leaks.
 *
 * Created by iosifvilcea on 8/23/16.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }

}
