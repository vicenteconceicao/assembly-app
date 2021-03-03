package com.assemblyline.service;

import com.assemblyline.domain.entities.assembly.AssemblyLine;
import com.assemblyline.domain.interfaces.IServiceAssemblyLine;
import com.assemblyline.infrastructure.data.AssemblyLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssemblyLineService implements IServiceAssemblyLine {

    @Autowired
    AssemblyLineRepository repository;

    @Override
    public void add(AssemblyLine assemblyLine) {
        repository.add(assemblyLine);
    }
}
