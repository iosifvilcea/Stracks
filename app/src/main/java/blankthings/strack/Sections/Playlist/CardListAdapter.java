package blankthings.strack.sections.Playlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import blankthings.strack.R;

/**
 * Created by iosifvilcea on 10/20/16.
 */

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.CardListViewHolder> {

    public final static String TAG = CardListAdapter.class.getSimpleName();
    private final static int CARDVIEW = 0;
    private final static int PLAYLISTVIEW = 1;

    private static OnItemClickListener onItemClickListener;
    private ArrayList<Song> playlist = new ArrayList<>();


    @Override
    public CardListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;

        // TODO - SEPARATE VIEW HOLDERS.
        switch (viewType) {
            case PLAYLISTVIEW:
                view = inflater.inflate(R.layout.song_item, parent, false);
                break;
            case CARDVIEW:
                // intentional fall-through.
            default:
                view = inflater.inflate(R.layout.card_list_item, parent, false);
                break;
        }

        return new CardListViewHolder(view);
    }


    @Override
    public void onBindViewHolder(CardListViewHolder holder, int position) {
        if (holder == null) {
            return;
        }

        Song song = playlist.get(position);

        final String songTitle = song.getTitle();
        final String artistName = song.getArtist();

        if (holder.songTitle != null) {
            holder.songTitle.setText(songTitle);
        }

        if (holder.artistName != null) {
            holder.artistName.setText(artistName);
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return PLAYLISTVIEW;
        } else {
            return CARDVIEW;
        }
    }


    @Override
    public int getItemCount() {
        return playlist.size();
    }


    //
    public void setPlaylist(final ArrayList<Song> list) {
        Log.e(TAG, "CardListAdapter setPlaylist.");
        if (list != null && !list.isEmpty()) {
            this.playlist.clear();
            this.playlist.addAll(list);
            notifyDataSetChanged();
        }
    }


    //
    public void addSong(final Song song) {
        if (song != null) {
            playlist.add(song);
            final int lastPosition = playlist.size() - 1;
            notifyItemInserted(lastPosition);
        }
    }


    //
    public void removeSong(final Song song) {
        if (song != null) {
            playlist.remove(song);
            final int lastPosition = playlist.size() - 1;
            notifyItemRemoved(lastPosition);
        }
    }


    //
    public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    //
    public static class CardListViewHolder extends RecyclerView.ViewHolder {

        public TextView songTitle;
        public TextView artistName;

        public CardListViewHolder(View itemView) {
            super(itemView);

            songTitle = (TextView) itemView.findViewById(R.id.songTitle);
            artistName = (TextView) itemView.findViewById(R.id.songArtist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(v, getLayoutPosition());
                }
            });
        }
    }
}
