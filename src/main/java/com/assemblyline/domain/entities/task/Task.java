package com.assemblyline.domain.entities.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    private String description;
    private int minutes;
    private boolean standard;

    public Task() {

    }

    public Task(String description, int minutes, boolean standard) {
        this.description = description;
        this.minutes = minutes;
        this.standard = standard;
    }

    public static Task parseTask(String string){
        String partner = "(\\w.*) (\\d+)min";
        Pattern pattern = Pattern.compile(partner);
        Matcher matcher = pattern.matcher(string);

        Task task = new Task();

        if(string.contains("maintenance")){
            task.setDescription(string);
            task.setMinutes(5);
            task.setStandard(true);
        }else if(matcher.matches()){
            task.setDescription(matcher.group(1));
            task.setMinutes(Integer.parseInt(matcher.group(2)));
            task.setStandard(false);
        }
        return  task;
    }

    @Override
    public String toString() {
        String string = "";
        string += description;
        if(!this.standard){
            string += " " + minutes+"min";
        }
        return string;
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

    public boolean isStandard() {
        return standard;
    }

    public void setStandard(boolean standard) {
        this.standard = standard;
    }
}
