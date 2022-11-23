package com.company.ThreadTasks;


import java.util.*;

public class SortingTask extends ThreadedTask {

    public SortingTask() {
        super("CalculationTask");
    }

    @Override
    public void run() {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <9999999; i++) {
            list.add((int) Math.random()*100000 );
        }
        Collections.sort(list);

    }
}
