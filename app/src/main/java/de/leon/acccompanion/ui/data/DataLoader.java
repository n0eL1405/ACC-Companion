package de.leon.acccompanion.ui.data;

import android.util.JsonReader;
import de.leon.acccompanion.ui.data.Car.Manufacturer;
import de.leon.acccompanion.ui.data.Car.RaceClass;
import de.leon.acccompanion.ui.data.Data.DLC;
import de.leon.acccompanion.ui.data.Track.Country;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class DataLoader {

  public static List<Track> loadTracks(InputStream inputStream) throws IOException {
    List<Track> trackList = new LinkedList<>();

    try (JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"))) {
      reader.beginArray();
      while (reader.hasNext()) {
        trackList.add(parseTrack(reader));
      }
      reader.endArray();
    }

    return trackList;
  }

  private static Track parseTrack(JsonReader reader) throws IOException {

    int id = -1;
    String trackName = "";
    String description = "";
    DLC dlc = DLC.BASE;
    Country country = Country.Italy;
    int lengthInM = -1;
    int dataVersion = -1;

    reader.beginObject();
    while (reader.hasNext()) {
      String name = reader.nextName();
      switch (name) {
        case "id":
          id = reader.nextInt();
          break;
        case "name":
          trackName = reader.nextString();
          break;
        case "description":
          description = reader.nextString();
          break;
        case "dlc":
          String dlcString = reader.nextString();
          if (dlcString.isEmpty()) {
            dlc = DLC.BASE;
          } else {
            dlc = DLC.valueOf(dlcString);
          }
          break;
        case "country":
          String countryString = reader.nextString();
          if (countryString.isEmpty()) {
            country = Country.Italy;
          } else {
            country = Country.valueOf(countryString);
          }
          break;
        case "lengthInM":
          lengthInM = reader.nextInt();
          break;
        case "dataVersion":
          dataVersion = reader.nextInt();
          break;
        default:
          reader.skipValue();
          break;
      }
    }
    reader.endObject();

    return new Track(id, trackName, description, dlc, country, lengthInM, dataVersion);
  }

  public static List<Car> loadCars(InputStream inputStream) throws IOException {
    List<Car> carList = new LinkedList<>();

    try (JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"))) {
      reader.beginArray();
      while (reader.hasNext()) {
        carList.add(parseCar(reader));
      }
      reader.endArray();
    }

    return carList;
  }

  private static Car parseCar(JsonReader reader) throws IOException {

    int id = -1;
    String carName = "";
    String description = "";
    DLC dlc = DLC.BASE;
    Manufacturer manufacturer = Manufacturer.Ferrari;
    RaceClass raceClass = RaceClass.GT3;
    int year = -1;
    int dataVersion = -1;

    reader.beginObject();
    while (reader.hasNext()) {
      String name = reader.nextName();
      switch (name) {
        case "id":
          id = reader.nextInt();
          break;
        case "name":
          carName = reader.nextString();
          break;
        case "description":
          description = reader.nextString();
          break;
        case "dlc":
          String dlcString = reader.nextString();
          if (dlcString.isEmpty()) {
            dlc = DLC.BASE;
          } else {
            dlc = DLC.valueOf(dlcString);
          }
          break;
        case "manufacturer":
          String manufacturerString = reader.nextString();
          if (manufacturerString.isEmpty()) {
            manufacturer = Manufacturer.Ferrari;
          } else {
            manufacturer = Manufacturer.valueOf(manufacturerString);
          }
          break;
        case "raceclass":
          String raceclassString = reader.nextString();
          if (raceclassString.isEmpty()) {
            raceClass = RaceClass.GT3;
          } else {
            raceClass = RaceClass.valueOf(raceclassString);
          }
          break;
        case "year":
          year = reader.nextInt();
          break;
        case "dataVersion":
          dataVersion = reader.nextInt();
          break;
        default:
          reader.skipValue();
          break;
      }
    }
    reader.endObject();

    return new Car(id, carName, description, dlc, manufacturer, raceClass, year, dataVersion);
  }
}
