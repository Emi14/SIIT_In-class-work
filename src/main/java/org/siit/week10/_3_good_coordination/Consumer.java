package org.siit.week10._3_good_coordination;

public class Consumer extends Thread {

  private final IChannel channel;

  public Consumer(IChannel channel) {
    this.channel = channel;
  }

  @Override
  public void run() {
    String current = channel.take();

    while (!current.equals("DONE")) {
      System.out.println(current);
      current = channel.take();
    }
  }

}
