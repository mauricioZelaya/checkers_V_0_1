package org.checkers.model;


public class TimerModel implements Runnable {
  protected Integer hours;
  protected Integer minutes;
  protected Integer seconds;
  protected Integer miliseconds;

  protected String time;

  protected boolean isRunning;

  public TimerModel() {
    initTimer();
  }

  public void initTimer() {
    hours = 0;
    minutes = 0;
    seconds = 0;
    miliseconds = 0;
    isRunning = true;
    time = "";
  }

  @Override
  public void run() {
    try {
      while(isRunning) {
        Thread.sleep(4);
        incrementTime();
        updateStringTime();
      }
    } catch (RuntimeException | InterruptedException e){
      System.out.println(e.getMessage());
    }
  }

  private void incrementTime() {
    miliseconds += 4;

    if (miliseconds == 1000) {
      miliseconds = 0;
      seconds++;
    }

    if (seconds == 60) {
      seconds = 0;
      minutes++;
    }

    if (minutes == 60) {
      minutes = 0;
      hours++;
    }
  }

  private void updateStringTime(){
    String hour = hours < 10 ? "0" + hours : String.valueOf(hours);
    String minute = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
    String second = seconds < 10 ? "0" + seconds : String.valueOf(seconds);

    time = hour + ":" + minute + ":" + second;
  }

}
