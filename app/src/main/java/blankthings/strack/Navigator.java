package blankthings.strack;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import java.lang.ref.WeakReference;

import blankthings.strack.Sections.Playlist.PlaylistFragment;
import blankthings.strack.Sections.SavingsCalendar.SavingsCalFragment;
import blankthings.strack.Sections.Search.SearchFragment;

/**
 * Navigator
 *   Handles navigation to different fragments.
 *
 * Created by iosifvilcea on 7/9/16.
 */
public enum Navigator {

    INSTANCE;

    public final static String TAG = Navigator.class.getSimpleName();
    private View loadingView;
    private WeakReference<MainActivity> mainActivityRef;


    /**
     * initializeNavigator
     * @param mainActivity - current (and only) activity.
     */
    public void initializeNavigator(final MainActivity mainActivity) {
        if (mainActivityRef == null) {
            throw new NullPointerException("MainActivity cannot be null.");
        }

        mainActivityRef = new WeakReference<>(mainActivity);
        loadingView = mainActivity.findViewById(R.id.loadingView);
        loadingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             // DO NOTHING.
            }
        });
    }


    /**
     * replaceFragment
     * @param fragment - top fragment to be added to the stack.
     */
    public void replaceFragment(final Fragment fragment) {
        final MainActivity mainActivity = mainActivityRef.get();
        if (mainActivity == null) {
            return;
        }

        final FragmentTransaction transaction = mainActivity.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    //
    public void goToPlaylist() {
        replaceFragment(PlaylistFragment.newInstance());
    }


    //
    public void goToSearch() {
        replaceFragment(SearchFragment.newInstance());
    }


    //
    public void goToSavingsCal() {
        replaceFragment(SavingsCalFragment.newInstance());
    }


    //
    public void startLoading() {
        loadingView.setVisibility(View.VISIBLE);
    }


    //
    public void stopLoading() {
        loadingView.setVisibility(View.GONE);
    }

}
