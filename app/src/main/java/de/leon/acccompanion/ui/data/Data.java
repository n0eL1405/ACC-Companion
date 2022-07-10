package de.leon.acccompanion.ui.data;

import lombok.NonNull;

public class Data {

  private int id;
  private final String name;
  private final String description;
  private final DLC dlc;
  private final int dataVersion;

  public Data(@NonNull int id, @NonNull String name, @NonNull String description, @NonNull DLC dlc,
      @NonNull int dataVersion) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.dlc = dlc;
    this.dataVersion = dataVersion;
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
