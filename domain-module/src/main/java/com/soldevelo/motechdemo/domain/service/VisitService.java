package com.soldevelo.motechdemo.domain.service;

import com.soldevelo.motechdemo.domain.domain.Visit;
import com.soldevelo.motechdemo.domain.domain.VisitStatus;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface VisitService {

    @PreAuthorize("hasRole('visit-admin')")
    void createVisit(String patientId, boolean pastVisit);

    List<Visit> getVisitAudit(String patientId);

    void updateVisit(String patientId, VisitStatus status);
}
