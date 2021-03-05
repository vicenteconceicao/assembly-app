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

        Queue<Task> tasksFirstCircle = tasks;

        while (tasksFirstCircle.size() > 0) {

            Queue<Task> tasksSecondCircle = new LinkedList<>();

            while (routine.getCurrentMinutes() < routine.getLunchMinute() && tasksFirstCircle.size() > 0) {
                item = tasksFirstCircle.remove();
                routineAdded = routine.addTask(item, routine.getCurrentMinutes(), routine.getLunchMinute());
                if (!routineAdded)
                    tasksSecondCircle.add(item);
            }

            tasksSecondCircle.addAll(tasksFirstCircle);

            tasksFirstCircle.clear();

            routine.addLunchOperation(DefaultOperations.getLunchOperation());

            while (routine.getCurrentMinutes() < routine.getMaxGymStartMinute() && tasksSecondCircle.size() > 0) {
                item = tasksSecondCircle.remove();
                routineAdded = routine.addTask(item, routine.getCurrentMinutes(), routine.getMaxGymStartMinute());
                if (!routineAdded){
                    tasksFirstCircle.add(item);
                }
            }

            tasksFirstCircle.addAll(tasksSecondCircle);

            routine.addTask(DefaultOperations.getGymnasticsTask(), routine.getCurrentMinutes(), routine.getMaxGymStartMinute());

            repository.add(routine);

            routine = new Routine();
        }
    }
}
