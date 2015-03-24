package com.soldevelo.motechdemo.domain.domain;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(recordHistory = true)
public class Visit {

    @Field
    private String location;

    @Field
    private VisitStatus status;

    public Visit(VisitStatus status, String location) {
        this.status = status;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public VisitStatus getStatus() {
        return status;
    }

    public void setStatus(VisitStatus status) {
        this.status = status;
    }
}
