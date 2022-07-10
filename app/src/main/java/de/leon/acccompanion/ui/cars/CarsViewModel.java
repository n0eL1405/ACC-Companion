package de.leon.acccompanion.ui.cars;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import de.leon.acccompanion.ui.data.Car;
import de.leon.acccompanion.ui.data.DataLoader;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class CarsViewModel extends ViewModel {

    private final MutableLiveData<List<Car>> carList;

    public CarsViewModel() {
        carList = new MutableLiveData<>();
    }

    public LiveData<List<Car>> loadCars(InputStream inputStream) {
        if (carList.getValue() == null) {
            forceReloadCars(inputStream);
        }
        return carList;
    }

    public void forceReloadCars(InputStream inputStream) {
        try {
            carList.setValue(DataLoader.loadCars(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
            carList.setValue(new LinkedList<>());
        }
    }
}