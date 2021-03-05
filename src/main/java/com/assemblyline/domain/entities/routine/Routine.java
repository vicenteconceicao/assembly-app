package com.assemblyline.domain.entities.routine;

import com.assemblyline.domain.entities.time.Time;
import com.assemblyline.domain.entities.task.Task;
import com.assemblyline.domain.entities.task.TaskOperation;

import java.util.ArrayList;

public class Routine {
    private ArrayList<TaskOperation> morningOperations;
    private TaskOperation lunchOperation;
    private ArrayList<TaskOperation> afternoonOperations;

    private int morningUsedTime;
    private int afternoonUsedTime;
    private int currentMinutes;

    private int morningMaxMinutes;
    private int afternoonMaxMinutes;

    public Routine() {
        this.morningOperations = new ArrayList<>();
        this.afternoonOperations = new ArrayList<>();

        this.currentMinutes = 540;
        this.morningUsedTime = 0;
        this.afternoonUsedTime = 0;

        this.morningMaxMinutes = 180;
        this.afternoonMaxMinutes = 240;
    }

    public boolean addMorningTask(Task task){
        if(task.getMinutes() + morningUsedTime <= morningMaxMinutes){
            morningOperations.add(new TaskOperation(task, currentMinutes));
            currentMinutes += task.getMinutes();
            morningUsedTime += task.getMinutes();
            return true;
        }
        return false;
    }

    public boolean addAfternoonTask(Task task){
        if(task.getMinutes() + afternoonUsedTime <= afternoonMaxMinutes){
            afternoonOperations.add(new TaskOperation(task, currentMinutes));
            currentMinutes += task.getMinutes();
            afternoonUsedTime += task.getMinutes();
            return true;
        }
        return false;
    }

    private Task getGymnasticsTask(){
        return new Task("Ginástica laboral", 0);
    }

    private TaskOperation calcLunchOperation(){
        Time lunchStart = new Time(12, 0);
        Task lunchTask  = new Task("Almoço", 60);
        return new TaskOperation(lunchTask, lunchStart);
    }

    public int getMorningUsedTime() {
        return morningUsedTime;
    }

    public void setMorningUsedTime(int morningUsedTime) {
        this.morningUsedTime = morningUsedTime;
    }

    public int getAfternoonUsedTime() {
        return afternoonUsedTime;
    }

    public void setAfternoonUsedTime(int afternoonUsedTime) {
        this.afternoonUsedTime = afternoonUsedTime;
    }

    public int getCurrentMinutes() {
        return currentMinutes;
    }

    public void setCurrentMinutes(int currentMinutes) {
        this.currentMinutes = currentMinutes;
    }

    public TaskOperation getLunchOperation() {
        return lunchOperation;
    }

    public void setLunchOperation(TaskOperation lunchOperation) {
        this.lunchOperation = lunchOperation;
    }

    public ArrayList<TaskOperation> getMorningOperations() {
        return morningOperations;
    }

    public ArrayList<TaskOperation> getAfternoonOperations() {
        return afternoonOperations;
    }
}
