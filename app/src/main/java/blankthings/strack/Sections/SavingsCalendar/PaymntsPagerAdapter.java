package blankthings.strack.sections.SavingsCalendar;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import blankthings.strack.R;

/**
 * Created by iosifvilcea on 12/10/16.
 */

public class PaymntsPagerAdapter extends PagerAdapter {


    private final Context context;
    private String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    final List<Payment> payments;

    public PaymntsPagerAdapter(final Context context) {
        this.context = context;

        payments = new ArrayList<>();
        payments.add(new Payment(23.11, "Shoes"));
        payments.add(new Payment(5.45, "Popeyes"));
        payments.add(new Payment(12.01, "Target"));
        payments.add(new Payment(10.89, "McDonalds"));
        payments.add(new Payment(9.99, "Netflix"));
        payments.add(new Payment(23.11, "Shoes"));
        payments.add(new Payment(5.45, "Popeyes"));
        payments.add(new Payment(12.01, "Target"));
        payments.add(new Payment(10.89, "McDonalds"));
        payments.add(new Payment(9.99, "Netflix"));
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.paymnts_view, container, false);

        final PaymntRecyclerAdapter adapter = new PaymntRecyclerAdapter(payments);
        final RecyclerView paymntsRecycler = (RecyclerView) view.findViewById(R.id.paymntRecycler);
        paymntsRecycler.setLayoutManager(new LinearLayoutManager(context));
        paymntsRecycler.setAdapter(adapter);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return days[position];
    }

    @Override
    public int getCount() {
        return days.length;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
