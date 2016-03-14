package com.softdesign.school_softdesign.data.storage.models;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

@Table(name = "Teams")
public class OrmTeam extends SchoolModel {

    @Column(name = "title")
    public String title;

    public List<OrmUser> items() {
        return getMany(OrmUser.class, "team");
    }

    public void setTitle(String title){
        this.title = title;
    }

    public static List<OrmTeam> getAll() {
        return new Select().from(OrmTeam.class).execute();
    }

    /* Получаем список имен */
    public static List<String> getAllNames() {
        List<OrmTeam> teams = getAll();
        List<String> names = new ArrayList<String>(teams.size());
        for (OrmTeam t : teams) {
            names.add(t.title);
        }
        return names;
    }

    public static void add(String title){
        OrmTeam model = new OrmTeam();
        model.title = title;
        model.save();
    }

}
