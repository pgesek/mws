package com.soldevelo.motechdemo.domain.logging;

import org.motechproject.event.MotechEvent;
import org.motechproject.event.listener.EventRelay;
import org.motechproject.eventlogging.converter.impl.DefaultFileToLogConverter;
import org.motechproject.eventlogging.loggers.impl.FileEventLogger;
import org.motechproject.eventlogging.matchers.EventFlag;
import org.motechproject.eventlogging.matchers.LoggableEvent;
import org.motechproject.eventlogging.service.EventLoggingService;
import org.motechproject.eventlogging.service.EventLoggingServiceManager;
import org.motechproject.eventlogging.service.EventQueryService;
import org.motechproject.eventlogging.service.impl.FileEventLoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.Arrays;
import java.util.Map;

@Component
public class LoggingComponent {

    @Autowired
    private EventLoggingServiceManager loggingServiceManager;

    @Autowired
    private EventQueryService eventQueryService;

    @Autowired
    private EventRelay eventRelay;

    @PostConstruct
    public void prepareLogger() {
        EventLoggingService fileLoggingService = new FileEventLoggingService(
                Arrays.asList(new FileEventLogger(
                        Arrays.asList(new LoggableEvent(
                                Arrays.asList("*"),
                                Arrays.asList(new VisitCompletedKeyFlag()))),
                        Arrays.asList(new File("logged-events.txt")),
                        new DefaultFileToLogConverter())));

        loggingServiceManager.registerEventLoggingService(fileLoggingService);
    }

    public void sendEvent(String subject, Map<String, Object> params) {
        eventRelay.sendEventMessage(new MotechEvent(subject, params));
    }

    private class VisitCompletedKeyFlag implements EventFlag {

        @Override
        public boolean passesFlags(MotechEvent motechEvent) {
            return motechEvent.getParameters().containsKey("completed") &&
                    motechEvent.getParameters().get("completed").equals(true);
        }
    }
}
