package de.leon.acccompanion.ui.cars;

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
import de.leon.acccompanion.databinding.FragmentCarsBinding;
import de.leon.acccompanion.ui.data.Car.CarHashMapKeys;
import java.util.ArrayList;
import java.util.HashMap;

public class CarsFragment extends Fragment {

    ArrayList<HashMap<String, String>> carHashmaps = new ArrayList<>();

    private FragmentCarsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CarsViewModel carsViewModel =
                new ViewModelProvider(this).get(CarsViewModel.class);

        binding = FragmentCarsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        carsViewModel.loadCars(getResources().openRawResource(R.raw.cars)).getValue()
            .forEach(car -> carHashmaps.add(car.toHashMap()));

        ListAdapter adapter = new SimpleAdapter(this.getContext(), carHashmaps, R.layout.list_cars,
            new String[]{CarHashMapKeys.name.toString(), CarHashMapKeys.description.toString(),
                CarHashMapKeys.dlc.toString(), CarHashMapKeys.manufacturer.toString(),
                CarHashMapKeys.raceclass.toString(), CarHashMapKeys.year.toString()},
            new int[]{R.id.name, R.id.description, R.id.dlc, R.id.manufacturer, R.id.raceclass, R.id.year});

        binding.carList.setAdapter(adapter);

        //final TextView textView = binding.textHome;
        //carsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}