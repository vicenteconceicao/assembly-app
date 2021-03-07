package com.assemblyline.domain.valueTypes;

public class Time {
    private int hours;
    private int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    /***
     * Tive que criar esse construtor para facilitar na definição do horário com base nos minutos das atividades.
     * @param minutes
     */
    public Time(int minutes) {
        this.hours = minutes / 60;
        this.minutes = minutes - (this.hours * 60);
    }

    @Override
    public String toString() {
        return String.format("%02d",this.hours) + ":" + String.format("%02d",this.minutes);
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
