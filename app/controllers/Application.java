package controllers;

import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import models.Person;
import play.data.Form;


import play.*;

import java.util.List;

import static play.libs.Json.toJson;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));


    }

    public static Result addPerson(){
        Person person = Form.form(Person.class).bindFromRequest().get();
        person.save();
        return redirect(routes.Application.index());
    }

    public static Result getPersons(){
        List<Person> persons = new Model.Finder(String.class, Person.class).all();
        return ok(toJson(persons));

    }

}
