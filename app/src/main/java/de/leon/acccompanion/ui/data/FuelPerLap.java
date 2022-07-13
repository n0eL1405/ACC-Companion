package de.leon.acccompanion.ui.data;

public class FuelPerLap {

  private int full;
  private int decimal;

  public FuelPerLap() {
    this.full = 0;
    this.decimal = 0;
  }

  public FuelPerLap(int full, int decimal) throws IllegalAccessException {
    validateValues(full, decimal);
  }

  public FuelPerLap(String fuelPerLap) throws IllegalAccessException {
    fromString(fuelPerLap);
  }

  public int getFull() {
    return full;
  }

  public void setFull(int full) {
    this.full = full;
  }

  public int getDecimal() {
    return decimal;
  }

  public void setDecimal(int decimal) {
    this.decimal = decimal;
  }

  public void fromString(String fuelPerLap) throws IllegalAccessException {

    if (fuelPerLap.length() != 3) {
      throw new IllegalAccessException("Fuel per lap has be 3 digits long");
    }

    try {
      int tempInt = Integer.parseInt(fuelPerLap);
    } catch (Exception e) {
      throw new IllegalAccessException("Fuel per lap can only contain numbers");
    }

    validateFull(Integer.parseInt(fuelPerLap.substring(0, 1)));
    validateDecimal(Integer.parseInt(fuelPerLap.substring(1, 3)));
  }

  private void validateValues(int full, int decimal)
      throws IllegalAccessException {
    validateFull(full);
    validateDecimal(decimal);
  }

  private void validateFull(int full) throws IllegalAccessException {
    if (full > 9 || full < 0) {
      throw new IllegalAccessException("Full has to be between 0 and 9");
    }
    this.full = full;
  }

  private void validateDecimal(int decimal) throws IllegalAccessException {
    if (decimal > 99 || decimal < 0) {
      throw new IllegalAccessException("Decimal has to be between 0 and 99");
    }
    this.decimal = decimal;
  }

  @Override
  public String toString() {
    String minutesString = String.valueOf(full);

    String secondsString = String.valueOf(decimal);
    if (secondsString.length() < 2) {
      secondsString = "0" + secondsString;
    }

    return minutesString + ":" + secondsString;
  }
}
