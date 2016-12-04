package blankthings.strack.Sections.Playlist;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;

import blankthings.strack.R;

/**
 * Created by iosifvilcea on 10/20/16.
 */

public class CardListView extends FrameLayout implements OnItemClickListener {

    public final static String TAG = CardListView.class.getSimpleName();
    protected CardListAdapter adapter;

    public CardListView(Context context) {
        super(context);
        setupViews();
    }


    //
    protected void setupViews() {
        final LayoutInflater inflater =  LayoutInflater.from(getContext());
        final View view = inflater.inflate(R.layout.playlist_view_layout, this, true);

        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.playlistRecyclerView);
        adapter = new CardListAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setOnItemClickListener(this);
    }


    //
    public void setCardList(final ArrayList<Song> playlist) {
        if (adapter != null) {
            adapter.setPlaylist(playlist);
        }
    }


    @Override
    public void onItemClick(View itemView, int position) {
        // TODO
        Log.e(TAG, "OnItemClicked.");
    }
}
