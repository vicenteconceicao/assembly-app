package com.assemblyline.infrastructure.data;

import com.assemblyline.domain.entities.routine.Routine;
import com.assemblyline.domain.interfaces.IRepositoryRoutine;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class RoutineRepository implements IRepositoryRoutine {
    private ArrayList<Routine> context = new ArrayList<>();

    @Override
    public void add(Routine routine) {
        context.add(routine);
    }

    @Override
    public ArrayList<Routine> getAll() {
        return context;
    }
}
