package blankthings.strack;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.List;

import blankthings.strack.Sections.Base.OnBackPressedListener;
import blankthings.strack.Sections.Home.HomeFragment;

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
