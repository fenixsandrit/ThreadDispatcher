package com.company.ThreadTasks;


import java.util.*;

public class SortingTask extends ThreadedTask {

    public SortingTask()
    {
        super("CalculationTask");
    }

    @Override
    public void run()
    {
        List<Integer> listToSort = new ArrayList<>();

        for (int i = 0; i < 9999999; i++)
        {
            listToSort.add((int) (Math.random() * 100000));
        }

        Collections.sort(listToSort);
    }
}
