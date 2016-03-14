package com.softdesign.school_softdesign.data.storage.models;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "Users")
public class OrmUser extends SchoolModel {

    @Column(name="firstName")
    public String firstName;

    @Column(name="lastName")
    public String lastName;

    @Column(name = "team")
    public OrmTeam team;

    public static List<OrmUser> getAll() {
        return new Select().from(OrmUser.class).execute();
    }

    public static void add(String firstName, String lastName, OrmTeam team){
        OrmUser model = new OrmUser();
        model.firstName = firstName;
        model.lastName = lastName;
        model.team = team;
        model.save();
    }

}
