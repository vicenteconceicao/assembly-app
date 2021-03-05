package com.assemblyline;

import com.assemblyline.domain.entities.time.Time;
import com.assemblyline.domain.entities.routine.Routine;
import com.assemblyline.domain.entities.task.Task;
import com.assemblyline.domain.entities.task.TaskOperation;
import com.assemblyline.domain.services.FileReader;
import com.assemblyline.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {

	@Autowired
	protected RoutineService routineService;


	public static void main(String[] args) {
		SpringApplication.run(ConsoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		FileReader file = new FileReader("resources/input.txt");

		Queue<Task> tasks = file.getTasksFromFile();

		routineService.addTasks(tasks);

		ArrayList<Routine> routs = routineService.getAll();

		for (int i = 0; i < routs.size(); i++) {
			System.out.println("Linha de montagem "+(i+1)+":");
			System.out.println(routs.get(i).getTaskOperations());
			System.out.println("");
		}
	}
}
