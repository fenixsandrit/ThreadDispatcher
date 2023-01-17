package com.company.ThreadTasks;

import com.company.ThreadDispatcher;
import com.company.ThreadTasks.ThreadedTask;


public class ProxyThreadedTask extends ThreadedTask
{
    private ThreadedTask threadedTask;

    public ProxyThreadedTask(ThreadedTask threadedTask)
    {
        this.threadedTask = threadedTask;
        name = threadedTask.name;
    }


    @Override
    public void run()
    {
        ThreadDispatcher.threadWasStarted(this);
        threadedTask.start();

        try
        {
            threadedTask.join();
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        ThreadDispatcher.threadWasDone(this);
    }
}
