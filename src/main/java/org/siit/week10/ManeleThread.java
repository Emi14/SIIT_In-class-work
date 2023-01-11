package org.siit.week10;

import lombok.SneakyThrows;

public class ManeleThread extends Thread
{
    String out;

    public ManeleThread(String out)
    {
        this.out = out;
    }

    @SneakyThrows
    @Override
    public void run()
    {
        for (int i=0; i<10; i++) {
            Thread.sleep(100);
            System.out.println(this.getName() + " - " + out);
        }
    }
}
