package org.siit.week10;

public class Randomizer implements Runnable
{
    Counter counter;
    private AtomicCounter atomicCounter;

    public Randomizer(Counter counter, AtomicCounter atomicCounter)
    {
        this.counter = counter;
        this.atomicCounter = atomicCounter;
    }

    @Override
    public void run()
    {
       counter.increment();
       atomicCounter.increment();
    }
}
