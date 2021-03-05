package com.assemblyline.domain.entities.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    private String description;
    private int minutes;

    public Task() {

    }

    public Task(String description, int minutes) {
        this.description = description;
        this.minutes = minutes;
    }

    public static Task parseTask(String string){
        String partner = "(\\w.*) (\\d+)min";
        Pattern pattern = Pattern.compile(partner);
        Matcher matcher = pattern.matcher(string);

        Task task = new Task();

        if(string.contains("maintenance")){
            task.setDescription(string);
            task.setMinutes(5);
        }else if(matcher.matches()){
            task.setDescription(matcher.group(1));
            task.setMinutes(Integer.parseInt(matcher.group(2)));
        }
        return  task;
    }

    @Override
    public String toString() {
        return description + " " + minutes+"min";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
