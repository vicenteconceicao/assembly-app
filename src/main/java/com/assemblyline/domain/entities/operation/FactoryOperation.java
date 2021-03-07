package com.assemblyline.domain.entities.operation;

import com.assemblyline.domain.entities.task.FactoryTask;
import com.assemblyline.domain.entities.task.Task;
import com.assemblyline.domain.valueTypes.Time;

public class FactoryOperation {

    public static Operation getLunchOperation(){
        Time lunchStart = new Time(12, 0);
        Task lunchTask  = FactoryTask.getLunchTask();
        return new Operation(lunchTask, lunchStart);
    }
}
