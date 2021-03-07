package com.assemblyline.service;

import com.assemblyline.domain.entities.operation.Operation;
import com.assemblyline.domain.entities.routine.Routine;
import com.assemblyline.domain.entities.task.Task;
import com.assemblyline.domain.interfaces.IRepositoryRoutine;
import com.assemblyline.domain.interfaces.IServiceRoutine;
import com.assemblyline.domain.entities.operation.FactoryOperation;
import com.assemblyline.domain.entities.task.FactoryTask;
import com.assemblyline.domain.valueTypes.Options;
import com.assemblyline.infrastructure.data.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@Service
public class RoutineService implements IServiceRoutine {

    @Autowired
    IRepositoryRoutine routineRepository;

    @Override
    public void add(Routine routine) {
        routineRepository.add(routine);
    }

    @Override
    public ArrayList<Routine> getAll() {
        return routineRepository.getAll();
    }

    @Override
    public void addTasks(Queue<Task> tasks) {
        Routine routine = new Routine();

        boolean routineAdded;

        Task item;

        Queue<Task> morningCircleTasks = tasks;
        Queue<Task> afternoonCircleTasks = new LinkedList<>();
        Task standardTask;

        while (morningCircleTasks.size() > 0) {

            afternoonCircleTasks.clear();

            /***
             * Algorithm to insert tasks in the morning (before lunch)..
             * The code inserts tasks as long as the total amount of time does not reach the start of lunch
             * or until tasks on the list run out.
             */
            while (routine.getCurrentMinutes() < Options.MINUTE_LUNCH_TART && morningCircleTasks.size() > 0) {
                item = morningCircleTasks.remove();
                routineAdded = routine.addTask(item, routine.getCurrentMinutes(), Options.MINUTE_LUNCH_TART);
                if (!routineAdded)
                    afternoonCircleTasks.add(item);
            }

            afternoonCircleTasks.addAll(morningCircleTasks);

            morningCircleTasks.clear();

            if(routine.getCurrentMinutes() < Options.MINUTE_LUNCH_TART) {
                routine.setCurrentMinutes(Options.MINUTE_LUNCH_TART);
            }

            standardTask = FactoryTask.getLunchTask();
            routine.addTask(standardTask, routine.getCurrentMinutes(), Options.MINUTE_LUNCH_TART + standardTask.getMinutes());

            /***
             * Algorithm to insert tasks in the afternoon (after lunch).
             * The code inserts tasks as long as the total amount of time does not reach the beginning of the gym
             * or until tasks on the list run out.
             */
            while (routine.getCurrentMinutes() < Options.MAX_MINUTE_GYMS_TART && afternoonCircleTasks.size() > 0) {
                item = afternoonCircleTasks.remove();
                routineAdded = routine.addTask(item, routine.getCurrentMinutes(), Options.MAX_MINUTE_GYMS_TART);
                if (!routineAdded){
                    morningCircleTasks.add(item);
                }
            }

            morningCircleTasks.addAll(afternoonCircleTasks);

            if(routine.getCurrentMinutes() < Options.MINUTE_GYMS_START) {
                routine.setCurrentMinutes(Options.MINUTE_GYMS_START);
            }

            standardTask = FactoryTask.getGymnasticsTask();
            routine.addTask(standardTask, routine.getCurrentMinutes(), Options.MAX_MINUTE_GYMS_TART);

            routineRepository.add(routine);

            routine = new Routine();
        }
    }

    @Override
    public void print() {
        ArrayList<Routine> routs = routineRepository.getAll();
        for (int i = 0; i < routs.size(); i++) {
            System.out.println("Linha de montagem "+(i+1)+":");
            routs.get(i).printOperations();
            System.out.println("");
        }
    }
}
