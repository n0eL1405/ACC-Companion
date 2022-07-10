package de.leon.acccompanion.ui.tracks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import de.leon.acccompanion.ui.data.DataLoader;
import de.leon.acccompanion.ui.data.Track;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class TracksViewModel extends ViewModel {

    private final MutableLiveData<List<Track>> trackList;

    public TracksViewModel() {
        trackList = new MutableLiveData<>();
    }

    public LiveData<List<Track>> loadTracks(InputStream inputStream) {
        if (trackList.getValue() == null) {
            forceReloadTracks(inputStream);
        }
        return trackList;
    }

    public void forceReloadTracks(InputStream inputStream) {
        try {
            trackList.setValue(DataLoader.loadTracks(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
            trackList.setValue(new LinkedList<>());
        }
    }
}