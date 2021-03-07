package com.assemblyline.domain.services;

import com.assemblyline.domain.entities.task.Task;

import java.io.*;
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
            // Foi necessário getResourceAsStream para encontrar o arquivo quando a aplicação é gerada.
            InputStream inputStream = getClass().getResourceAsStream(source);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                if(!line.isEmpty()){
                    tasks.add(Task.parseTask(line));
                }
            }
            reader.close();
            inputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }

}
