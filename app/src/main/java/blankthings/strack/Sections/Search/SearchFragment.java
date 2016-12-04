package blankthings.strack.Sections.Search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import blankthings.strack.MainActivity;
import blankthings.strack.R;
import blankthings.strack.Sections.Base.BaseFragment;

/**
 * SearchFragment
 * Created by iosifvilcea on 6/19/16.
 */
public class SearchFragment extends BaseFragment {

    public static SearchFragment newInstance() {
        Bundle args = new Bundle();

        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private final static String TAG = SearchFragment.class.getSimpleName();
    private SearchListView searchListView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        searchListView = new SearchListView(getContext());
        return searchListView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchListView.setOnItemClickListener(onSearchedItemClick);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        Toolbar toolbar = ((MainActivity)getActivity()).getToolbar();
        Menu toolbarMenu = toolbar.getMenu();
        MenuItem searchItem = toolbarMenu.findItem(R.id.searchItem);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(queryTextListener);
    }


    //
    private final SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {

            // TODO - Handle Query Text Submit.

            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };


    //
    private final SearchAdapter.OnItemClickListener onSearchedItemClick = new SearchAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View itemView, int position) {

            // TODO - Handle search item clicked.

        }
    };
}
