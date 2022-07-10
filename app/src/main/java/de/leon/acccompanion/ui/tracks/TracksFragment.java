package de.leon.acccompanion.ui.tracks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import de.leon.acccompanion.R;
import de.leon.acccompanion.databinding.FragmentTracksBinding;
import de.leon.acccompanion.ui.data.DataLoader;
import de.leon.acccompanion.ui.data.Track;
import de.leon.acccompanion.ui.data.Track.TrackHashMapKeys;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TracksFragment extends Fragment {

  ArrayList<HashMap<String, String>> trackHashmaps = new ArrayList<>();

  private FragmentTracksBinding binding;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    TracksViewModel tracksViewModel =
        new ViewModelProvider(this).get(TracksViewModel.class);

    binding = FragmentTracksBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

    List<Track> tracks = new LinkedList<>();

    try {
      tracks = DataLoader.loadTracks(getResources().openRawResource(R.raw.tracks));
    } catch (IOException exception) {
      exception.printStackTrace();
    }

    tracks.forEach(track -> trackHashmaps.add(track.toHashMap()));

    ListAdapter adapter = new SimpleAdapter(this.getContext(), trackHashmaps, R.layout.list_tracks,
        new String[]{TrackHashMapKeys.name.toString(), TrackHashMapKeys.description.toString(),
            TrackHashMapKeys.dlc.toString(), TrackHashMapKeys.country.toString(),
            TrackHashMapKeys.length.toString()},
        new int[]{R.id.name, R.id.description, R.id.dlc, R.id.country, R.id.length});

    binding.trackList.setAdapter(adapter);
    return root;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}