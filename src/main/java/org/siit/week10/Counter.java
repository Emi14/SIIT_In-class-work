package org.siit.week10;

import java.util.Objects;

public class Counter
{
    int count;
    int sum;
    final Object lockForSum = new Object();
    public void increment()
    {
        int i = 9;
        i++;
        i= i*2;
        syncron();
    }

    private synchronized void syncron()
    {
        count++;
    }

    private void add(int value) {
        synchronized (lockForSum)
        {
            sum += value;
        }
    }

    public int getCount() {
        return count;
    }
}
