package blankthings.strack.sections.SavingsCalendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import blankthings.strack.R;
import blankthings.strack.sections.Base.BaseFragment;

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


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.paymnts_fragment, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.paymnts_viewpager);
        final PaymntsPagerAdapter adapter = new PaymntsPagerAdapter(getContext());
        viewPager.setAdapter(adapter);

        final TabLayout tabLayout = (TabLayout) view.findViewById(R.id.paymnts_sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

}
