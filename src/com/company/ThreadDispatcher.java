package com.company;

import com.company.ThreadTasks.ProxyThreadedTask;
import com.company.ThreadTasks.ThreadMonitor;
import com.company.ThreadTasks.ThreadedTask;

import java.util.*;

public class ThreadDispatcher {

    private static volatile Queue<ThreadedTask> globalQueue;
    private static volatile ThreadDispatcher instance;

    private static volatile ThreadMonitor threadMonitor;
    private static final Object syncObject = new Object();
    private static int poolSize;

    private ThreadDispatcher(){
        poolSize = 3;
        globalQueue = new LinkedList<>();
        threadMonitor = new ThreadMonitor();
        threadMonitor.start();
    }

    public static ThreadDispatcher getInstance(){
        return instance == null ? new ThreadDispatcher() : instance;
    }

    public static Object getSyncObject(){
        return syncObject;
    }


    public static boolean canPeek(){
        return !globalQueue.isEmpty();
    }

    public void add(ThreadedTask task){
        (new ProxyThreadedTask(task)).start();
    }

    public void addInQueue(ThreadedTask task){
        ProxyThreadedTask proxyThreadedTask = new ProxyThreadedTask(task);
        threadMonitor.addInNewThread(proxyThreadedTask);
        synchronized (syncObject){
            globalQueue.add(proxyThreadedTask);
        }
    }

    public static void threadWasDone(ThreadedTask task) {
        threadMonitor.removeThread(task);
    }

    public static int getPoolSize() {
        return poolSize;
    }

    void setPoolSize(int size){
        poolSize = size;
    }

    public static ThreadedTask getTaskWithRemoval(){
        var task = globalQueue.poll();
        return task;
    }

    public static void threadWasStarted(ThreadedTask task) {
        threadMonitor.addInRunnableThread(task);
    }

}
