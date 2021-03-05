package com.assemblyline.application.controllers;

import com.assemblyline.domain.entities.routine.Routine;
import com.assemblyline.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AssemblyLineController {

    @Autowired
    private RoutineService service;

    public void addAssembly(Routine routine){
        service.add(routine);
    }
}
