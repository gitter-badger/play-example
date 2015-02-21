package controllers;

import models.Person;
import play.api.libs.json.Json;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import views.html.index;

import java.util.List;

import static play.libs.Json.toJson;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));

    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result addPerson2() {
        Http.RequestBody body = request().body();
        Person person = new Person(body.asJson().get("name").toString());
        person.save();
        return ok("Got json: " + body.asJson().get("name"));
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
