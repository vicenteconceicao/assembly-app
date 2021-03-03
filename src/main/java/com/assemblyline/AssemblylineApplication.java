package com.assemblyline;

import com.assemblyline.application.controllers.AssemblyLineController;
import com.assemblyline.domain.entities.assembly.AssemblyLine;
import com.assemblyline.service.AssemblyLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssemblylineApplication implements CommandLineRunner {

	@Autowired
	private AssemblyLineService service;

	public static void main(String[] args) {
		SpringApplication.run(AssemblylineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		AssemblyLine line = new AssemblyLine();

		service.add(line);
	}
}
