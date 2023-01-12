package org.siit.week10;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter
{
    AtomicInteger count = new AtomicInteger();
    public void increment()
    {
        count.addAndGet(1);
    }



    public int getCount() {
        return count.get();
    }
}
