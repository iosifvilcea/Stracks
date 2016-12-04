package blankthings.strack.Sections.Playlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import blankthings.strack.R;

/**
 * Created by iosifvilcea on 5/17/16.
 */
public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder> {

    private final static String TAG = PlaylistAdapter.class.getSimpleName();
    private ArrayList<Song> playlist;
    private static OnItemClickListener onItemClickListener;


    public PlaylistAdapter() {
        playlist = new ArrayList<>();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View songView = inflater.inflate(R.layout.song_item, parent, false);
        return new ViewHolder(songView);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Song song = playlist.get(position);

        final String songTitle = song.getTitle();
        final String artistName = song.getArtist();

        holder.songTitle.setText(songTitle);
        holder.artistName.setText(artistName);
    }


    public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public void setPlaylist(final ArrayList<Song> playlist) {
        if (playlist != null && !playlist.isEmpty()){
            this.playlist = playlist;
            notifyDataSetChanged();
        }
    }


    public Song getSongAtPosition(final int position) {
        return playlist.get(position);
    }


    @Override
    public int getItemCount() {
        return playlist.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView songTitle;
        public TextView artistName;

        public ViewHolder(View itemView) {
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
