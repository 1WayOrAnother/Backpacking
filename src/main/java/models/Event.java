package models;

import java.util.ArrayList;

/**
 * Created by Guest on 1/10/18.
 */
public class Event {
    private String name;
    private String type;
    private String date;
    private String time;
    private String details;
    private int price;
    private int id;
//    private int fullPrice;
    private static ArrayList<Event> instances = new ArrayList<Event>();
    public Event(String name, String type, String date, String time, String details, int price) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.time = time;
        this.details = details;
        this.price = price;
//        this.fullPrice = 0;
        instances.add(this);
        this.id = instances.size();
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getDate() {
        return this.date;
    }

    public String getTime() {
        return this.time;
    }

    public String getDetails() {
        return this.details;
    }

    public static ArrayList getAll() {
        return instances;
    }

    public int getPrice() {
        return this.price;
    }

//    public int getFullPrice() {
//        return this.fullPrice;
//    }

    public int getId() {
        return this.id;
    }

    public static void clearAll() {
        instances.clear();
    }

    public static Event findById(int id) {
        return instances.get(id-1);
    }

    public void deleteEvent(){
        instances.remove(id-1);
    }

    public void update(String name, String type, String date, String time, String details, int price){
        this.name = name;
        this.type = type;
        this.date = date;
        this.time = time;
        this.details = details;
        this.price = price;
    }

//    public static void calculateFullPrice() {
//        for(instance : instances) {
//            Event.instance.getFullPrice();
//            fullPrice += instance.getPrice();
//        }
//    }
}