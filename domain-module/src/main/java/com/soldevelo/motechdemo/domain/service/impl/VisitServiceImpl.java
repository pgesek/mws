package com.soldevelo.motechdemo.domain.service.impl;

import com.soldevelo.motechdemo.domain.domain.Patient;
import com.soldevelo.motechdemo.domain.domain.Visit;
import com.soldevelo.motechdemo.domain.domain.VisitStatus;
import com.soldevelo.motechdemo.domain.logging.LoggingComponent;
import com.soldevelo.motechdemo.domain.repository.PatientDataService;
import com.soldevelo.motechdemo.domain.service.VisitService;
import org.joda.time.DateTime;
import org.motechproject.mds.service.HistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("visitService")
public class VisitServiceImpl implements VisitService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VisitServiceImpl.class);

    @Autowired
    private LoggingComponent loggingComponent;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private PatientDataService patientDataService;

    @PostConstruct
    public void setUpSampleVisits() {
        createVisit("123", true);
        createVisit("456", false);

        updateVisit("456", VisitStatus.COMPLETED);
    }

    @Override
    public void createVisit(String patientId, boolean pastVisit) {
        LOGGER.info("Creating a visit for patient with id: {}", patientId);

        Patient patient = new Patient(patientId, "Town1", DateTime.now());
        patient.setVisit(new Visit(pastVisit ? VisitStatus.COMPLETED : VisitStatus.CONFIRMED, "Clinic1"));

        patientDataService.create(patient);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("completed", pastVisit);
        parameters.put("patient_id", patientId);
        loggingComponent.sendEvent("visit_created", parameters);
    }

    @Override
    public void updateVisit(String patientId, VisitStatus status) {
        Patient patient = patientDataService.getByPatientId(patientId);
        Visit visit = patient.getVisit();
        visit.setStatus(status);

        patientDataService.update(patient);
    }

    @Override
    public List getVisitAudit(String patientId) {
        Patient patient = patientDataService.getByPatientId(patientId);
        return historyService.getHistoryForInstance(patient, null);
    }

}
