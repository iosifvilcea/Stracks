package blankthings.strack.Sections.Playlist;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

import blankthings.strack.R;

/**
 * Created by iosifvilcea on 10/18/16.
 */

public class PlaylistView extends FrameLayout implements OnItemClickListener {

    private View playerLayout;
    private PlaylistAdapter adapter;
    private TextView selectedSongTitle;
    private TextView selectedArtistName;

    public PlaylistView(Context context) {
        super(context);
        inflate(context, R.layout.playlist_view, this);
        setupViews();
    }


    //
    protected void setupViews() {
        playerLayout = findViewById(R.id.player_layout_id);
        selectedSongTitle = (TextView) findViewById(R.id.playerSongName);
        selectedArtistName = (TextView) findViewById(R.id.playerArtistName);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.playlistRecyclerView);
        adapter = new PlaylistAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setOnItemClickListener(this);
    }


    //
    public void setPlaylist(final ArrayList<Song> playlist) {
        if (adapter != null) {
            adapter.setPlaylist(playlist);
        }
    }

    @Override
    public void onItemClick(View itemView, int position) {
        final Song song = adapter.getSongAtPosition(position);
        playerLayout.setVisibility(View.VISIBLE);
        selectedSongTitle.setText(song.getTitle());
        selectedArtistName.setText(song.getArtist());
    }
}
