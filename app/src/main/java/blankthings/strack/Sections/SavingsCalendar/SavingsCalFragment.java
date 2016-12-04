package blankthings.strack.Sections.SavingsCalendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import blankthings.strack.Sections.Base.BaseFragment;

/**
 * Created by iosifvilcea on 12/4/16.
 */

public class SavingsCalFragment extends BaseFragment {

    public final static String TAG = SavingsCalFragment.class.getSimpleName();

    public static SavingsCalFragment newInstance() {
        final Bundle args = new Bundle();

        SavingsCalFragment fragment = new SavingsCalFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
