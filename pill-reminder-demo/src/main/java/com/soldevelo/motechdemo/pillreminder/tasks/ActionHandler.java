package com.soldevelo.motechdemo.pillreminder.tasks;

import org.motechproject.event.MotechEvent;
import org.motechproject.event.listener.annotations.MotechListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ActionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ActionHandler.class);

    @MotechListener(subjects = EventConstants.ACTION_EVENT_SUBJECT)
    public void handle(MotechEvent event) {
        LOG.info("Now executing my custom task action!");
        LOG.info("Created appointment, scheduled for " + event.getParameters().get(EventConstants.APPOINTMENT_DATE)
                + " at " + event.getParameters().get(EventConstants.APPOINTMENT_LOCATION));
    }
}
