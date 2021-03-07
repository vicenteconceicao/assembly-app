package com.assemblyline;

import com.assemblyline.domain.entities.routine.Routine;
import com.assemblyline.domain.entities.task.Task;
import com.assemblyline.domain.interfaces.IServiceRoutine;
import com.assemblyline.domain.services.FileReader;
import com.assemblyline.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {

	@Autowired
	protected IServiceRoutine routineService;


	public static void main(String[] args) {
		SpringApplication.run(ConsoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		FileReader file = new FileReader("/input.txt");
		Queue<Task> tasks = file.getTasksFromFile();
		routineService.addTasks(tasks);
		routineService.print();
	}
}
