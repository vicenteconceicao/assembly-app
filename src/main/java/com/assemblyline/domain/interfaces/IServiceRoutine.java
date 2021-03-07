package com.assemblyline.domain.interfaces;

import com.assemblyline.domain.entities.routine.Routine;
import com.assemblyline.domain.entities.task.Task;

import java.util.ArrayList;
import java.util.Queue;

public interface IServiceRoutine {
    public void add(Routine routine);

    public ArrayList<Routine> getAll();

    public void addTasks(Queue<Task> tasks);

    public void print();
}
