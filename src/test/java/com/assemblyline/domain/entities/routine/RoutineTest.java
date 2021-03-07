package com.assemblyline.domain.entities.routine;

import com.assemblyline.domain.entities.task.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoutineTest {
    private Routine routine;

    @BeforeEach
    public void setUp() throws Exception{
        routine = new Routine();
    }

    @Test
    @DisplayName("Simple test to check if the task will be added before the lunch period")
    void addTask() {
        Task task = new Task("Tarefa 1", 15, false);
        int usedTime = 540; // Tempo de início das tarefas.
        int maxMinutes = 720; // Tempo do almoço.

        assertEquals(true,  routine.addTask(task, usedTime, maxMinutes), "Task must be added because it is within the time limit");

    }

    @Test
    @DisplayName("Simple test to verify that the task will not be added when the timeout is reached")
    void addTaskAfterMaxTime() {
        Task task = new Task("Tarefa 1", 30, false);
        int usedTime = 720; // Tempo consumido pelas tarefas.
        int maxMinutes = 720; // Tempo do almoço.

        assertEquals(false,  routine.addTask(task, usedTime, maxMinutes), "Task should not be added as it is over time");
    }

}