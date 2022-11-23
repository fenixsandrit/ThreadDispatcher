package com.company;

import com.company.ThreadTasks.SortingTask;
import com.company.ThreadTasks.SleepTask;
import com.company.gui.SimpleGUI;


public class Main {

    public static void main(String[] args)  {
        SimpleGUI gui = new SimpleGUI();

        ThreadDispatcher threadDispatcher = ThreadDispatcher.getInstance();

        for (int i = 0; i < 10; i++) {
            threadDispatcher.addInQueue(new SortingTask());
            threadDispatcher.addInQueue(new SleepTask());
        }
        new ThreadWorker("1").start();
        new ThreadWorker("2").start();
        new ThreadWorker("3").start();


    }
}

