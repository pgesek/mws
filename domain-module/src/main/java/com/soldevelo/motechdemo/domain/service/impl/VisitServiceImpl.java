package com.soldevelo.motechdemo.domain.service.impl;

import com.soldevelo.motechdemo.domain.service.VisitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("visitService")
public class VisitServiceImpl implements VisitService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VisitServiceImpl.class);

    @Override
    public void createVisit(String patientId) {
        LOGGER.info("Creating a visit for patient with id: {}", patientId);
    }
}
