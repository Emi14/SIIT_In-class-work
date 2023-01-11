package org.siit.week10;

public class CountingThread implements Runnable
{
    int step;

    public CountingThread(int step)
    {
        this.step = step;
    }

    @Override
    public void run()
    {
        for (int i=0; i<100; i+=step) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }
}
