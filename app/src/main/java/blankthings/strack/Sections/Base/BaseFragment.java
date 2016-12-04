package blankthings.strack.Sections.Base;

import blankthings.strack.Navigator;

/**
 * BaseFragment
 *
 * Created by iosifvilcea on 6/18/16.
 */
public class BaseFragment extends android.support.v4.app.Fragment implements OnBackPressedListener {

    protected final Navigator navigator = Navigator.INSTANCE;

    @Override
    public void onBackPressed() {
    }

}
