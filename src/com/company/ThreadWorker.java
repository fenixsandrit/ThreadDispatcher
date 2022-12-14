package com.company;

import com.company.ThreadTasks.ThreadedTask;

import java.util.Objects;

public class ThreadWorker extends Thread {

    private String name;

    public ThreadWorker(String name){
        this.setDaemon(true);
        this.name = name;
    }

    @Override
    public void run() {
        ThreadedTask task = null;
        while (true) {
            synchronized (ThreadDispatcher.getSyncObject()) {
                if (ThreadDispatcher.canPeek()) {
                    task = ThreadDispatcher.getTaskWithRemoval();
                }
            }
            if(Objects.nonNull(task)) {
                task.start();
                try {
                    task.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                task = null;
            }


        }

    }
}
