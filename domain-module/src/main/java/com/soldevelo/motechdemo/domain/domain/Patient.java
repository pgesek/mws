package com.soldevelo.motechdemo.domain.domain;

import org.joda.time.DateTime;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity
public class Patient {

    @Field
    private String name;

    @Field
    private DateTime birthdate;

    @Field
    private String birthplace;

    public Patient(String name, String birthplace, DateTime birthdate) {
        this.name = name;
        this.birthplace = birthplace;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public DateTime getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(DateTime birthdate) {
        this.birthdate = birthdate;
    }
}
