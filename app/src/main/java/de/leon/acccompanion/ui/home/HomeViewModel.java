package de.leon.acccompanion.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import de.leon.acccompanion.ui.data.FuelPerLap;
import de.leon.acccompanion.ui.data.LapTime;
import de.leon.acccompanion.ui.data.RaceTime;

public class HomeViewModel extends ViewModel {

  private final MutableLiveData<String> mText;
  private MutableLiveData<LapTime> averageLapTime;
  private MutableLiveData<RaceTime> totalRaceTime;
  private MutableLiveData<FuelPerLap> fuelPerLap;
  private MutableLiveData<Integer> totalLaps;
  private MutableLiveData<Integer> fuelTankCapacity;

  public HomeViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("This is home fragment");

    averageLapTime = new MutableLiveData<>();
    totalRaceTime = new MutableLiveData<>();
    fuelPerLap = new MutableLiveData<>();
    totalLaps = new MutableLiveData<>();
    fuelTankCapacity = new MutableLiveData<>();

    averageLapTime.setValue(new LapTime());
    totalRaceTime.setValue(new RaceTime());
    fuelPerLap.setValue(new FuelPerLap());
    totalLaps.setValue(0);
    fuelTankCapacity.setValue(0);
  }

  public LiveData<String> getText() {
    return mText;
  }

  public LiveData<LapTime> getAverageLapTime() {
    return averageLapTime;
  }

  public void setAverageLapTime(LapTime averageLapTime) {
    this.averageLapTime.setValue(averageLapTime);
  }

  public LiveData<RaceTime> getTotalRaceTime() {
    return totalRaceTime;
  }

  public void setTotalRaceTime(RaceTime totalRaceTime) {
    this.totalRaceTime.setValue(totalRaceTime);
  }

  public LiveData<FuelPerLap> getFuelPerLap() {
    return fuelPerLap;
  }

  public void setFuelPerLap(FuelPerLap fuelPerLap) {
    this.fuelPerLap.setValue(fuelPerLap);
  }

  public LiveData<Integer> getTotalLaps() {
    return totalLaps;
  }

  public void setTotalLaps(int totalLaps) {
    this.totalLaps.setValue(totalLaps);
  }

  public LiveData<Integer> getFuelTankCapacity() {
    return fuelTankCapacity;
  }

  public void setFuelTankCapacity(int fuelTankCapacity) {
    this.fuelTankCapacity.setValue(fuelTankCapacity);
  }
}