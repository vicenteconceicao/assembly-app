package com.assemblyline.infrastructure.data;

import com.assemblyline.domain.entities.assembly.AssemblyLine;
import com.assemblyline.domain.interfaces.IRepositoryAssemblyLine;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class AssemblyLineRepository implements IRepositoryAssemblyLine {
    private ArrayList<AssemblyLine> context = new ArrayList<>();

    @Override
    public void add(AssemblyLine assemblyLine) {
        context.add(assemblyLine);
    }
}
