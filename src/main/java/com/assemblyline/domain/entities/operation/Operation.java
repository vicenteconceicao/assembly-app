package com.assemblyline.domain.entities.operation;

import com.assemblyline.domain.entities.task.Task;
import com.assemblyline.domain.valueTypes.Time;

public class Operation {
    private Task task;
    private Time startTime;

    public Operation(Task task, int currentMinutes) {
        this.task = task;
        this.startTime = new Time(currentMinutes);
    }

    public Operation(Task task, Time startTime) {
        this.task = task;
        this.startTime = startTime;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return startTime + " " + task.toString();
    }
}
