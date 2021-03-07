package com.assemblyline.application.controllers;

import com.assemblyline.domain.entities.routine.Routine;
import com.assemblyline.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssemblyLineController {

    @Autowired
    private RoutineService service;

    @GetMapping("/routines")
    public List<Routine> getAll(){
        return service.getAll();
    }
}
