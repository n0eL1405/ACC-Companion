package de.leon.acccompanion;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.redmadrobot.inputmask.MaskedTextChangedListener;
import com.redmadrobot.inputmask.MaskedTextChangedListener.ValueListener;
import de.leon.acccompanion.databinding.ActivityMainBinding;
import de.leon.acccompanion.ui.data.Car;
import de.leon.acccompanion.ui.data.FuelPerLap;
import de.leon.acccompanion.ui.data.LapTime;
import de.leon.acccompanion.ui.data.RaceTime;
import de.leon.acccompanion.ui.data.Track;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private List<Track> tracks;
    private List<Car> cars;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        initElements();
    }

    private void initElements() {
        totalRaceTimeTIL = findViewById(R.id.totalRaceTimeTIL);
        MaskedTextChangedListener totalRaceTimeMTCL = MaskedTextChangedListener.Companion.installOn(
            totalRaceTimeTIL.getEditText(), "[00]:[00]:[00]", new ValueListener() {
                @Override
                public void onTextChanged(boolean b, @NonNull String rawString, @NonNull String formattedString) {
                  try {
                    totalRaceTime = new RaceTime(rawString);
                  } catch (IllegalAccessException e) {
                    totalRaceTime = new RaceTime();
                  }
                }
            }
        );
        totalRaceTimeTIL.getEditText().setText(totalRaceTimeMTCL.placeholder());
        totalRaceTimeTIL.setHelperText("HH:MM:SS");

        averageLapTimeTIL = findViewById(R.id.averageLapTimeTIL);
        MaskedTextChangedListener averageLapTimeMTCL = MaskedTextChangedListener.Companion.installOn(
            averageLapTimeTIL.getEditText(), "[00]:[00].[000]", new ValueListener() {
                @Override
                public void onTextChanged(boolean b, @NonNull String rawString, @NonNull String formattedString) {
                  try {
                    averageLapTime = new LapTime(rawString);
                  } catch (IllegalAccessException e) {
                    averageLapTime = new LapTime();
                  }
                }
            }
        );
        averageLapTimeTIL.getEditText().setText(averageLapTimeMTCL.placeholder());
        averageLapTimeTIL.setHelperText("MM:SS.sss");

        totalLapsTIL = findViewById(R.id.totalLapsTIL);
        MaskedTextChangedListener totalLapsMTCL = MaskedTextChangedListener.Companion.installOn(
            totalLapsTIL.getEditText(), "[___0]", new ValueListener() {
                @Override
                public void onTextChanged(boolean b, @NonNull String rawString, @NonNull String formattedString) {
                  if (!rawString.equals("")) {
                    totalLaps = Integer.parseInt(rawString);
                  } else {
                    totalLaps = 0;
                  }
                }
            }
        );
        totalLapsTIL.getEditText().setText(totalLapsMTCL.placeholder());

        fuelPerLapTIL = findViewById(R.id.fuelPerLapTIL);
        MaskedTextChangedListener fuelPerLapMTCL = MaskedTextChangedListener.Companion.installOn(
            fuelPerLapTIL.getEditText(), "[0].[00]l", new ValueListener() {
                @Override
                public void onTextChanged(boolean b, @NonNull String rawString, @NonNull String formattedString) {
                  try {
                    fuelPerLap = new FuelPerLap(rawString.replace("l", ""));
                  } catch (IllegalAccessException e) {
                    fuelPerLap = new FuelPerLap();
                  }
                }
            }
        );
        fuelPerLapTIL.getEditText().setText(fuelPerLapMTCL.placeholder());

        fuelTankCapacityTIL = findViewById(R.id.fuelTankCapacityTIL);
        MaskedTextChangedListener fuelTankCapacityMTCL = MaskedTextChangedListener.Companion.installOn(
            fuelTankCapacityTIL.getEditText(), "[__0]l", new ValueListener() {
                @Override
                public void onTextChanged(boolean b, @NonNull String rawString, @NonNull String formattedString) {
                  if (!rawString.equals("")) {
                    fuelTankCapacity = Integer.parseInt(rawString.replace("l", ""));
                  } else {
                    fuelTankCapacity = 0;
                  }
                }
            }
        );
        fuelTankCapacityTIL.getEditText().setText(fuelTankCapacityMTCL.placeholder());
    }

}