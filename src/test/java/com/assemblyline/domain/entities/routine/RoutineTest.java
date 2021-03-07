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
    @DisplayName("Teste simples para verificar se a tarefa será adicionada antes do período de almoço")
    void addTask() {
        Task task = new Task("Tarefa 1", 15);
        int usedTime = 540; // Tempo de início das tarefas.
        int maxMinutes = 720; // Tempo do almoço.

        assertEquals(true,  routine.addTask(task, usedTime, maxMinutes), "Tarefa deve ser adicionada por estar dentro do tempo limite");

    }

    @Test
    @DisplayName("Teste simples para verificar se a tarefa naõ será adicionada quando atingido o tempo limite")
    void addTaskAfterMaxTime() {
        Task task = new Task("Tarefa 1", 30);
        int usedTime = 720; // Tempo consumido pelas tarefas.
        int maxMinutes = 720; // Tempo do almoço.

        assertEquals(false,  routine.addTask(task, usedTime, maxMinutes), "Tarefa não deve ser adicionada por estar além do tempo limite");
    }

}