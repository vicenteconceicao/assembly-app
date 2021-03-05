package com.assemblyline.domain.services;

import com.assemblyline.domain.entities.task.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FileReader {
    private String source;
    public FileReader(String source) {
        this.source = source;
    }

    public Queue<Task> getTasksFromFile(){
        Queue<Task> tasks = new LinkedList<>();

        try {
            File myObj = new File(source);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                tasks.add(Task.parseTask(data));
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return tasks;
    }

}
