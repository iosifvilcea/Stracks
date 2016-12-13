package blankthings.strack;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.List;

import blankthings.strack.sections.Base.OnBackPressedListener;
import blankthings.strack.sections.Home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    private Toolbar toolbar;
    private final Navigator navigator = Navigator.INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigator.initializeNavigator(this);
        setupInitialFragment();
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (!isGooglePlayServicesAvailable(this)) {
            GoogleApiAvailability.getInstance().makeGooglePlayServicesAvailable(this);
        }
    }

    //
    public boolean isGooglePlayServicesAvailable(final Context context) {
        final GoogleApiAvailability availability = GoogleApiAvailability.getInstance();
        final int result = availability.isGooglePlayServicesAvailable(context);
        return (result == ConnectionResult.SUCCESS);
    }


    //
    public Toolbar getToolbar() {
        return toolbar;
    }


    //
    public void setupInitialFragment() {
        navigator.replaceFragment(HomeFragment.newInstance());
    }


    @Override
    public void onBackPressed() {
        /** Notify Fragments onBackPressed() */
        final List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
        for (final Fragment fragment : fragmentList) {
            if (fragment instanceof OnBackPressedListener) {
                ((OnBackPressedListener) fragment).onBackPressed();
            }
        }

        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStackImmediate();
        } else {
            getSupportFragmentManager().popBackStackImmediate();
            super.onBackPressed();
        }
    }
}
