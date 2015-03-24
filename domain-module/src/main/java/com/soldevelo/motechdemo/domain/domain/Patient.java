package com.soldevelo.motechdemo.domain.domain;

import org.joda.time.DateTime;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(recordHistory = true)
public class Patient {

    @Field
    private String patientId;

    @Field
    private DateTime birthdate;

    @Field
    private String birthplace;

    @Field
    private Visit visit;

    public Patient(String patientId, String birthplace, DateTime birthdate) {
        this.patientId = patientId;
        this.birthplace = birthplace;
        this.birthdate = birthdate;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
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

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }
}
