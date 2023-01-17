package com.company.ThreadTasks;

abstract public class ThreadedTask extends Thread {
    protected String name;
    protected static int count = 1;
    public ThreadedTask(String name)
    {
        super();
        this.name = name + "-" + (count++);
    }

    public ThreadedTask()
    {

    }

    public String toString()
    {
        return name;
    }
}
