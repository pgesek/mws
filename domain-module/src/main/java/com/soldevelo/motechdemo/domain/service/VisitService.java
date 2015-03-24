package com.soldevelo.motechdemo.domain.service;

import org.springframework.security.access.prepost.PreAuthorize;

public interface VisitService {

    @PreAuthorize("hasRole('visit-admin')")
    void createVisit(String patientId);
}
