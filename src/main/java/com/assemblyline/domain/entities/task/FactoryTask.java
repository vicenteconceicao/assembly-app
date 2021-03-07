package com.assemblyline.domain.entities.task;

import com.assemblyline.domain.entities.task.Task;

public class FactoryTask {
    public static Task getGymnasticsTask(){
        return new Task("Ginástica laboral", 0);
    }
    public static Task getLunchTask(){ return new Task("Almoço", 60); }
}
