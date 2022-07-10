package de.leon.acccompanion.ui.data;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
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
    Gson gson = new Gson();

    JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));

    reader.beginArray();
    while (reader.hasNext()) {
      Track track = gson.fromJson(reader, Track.class);
      trackList.add(track);
    }
    reader.endArray();

    return trackList;
  }

  @Deprecated
  private static Track parseTrack(JsonReader reader) throws IOException {

    int id = -1;
    String trackName = "";
    String description = "";
    DLC dlc = DLC.BASE;
    Country country = Country.Italy;
    int lengthInM = -1;
    String userDescription = "";
    boolean isFavorite = false;
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
        case "userDescription":
          userDescription = reader.nextString();
          break;
        case "isFavorite":
          isFavorite = reader.nextBoolean();
          break;
        default:
          reader.skipValue();
          break;
      }
    }
    reader.endObject();

    return new Track(id, trackName, description, userDescription, dlc, country, lengthInM,
        isFavorite, dataVersion);
  }

  public static List<Car> loadCars(InputStream inputStream) throws IOException {
    List<Car> carList = new LinkedList<>();
    Gson gson = new Gson();

    JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));

    reader.beginArray();
    while (reader.hasNext()) {
      Car car = gson.fromJson(reader, Car.class);
      carList.add(car);
    }
    reader.endArray();

    return carList;
  }

  @Deprecated
  private static Car parseCar(JsonReader reader)
      throws IOException {

    int id = -1;
    String carName = "";
    String description = "";
    DLC dlc = DLC.BASE;
    Manufacturer manufacturer = Manufacturer.Ferrari;
    RaceClass raceClass = RaceClass.GT3;
    int year = -1;
    String userDescription = "";
    boolean isFavorite = false;
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
          if (!dlcString.isEmpty()) {
            dlc = DLC.valueOf(dlcString);
          }
          break;
        case "manufacturer":
          String manufacturerString = reader.nextString();
          if (!manufacturerString.isEmpty()) {
            manufacturer = Manufacturer.valueOf(manufacturerString);
          }
          break;
        case "raceclass":
          String raceclassString = reader.nextString();
          if (!raceclassString.isEmpty()) {
            raceClass = RaceClass.valueOf(raceclassString);
          }
          break;
        case "year":
          year = reader.nextInt();
          break;
        case "dataVersion":
          dataVersion = reader.nextInt();
          break;
        case "userDescription":
          userDescription = reader.nextString();
          break;
        case "isFavorite":
          isFavorite = reader.nextBoolean();
          break;
        default:
          reader.skipValue();
          break;
      }
    }
    reader.endObject();

    return new Car(id, carName, description, userDescription, dlc, manufacturer, raceClass, year,
        isFavorite, dataVersion);
  }
}
