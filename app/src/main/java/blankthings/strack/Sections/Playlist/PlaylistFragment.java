package blankthings.strack.Sections.Playlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import blankthings.strack.Sections.Base.BaseFragment;

/**
 * PlaylistFragment
 *
 * Created by iosifvilcea on 6/18/16.
 */
public class PlaylistFragment extends BaseFragment {
    public static PlaylistFragment newInstance() {
        PlaylistFragment fragment = new PlaylistFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    public static final String TAG = PlaylistFragment.class.getSimpleName();
    protected CardListView cardListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        cardListView = new CardListView(getContext());
        return cardListView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ArrayList<Song> songs = generateDummyData(10);
        cardListView.setCardList(songs);
    }


    //
    protected ArrayList<Song> generateDummyData(final int numberOfDummies) {
        ArrayList<Song> songs = new ArrayList<>();
        for (int i=0; i<numberOfDummies; i++) {
            final String title = "Song Title Number" + i;
            final String artist = "Artist " + i;
            Song song = new Song(title, artist, "www.youtube.com");
            songs.add(song);
        }

        return songs;
    }
}
