package com.soldevelo.motechdemo.pillreminder.controller;

import com.soldevelo.motechdemo.pillreminder.events.PillReminderComponent;
import com.soldevelo.motechdemo.pillreminder.tasks.EventConstants;
import org.motechproject.event.MotechEvent;
import org.motechproject.event.listener.EventRelay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class PillReminderDemoController {

    @Autowired
    private PillReminderComponent pillReminderComponent;

    @Autowired
    private EventRelay eventRelay;

    @RequestMapping(value = "/setUpReminder", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void setUpReminder() {
        pillReminderComponent.postReminder();
    }

    @RequestMapping(value = "/createPatient/{patientName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void createPatient(@PathVariable String patientName) {
        Map<String, Object> params = new HashMap<>();
        params.put(EventConstants.PATIENT_ID, UUID.randomUUID().toString());
        params.put(EventConstants.PATIENT_NAME, patientName);

        MotechEvent event = new MotechEvent(EventConstants.TRIGGER_EVENT_SUBJECT, params);

        eventRelay.sendEventMessage(event);
    }

}
