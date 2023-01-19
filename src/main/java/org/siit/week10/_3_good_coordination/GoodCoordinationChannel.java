package org.siit.week10._3_good_coordination;

public class GoodCoordinationChannel implements IChannel {
  private String message;
  private boolean isChannelEmpty = true;

  public synchronized String take() {
    if (isChannelEmpty) {
      callWaitMethod();
    }
    String temp = message;
    isChannelEmpty = true;
    notifyAll();
    return temp;
  }


  public synchronized void put(String message) {
    if (!isChannelEmpty) {
      callWaitMethod();
    }
    this.message = message;
    isChannelEmpty = false;
    notifyAll();
  }

  private void callWaitMethod() {
    try
    {
      this.wait();
    } catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}