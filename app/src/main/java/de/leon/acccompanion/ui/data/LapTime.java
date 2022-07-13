package de.leon.acccompanion.ui.data;

public class LapTime {

  private int minutes;
  private int seconds;
  private int milliSeconds;

  public LapTime() {
    this.minutes = 0;
    this.seconds = 0;
    this.milliSeconds = 0;
  }

  public LapTime(int minutes, int seconds, int milliSeconds) throws IllegalAccessException {
    validateValues(minutes, seconds, milliSeconds);
  }

  public LapTime(String lapTime) throws IllegalAccessException {
    fromString(lapTime);
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

  public int getMilliSeconds() {
    return milliSeconds;
  }

  public void setMilliSeconds(int milliSeconds) throws IllegalAccessException {
    validateMilliSeconds(milliSeconds);
  }

  public void fromString(String lapTime) throws IllegalAccessException {

    if (lapTime.length() != 7) {
      throw new IllegalAccessException("Lap time has be 7 digits long");
    }

    try {
      int tempInt = Integer.parseInt(lapTime);
    } catch (Exception e) {
      throw new IllegalAccessException("LapTime can only contain numbers");
    }

    validateMinutes(Integer.parseInt(lapTime.substring(0, 2)));
    validateSeconds(Integer.parseInt(lapTime.substring(2, 4)));
    validateMilliSeconds(Integer.parseInt(lapTime.substring(4, 7)));
  }

  private void validateValues(int minutes, int seconds, int milliSeconds)
      throws IllegalAccessException {
    validateMinutes(minutes);
    validateSeconds(seconds);
    validateMilliSeconds(milliSeconds);
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

  private void validateMilliSeconds(int milliSeconds) throws IllegalAccessException {
    if (milliSeconds > 999 || milliSeconds < 0) {
      throw new IllegalAccessException("Milliseconds have to be between 0 and 999");
    }
    this.milliSeconds = milliSeconds;
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

    String milliSecondsString = String.valueOf(milliSeconds);
    if (milliSecondsString.length() == 2) {
      milliSecondsString = "0" + milliSecondsString;
    } else if (milliSecondsString.length() == 1) {
      milliSecondsString = "00" + milliSecondsString;
    }

    return minutesString + ":" + secondsString + "." + milliSecondsString;
  }
}
