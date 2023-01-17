package com.company.ThreadTasks;

public class SleepTask extends ThreadedTask
{
    public SleepTask()
    {
        super("SleepTask");
    }
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(3000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
