package com.assemblyline.domain.interfaces;

import com.assemblyline.domain.entities.routine.Routine;

import java.util.ArrayList;

public interface IRepositoryRoutine {
    public void add(Routine routine);
    public ArrayList<Routine> getAll();
}
