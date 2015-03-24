package com.soldevelo.motechdemo.domain.logging;

import org.motechproject.admin.domain.NotificationRule;
import org.motechproject.admin.events.EventKeys;
import org.motechproject.admin.events.EventSubjects;
import org.motechproject.admin.messages.ActionType;
import org.motechproject.admin.messages.Level;
import org.motechproject.admin.service.StatusMessageService;
import org.motechproject.event.MotechEvent;
import org.motechproject.event.listener.EventRelay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class AdminNotifierComponent {

    @Autowired
    private StatusMessageService statusMessageService;

    @Autowired
    private EventRelay eventRelay;

    @PostConstruct
    public void setUpNotificationRules() {
        NotificationRule adminNotification = new NotificationRule("admin@domain.com", ActionType.EMAIL, Level.WARN, "com.soldevelo.motechdemo");
        statusMessageService.saveRule(adminNotification);
    }

    public void sendFailureMessage() {
        statusMessageService.warn("OH NOES I FAILED!", "com.soldevelo.motechdemo");
    }

    public void sendFailureEvent() {
        Map<String, Object> eventParams = new HashMap<>();
        eventParams.put(EventKeys.MODULE_NAME, "com.soldevelo.motechdemo");
        eventParams.put(EventKeys.LEVEL, Level.WARN);
        eventParams.put(EventKeys.MESSAGE, "OH NOES I FAILED AND SENT AN EVENT");

        eventRelay.sendEventMessage(new MotechEvent(EventSubjects.MESSAGE_SUBJECT, eventParams));
    }
}
