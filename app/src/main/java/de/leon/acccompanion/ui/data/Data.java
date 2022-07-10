package de.leon.acccompanion.ui.data;

import com.google.gson.annotations.SerializedName;
import lombok.NonNull;

public class Data {

  @SerializedName("id")
  private final int id;
  @SerializedName("name")
  private final String name;
  @SerializedName("description")
  private final String description;
  @SerializedName("userDescription")
  private String userDescription;
  @SerializedName("dlc")
  private final DLC dlc;
  @SerializedName("dataVersion")
  private final int dataVersion;
  @SerializedName("isFavorite")
  private boolean isFavorite;

  public Data(@NonNull int id, @NonNull String name, @NonNull String description,
      @NonNull String userDescription, @NonNull DLC dlc, boolean isFavorite,
      @NonNull int dataVersion) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.userDescription = userDescription;
    this.dlc = dlc;
    this.dataVersion = dataVersion;
    this.isFavorite = isFavorite;
  }

  public Data(@NonNull int id, @NonNull String name, @NonNull String description, @NonNull DLC dlc,
      @NonNull int dataVersion) {
    this(id, name, description, "", dlc, false, dataVersion);
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public DLC getDlc() {
    return dlc;
  }

  public int getDataVersion() {
    return dataVersion;
  }

  public String getUserDescription() {
    return userDescription;
  }

  public boolean isFavorite() {
    return isFavorite;
  }

  public void setFavorite(boolean favorite) {
    isFavorite = favorite;
  }

  public void setUserDescription(String userDescription) {
    this.userDescription = userDescription;
  }

  public enum DLC {
    BASE,
    GT4_Pack,
    Challengers_Pack,
    GT_World_Challenge_2020,
    Intercontinental_GT_Pack,
    British_GT_Pack,
    American_Track_Pack
  }
}
