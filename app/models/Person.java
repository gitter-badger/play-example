package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Created by philippenaegeli on 20.02.15.
 */
@Entity
public class Person extends Model {

    @Id
    public String Id;
    public String name;
}
