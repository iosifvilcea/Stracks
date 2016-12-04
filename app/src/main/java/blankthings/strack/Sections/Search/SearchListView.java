package blankthings.strack.Sections.Search;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import java.util.ArrayList;

import blankthings.strack.R;

/**
 * Created by iosifvilcea on 10/18/16.
 */

public class SearchListView extends FrameLayout {

    public static final String TAG = SearchListView.class.getSimpleName();
    private SearchAdapter searchAdapter;

    public SearchListView(Context context) {
        super(context);
        setupViews(context);
    }


    //
    protected void setupViews(final Context context) {
        inflate(context, R.layout.search_list_view, this);
        searchAdapter = new SearchAdapter(context);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.searchRecycler);
        recyclerView.setAdapter(searchAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    //
    public void setOnItemClickListener(final SearchAdapter.OnItemClickListener onItemClickListener) {
        if (searchAdapter != null) {
            searchAdapter.setOnItemClickListener(onItemClickListener);
        }
    }


    //
    public void populateSearch(ArrayList<String> searchResults) {
        searchAdapter.addSearchResults(searchResults);
    }
}
