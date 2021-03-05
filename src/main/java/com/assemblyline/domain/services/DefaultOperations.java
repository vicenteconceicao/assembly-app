package com.assemblyline.domain.services;

import com.assemblyline.domain.entities.task.Task;
import com.assemblyline.domain.entities.task.TaskOperation;
import com.assemblyline.domain.entities.time.Time;

public class DefaultOperations {

    public static TaskOperation getLunchOperation(){
        Time lunchStart = new Time(12, 0);
        Task lunchTask  = new Task("Almoço", 60);
        return new TaskOperation(lunchTask, lunchStart);
    }

    public static Task getGymnasticsTask(){
        return new Task("Ginástica laboral", 0);
    }

}
