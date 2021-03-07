package com.assemblyline.domain.entities.routine;

import com.assemblyline.domain.entities.task.Task;
import com.assemblyline.domain.entities.operation.Operation;
import com.assemblyline.domain.valueTypes.Options;

import java.util.ArrayList;

public class Routine {
    private ArrayList<Operation> operations;

    private int currentMinutes;

    public Routine() {
        this.operations = new ArrayList<>();
        this.currentMinutes = 540;
    }

    public boolean addTask(Task task, int usedTime, int maxMinutes){
        if(task.getMinutes() + usedTime <= maxMinutes){
            addOperation(task);
            return true;
        }
        return false;
    }

    private void addOperation(Task task) {
        operations.add(new Operation(task, currentMinutes));
        currentMinutes += task.getMinutes();
    }

    public void addLunchOperation(Operation lunchOperation) {
        operations.add(lunchOperation);
        currentMinutes = Options.MINUTE_LUNCH_START + lunchOperation.getTask().getMinutes();
    }

    public ArrayList<Operation> getOperations() {
        return operations;
    }

    public int getCurrentMinutes() {
        return currentMinutes;
    }

    public void printOperations(){
        for (int i = 0; i < operations.size(); i++) {
            System.out.println(operations.get(i));
        }
    }

    public void setCurrentMinutes(int currentMinutes) {
        this.currentMinutes = currentMinutes;
    }
}
