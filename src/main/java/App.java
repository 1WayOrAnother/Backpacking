
import java.util.ArrayList;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import models.*;

import static spark.Spark.*;

import java.util.Map;

/**
 * Created by Guest on 1/10/18.
 */
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList allEvents = Event.getAll();
            model.put("allEvents", allEvents);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String type = request.queryParams("type");
            String date = request.queryParams("date");
            String time = request.queryParams("time");
            String details = request.queryParams("details");
            int price = Integer.parseInt(request.queryParams("price"));
            Event newEvent = new Event(name, type, date, time, details, price);
            ArrayList allEvents = Event.getAll();
            model.put("allEvents", allEvents);
            return new ModelAndView(model, "display.hbs");
        }, new HandlebarsTemplateEngine());

        get("/display", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList allEvents = Event.getAll();
            model.put("allEvents", allEvents);
            return new ModelAndView(model, "display.hbs");
        }, new HandlebarsTemplateEngine());

        get("/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfEventToFind = Integer.parseInt(request.params("id"));
            Event foundEvent = Event.findById(idOfEventToFind);
            model.put("event", foundEvent);
            return new ModelAndView(model, "details.hbs");
        }, new HandlebarsTemplateEngine());

        post("events/:id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfEventToDelete = Integer.parseInt(request.params("id"));
            Event deleteEvent = Event.findById(idOfEventToDelete);
            deleteEvent.deleteEvent();
            ArrayList allEvents = Event.getAll();
            model.put("allEvents", allEvents);
//            ArrayList allJobs = Job.getAll();
//            model.put("allJobs", allJobs);
            return new ModelAndView(model, "display.hbs");
        }, new HandlebarsTemplateEngine());

        get("events/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfEventToChange = Integer.parseInt(request.params("id"));
            Event changeEvent = Event.findById(idOfEventToChange);
            String name = request.queryParams("name");
            String type = request.queryParams("type");
            String date = request.queryParams("date");
            String time = request.queryParams("time");
            String details = request.queryParams("details");
            int price = Integer.parseInt(request.queryParams("price"));
            changeEvent.update(name, type, date, time, details, price);
//            model.put("changeEvent", changeEvent);
            ArrayList allEvents = Event.getAll();
            model.put("allEvents", allEvents);
            return new ModelAndView(model, "display.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
