package blankthings.strack.Sections.Search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import blankthings.strack.R;

/**
 * Created by iosifvilcea on 7/14/16.
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private final static String TAG = SearchAdapter.class.getSimpleName();
    private final Context context;
    private ArrayList<String> searchResults;

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public SearchAdapter(final Context context) {
        this.context = context;
        searchResults = new ArrayList<>();
    }


    public void addSearchResults(final ArrayList<String> searchResults) {
        this.searchResults.clear();
        this.searchResults.addAll(searchResults);
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View userView = inflater.inflate(R.layout.user_item, parent, false);
        return new ViewHolder(userView);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String result = searchResults.get(position);

        if (!TextUtils.isEmpty(result)) {
            holder.search.setText(result);
        }
    }


    //
    public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    //
    public String getResultAtPosition(final int position) {
        return searchResults.get(position);
    }


    @Override
    public int getItemCount() {
        return searchResults.size();
    }


    /**
     *  Recycler ViewHolder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView search;

        public ViewHolder(View itemView) {
            super(itemView);
            search = (TextView) itemView.findViewById(R.id.business_name);
        }
    }

}
