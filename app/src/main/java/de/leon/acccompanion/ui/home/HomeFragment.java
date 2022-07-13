package de.leon.acccompanion.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.textfield.TextInputLayout;
import de.leon.acccompanion.databinding.FragmentHomeBinding;
import de.leon.acccompanion.ui.data.FuelPerLap;
import de.leon.acccompanion.ui.data.LapTime;
import de.leon.acccompanion.ui.data.RaceTime;
import java.util.Objects;

public class HomeFragment extends Fragment {

  private HomeViewModel homeViewModel;
  private FragmentHomeBinding binding;

  private TextInputLayout totalRaceTimeTIL;
  private TextInputLayout averageLapTimeTIL;
  private TextInputLayout totalLapsTIL;
  private TextInputLayout fuelPerLapTIL;
  private TextInputLayout fuelTankCapacityTIL;

  private RaceTime totalRaceTime;
  private LapTime averageLapTime;
  private int totalLaps;
  private FuelPerLap fuelPerLap;
  private int fuelTankCapacity;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    homeViewModel =
        new ViewModelProvider(this).get(HomeViewModel.class);

    binding = FragmentHomeBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

    initElements(homeViewModel);

    //final TextView textView = binding.textHome;
    //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
    return root;
  }

  @Override
  public void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    homeViewModel.setFuelPerLap(fuelPerLap);
    homeViewModel.setAverageLapTime(averageLapTime);
    homeViewModel.setFuelTankCapacity(fuelTankCapacity);
    homeViewModel.setTotalLaps(totalLaps);
    homeViewModel.setTotalRaceTime(totalRaceTime);
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

  private void initElements(HomeViewModel homeViewModel) {
    totalRaceTimeTIL = binding.totalRaceTimeTIL;
    homeViewModel.getTotalRaceTime().observe(getViewLifecycleOwner(),
        value -> {
          totalRaceTime = value;
          Objects.requireNonNull(totalRaceTimeTIL.getEditText()).setText(value.toString());
        });

    averageLapTimeTIL = binding.averageLapTimeTIL;
    homeViewModel.getAverageLapTime().observe(getViewLifecycleOwner(),
        value -> {
          averageLapTime = value;
          Objects.requireNonNull(averageLapTimeTIL.getEditText()).setText(value.toString());
        });

    totalLapsTIL = binding.totalLapsTIL;
    homeViewModel.getTotalLaps().observe(getViewLifecycleOwner(),
        value -> {
          totalLaps = value;
          Objects.requireNonNull(totalLapsTIL.getEditText()).setText(String.valueOf(value));
        });

    fuelPerLapTIL = binding.fuelPerLapTIL;
    homeViewModel.getFuelPerLap().observe(getViewLifecycleOwner(),
        value -> {
          fuelPerLap = value;
          Objects.requireNonNull(fuelPerLapTIL.getEditText()).setText(value.toString());
        });

    fuelTankCapacityTIL = binding.fuelTankCapacityTIL;
    homeViewModel.getFuelTankCapacity().observe(getViewLifecycleOwner(),
        value -> {
          fuelTankCapacity = value;
          Objects.requireNonNull(fuelTankCapacityTIL.getEditText()).setText(String.valueOf(value));
        });
  }
}