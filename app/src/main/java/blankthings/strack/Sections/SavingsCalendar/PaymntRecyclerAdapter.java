package blankthings.strack.Sections.SavingsCalendar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import blankthings.strack.R;

/**
 * Created by iosifvilcea on 12/10/16.
 */

public class PaymntRecyclerAdapter  extends RecyclerView.Adapter<PaymntRecyclerAdapter.ViewHolder> {

    private final static String TAG = PaymntRecyclerAdapter.class.getSimpleName();
    private List<Payment> payments;

    public PaymntRecyclerAdapter(final List<Payment> payments) {
        this.payments = payments;
    }


    @Override
    public PaymntRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final Context context = parent.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);

        final View view = inflater.inflate(R.layout.paymnts_item, parent, false);
        return new PaymntRecyclerAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PaymntRecyclerAdapter.ViewHolder holder, int position) {
        Payment payment = payments.get(position);

        final String paymentName = payment.getPaymentName();
        final double paymentAmount = payment.getPaymentAmount();

        if (!TextUtils.isEmpty(paymentName)) {
            holder.paymentName.setText(paymentName);
        }

        if (paymentAmount != 0) {
            final String amount = String.valueOf(paymentAmount);
            holder.paymentAmount.setText(amount);
        }
    }


    @Override
    public int getItemCount() {
        return payments.size();
    }


    /**
     *  Recycler ViewHolder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView paymentName;
        public TextView paymentAmount;

        public ViewHolder(View itemView) {
            super(itemView);
            paymentName = (TextView) itemView.findViewById(R.id.paymentName);
            paymentAmount = (TextView) itemView.findViewById(R.id.paymentAmount);
        }
    }

}