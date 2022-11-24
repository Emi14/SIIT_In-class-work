package org.siit.week6.generics;

public class Box<T> {

    private T anInstance;

    public Box(T anInstance) {
        this.anInstance = anInstance;
    }

    public T getAnInstance() {
        return anInstance;
    }

    public void setAnInstance(T anInstance) {
        this.anInstance = anInstance;
    }
}
