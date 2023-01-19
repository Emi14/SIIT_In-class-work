package org.siit.week10._3_good_coordination;

public interface IChannel {

  String take();

  void put(String message);
}
