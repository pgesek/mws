package com.soldevelo.motechdemo.domain.service.impl;

import com.soldevelo.motechdemo.domain.logging.LoggingComponent;
import com.soldevelo.motechdemo.domain.service.VisitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service("visitService")
public class VisitServiceImpl implements VisitService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VisitServiceImpl.class);

    @Autowired
    private LoggingComponent loggingComponent;

    @PostConstruct
    public void setUpSampleVisits() {
        createVisit("123");
        createVisit("456");
    }

    @Override
    public void createVisit(String patientId) {
        LOGGER.info("Creating a visit for patient with id: {}", patientId);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("completed", true);
        parameters.put("patient_id", patientId);
        loggingComponent.sendEvent("visit_created", parameters);
    }
}
