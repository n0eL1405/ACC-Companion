package de.leon.acccompanion.ui.data;

public class RaceTime {

  private int minutes;
  private int seconds;
  private int hours;

  public RaceTime() {
    this.minutes = 0;
    this.seconds = 0;
    this.hours = 0;
  }

  public RaceTime(int hours, int minutes, int seconds) throws IllegalAccessException {
    validateValues(hours, minutes, seconds);
  }

  public RaceTime(String raceTime) throws IllegalAccessException {
    fromString(raceTime);
  }

  public int getMinutes() {
    return minutes;
  }

  public void setMinutes(int minutes) throws IllegalAccessException {
    validateMinutes(minutes);
  }

  public int getSeconds() {
    return seconds;
  }

  public void setSeconds(int seconds) throws IllegalAccessException {
    validateSeconds(seconds);
  }

  public int getHours() {
    return hours;
  }

  public void setHours(int hours) throws IllegalAccessException {
    validateHours(hours);
  }

  public void fromString(String raceTime) throws IllegalAccessException {

    if (raceTime.length() != 6) {
      throw new IllegalAccessException("Race time has be 6 digits long");
    }

    try {
      int tempInt = Integer.parseInt(raceTime);
    } catch (Exception e) {
      throw new IllegalAccessException("Race time can only contain numbers");
    }

    validateHours(Integer.parseInt(raceTime.substring(0, 2)));
    validateMinutes(Integer.parseInt(raceTime.substring(2, 4)));
    validateSeconds(Integer.parseInt(raceTime.substring(4, 6)));
  }

  private void validateValues(int hours, int minutes, int seconds)
      throws IllegalAccessException {
    validateHours(hours);
    validateMinutes(minutes);
    validateSeconds(seconds);
  }

  private void validateMinutes(int minutes) throws IllegalAccessException {
    if (minutes > 60 || minutes < 0) {
      throw new IllegalAccessException("Minutes have to be between 0 and 60");
    }
    this.minutes = minutes;
  }

  private void validateSeconds(int seconds) throws IllegalAccessException {
    if (seconds > 60 || seconds < 0) {
      throw new IllegalAccessException("Seconds have to be between 0 and 60");
    }
    this.seconds = seconds;
  }

  private void validateHours(int hours) throws IllegalAccessException {
    if (hours > 60 || hours < 0) {
      throw new IllegalAccessException("Hours have to be between 0 and 60");
    }
    this.hours = hours;
  }

  @Override
  public String toString() {
    String minutesString = String.valueOf(minutes);
    if (minutesString.length() < 2) {
      minutesString = "0" + minutesString;
    }

    String secondsString = String.valueOf(seconds);
    if (secondsString.length() < 2) {
      secondsString = "0" + secondsString;
    }

    String hoursString = String.valueOf(hours);
    if (hoursString.length() < 2) {
      hoursString = "0" + hoursString;
    }

    return hoursString + ":" + minutesString + ":" + secondsString;
  }
}
