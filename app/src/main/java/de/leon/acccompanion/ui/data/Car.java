package de.leon.acccompanion.ui.data;

import java.util.HashMap;
import lombok.NonNull;

public class Car extends Data {

  private final Manufacturer manufacturer;
  private final RaceClass raceClass;
  private final int year;

  public Car(@NonNull int id, @NonNull String name, @NonNull String description, @NonNull DLC dlc,
      @NonNull Manufacturer manufacturer, @NonNull RaceClass raceClass,
      @NonNull int year, @NonNull int dataVersion) {
    super(id, name, description, dlc, dataVersion);
    this.manufacturer = manufacturer;
    this.raceClass = raceClass;
    this.year = year;
  }

  public Manufacturer getManufacturer() {
    return manufacturer;
  }

  public RaceClass getRaceClass() {
    return raceClass;
  }

  public int getYear() {
    return year;
  }

  public HashMap<String, String> toHashMap() {
    HashMap<String, String> hashMap = new HashMap<>();

    hashMap.put(CarHashMapKeys.id.toString(), String.valueOf(super.getId()));
    hashMap.put(CarHashMapKeys.name.toString(), super.getName());
    hashMap.put(CarHashMapKeys.description.toString(), super.getDescription());
    hashMap.put(CarHashMapKeys.dlc.toString(), super.getDlc().toString());
    hashMap.put(CarHashMapKeys.manufacturer.toString(), manufacturer.toString());
    hashMap.put(CarHashMapKeys.raceclass.toString(), raceClass.toString());
    hashMap.put(CarHashMapKeys.year.toString(), String.valueOf(year));
    hashMap.put(CarHashMapKeys.dataversion.toString(), String.valueOf(super.getDataVersion()));

    return hashMap;
  }

  public enum Manufacturer {
    Alpine,
    Aston_Martin,
    Audi,
    Bentley,
    BMW,
    Chevrolet,
    Ferrari,
    Ginetta,
    Honda,
    Jaguar,
    KTM,
    Lamborghini,
    Lexus,
    Maserati,
    McLaren,
    Mercedes,
    Nissan,
    Porsche
  }

  public enum RaceClass {
    GT3,
    GT4,
    GTC,
    TCX,
    ST,
    PC
  }

  public enum CarHashMapKeys {
    id,
    name,
    description,
    dlc,
    manufacturer,
    raceclass,
    year,
    dataversion
  }
}
