package com.softdesign.school_softdesign.data.storage.models;


import com.activeandroid.Model;
import com.activeandroid.query.Select;

public class SchoolModel extends Model {

    public static <T extends Model> T findByAttribute(String attribute, String value){
        return new Select().from(OrmTeam.class).where(attribute+" = ?", value).executeSingle();
    }

}
