package de.leon.acccompanion.ui.data;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import lombok.NonNull;

public class Track extends Data {

  @SerializedName("country")
  private final Country country;
  @SerializedName("lengthInM")
  private final int lengthInM;

  public Track(@NonNull int id, @NonNull String name, @NonNull String description, @NonNull DLC dlc,
      @NonNull Country country, @NonNull int lengthInM,
      @NonNull int dataVersion) {
    super(id, name, description, dlc, dataVersion);
    this.country = country;
    this.lengthInM = lengthInM;
  }

  public Track(@NonNull int id, @NonNull String name, @NonNull String description,
      @NonNull String userDescription, @NonNull DLC dlc,
      @NonNull Country country, @NonNull int lengthInM, @NonNull boolean isFavorite,
      @NonNull int dataVersion) {
    super(id, name, description, userDescription, dlc, isFavorite, dataVersion);
    this.country = country;
    this.lengthInM = lengthInM;
  }

  public Country getCountry() {
    return country;
  }

  public int getLengthInM() {
    return lengthInM;
  }

  public Double getLengthInKM() {
    return ((double) lengthInM) / 1000;
  }

  public HashMap<String, String> toHashMap() {
    HashMap<String, String> hashMap = new HashMap<>();

    hashMap.put(TrackHashMapKeys.id.toString(), String.valueOf(super.getId()));
    hashMap.put(TrackHashMapKeys.name.toString(), super.getName());
    hashMap.put(TrackHashMapKeys.description.toString(), super.getDescription());
    hashMap.put(TrackHashMapKeys.dlc.toString(), super.getDlc().toString());
    hashMap.put(TrackHashMapKeys.country.toString(), country.toString());
    hashMap.put(TrackHashMapKeys.length.toString(), String.valueOf(lengthInM));
    hashMap.put(TrackHashMapKeys.dataversion.toString(), String.valueOf(super.getDataVersion()));

    return hashMap;
  }

  public enum Country {
    Australia,
    Germany,
    UK,
    Belgium,
    France,
    USA,
    Hungary,
    South_Africa,
    Japan,
    Spain,
    Italy,
    Netherlands
  }

  public enum TrackHashMapKeys {
    id,
    name,
    description,
    dlc,
    country,
    length,
    dataversion
  }
}
