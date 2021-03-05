package com.assemblyline.domain.entities.routine;

import com.assemblyline.domain.entities.time.Time;
import com.assemblyline.domain.entities.task.Task;
import com.assemblyline.domain.entities.task.TaskOperation;

import java.util.ArrayList;

public class Routine {
    private ArrayList<TaskOperation> taskOperations;

    private int currentMinutes;
    private int maxGymStartMinute;

    private int lunchMinute;

    public Routine() {
        this.taskOperations = new ArrayList<>();
        this.currentMinutes = 540;
        this.lunchMinute = 720;
        this.maxGymStartMinute = 1020;
    }

    public boolean addTask(Task task, int usedTime, int maxMinutes){
        if(task.getMinutes() + usedTime <= maxMinutes){
            addOperation(task);
            return true;
        }
        return false;
    }

    private void addOperation(Task task) {
        taskOperations.add(new TaskOperation(task, currentMinutes));
        currentMinutes += task.getMinutes();
    }

    public void addLunchOperation(TaskOperation lunchOperation) {
        taskOperations.add(lunchOperation);
        currentMinutes = this.lunchMinute + lunchOperation.getTask().getMinutes();
    }

    public ArrayList<TaskOperation> getTaskOperations() {
        return taskOperations;
    }

    public int getLunchMinute() {
        return lunchMinute;
    }

    public int getCurrentMinutes() {
        return currentMinutes;
    }

    public int getMaxGymStartMinute() {
        return maxGymStartMinute;
    }
}
