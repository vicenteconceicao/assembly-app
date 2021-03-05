package com.assemblyline.service;

import com.assemblyline.domain.entities.routine.Routine;
import com.assemblyline.domain.entities.task.Task;
import com.assemblyline.domain.entities.task.TaskOperation;
import com.assemblyline.domain.interfaces.IServiceRoutine;
import com.assemblyline.domain.services.DefaultOperations;
import com.assemblyline.infrastructure.data.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@Service
public class RoutineService implements IServiceRoutine {

    @Autowired
    RoutineRepository repository;

    @Override
    public void add(Routine routine) {
        repository.add(routine);
    }

    @Override
    public ArrayList<Routine> getAll() {
        return repository.getAll();
    }

    @Override
    public void addTasks(Queue<Task> tasks) {
        Routine routine = new Routine();
        boolean routineAdded;
        Task item;
        while (tasks.size() > 0) {
            while (routine.getMorningUsedTime() < routine.getMorningMaxMinutes() && tasks.size() > 0) {
                item = tasks.remove();
                routineAdded = routine.addMorningTask(item);
                if (!routineAdded)
                    tasks.add(item);
            }

            routine.addLunchOperation(DefaultOperations.getLunchOperation());
            routine.setCurrentMinutes(780);

            Queue<Task> newTasks = new LinkedList<>();

            while (routine.getAfternoonUsedTime() < routine.getAfternoonMaxMinutes() && tasks.size() > 0) {

                item = tasks.remove();

                routineAdded = routine.addAfternoonTask(item);

                if (!routineAdded){
                    newTasks.add(item);
                }
            }
            routine.addAfternoonTask(DefaultOperations.getGymnasticsTask());
            repository.add(routine);
            routine = new Routine();
            tasks = newTasks;
        }
    }
}
