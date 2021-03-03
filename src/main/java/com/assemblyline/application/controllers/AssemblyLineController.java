package com.assemblyline.application.controllers;

import com.assemblyline.domain.entities.assembly.AssemblyLine;
import com.assemblyline.service.AssemblyLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AssemblyLineController {

    @Autowired
    private AssemblyLineService service;

    public void addAssembly(AssemblyLine assemblyLine){
        service.add(assemblyLine);
    }
}
