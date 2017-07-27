package org.checkers.model;


import java.util.Observable;

public class TimerModel extends Observable implements Runnable {
  protected Integer hours;
  protected Integer minutes;
  protected Integer seconds;

  protected Thread thread;

  protected boolean isRunning;

  public void initTimer() {
    hours = 0;
    minutes = 0;
    seconds = 0;
    isRunning = true;
    thread = new Thread(this);
    thread.start();
  }

  @Override
  public void run() {
    try {
      while(isRunning) {
        Thread.sleep(1000);
        incrementTime();
        updateStringTime();
      }
    } catch (RuntimeException | InterruptedException e){
      System.out.println(e.getMessage());
    }
  }

  private void incrementTime() {
    seconds++;

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

    String time = hour + ":" + minute + ":" + second;

    setChanged();
    notifyObservers(time);
  }
}
