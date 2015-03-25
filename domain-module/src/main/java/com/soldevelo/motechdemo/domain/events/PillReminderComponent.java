package com.soldevelo.motechdemo.domain.events;

import org.joda.time.LocalDate;
import org.motechproject.event.MotechEvent;
import org.motechproject.event.listener.annotations.MotechListener;
import org.motechproject.pillreminder.EventKeys;
import org.motechproject.pillreminder.contract.DailyPillRegimenRequest;
import org.motechproject.pillreminder.contract.DosageRequest;
import org.motechproject.pillreminder.contract.MedicineRequest;
import org.motechproject.pillreminder.service.PillReminderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;

@Service
public class PillReminderComponent {

    private static final Logger LOG = LoggerFactory.getLogger(PillReminderComponent.class);

    @Autowired
    private PillReminderService pillReminderService;

    public void postReminder(String id, int hour, int minute) {
        MedicineRequest medicineRequest = new MedicineRequest("medicine", LocalDate.now(), LocalDate.now().plusDays(1));
        DosageRequest dosageRequest = new DosageRequest(hour, minute, Arrays.asList(medicineRequest));
        DailyPillRegimenRequest request = new DailyPillRegimenRequest(id, 1, 1, 1, Arrays.asList(dosageRequest));

        pillReminderService.createNew(request);
    }

    //TODO: Why doesn't this get invoked?
    @MotechListener(subjects = EventKeys.PILLREMINDER_REMINDER_EVENT_SUBJECT)
    public void pillReminderEventHandler(MotechEvent event) {
        Map<String, Object> paramMap = event.getParameters();
        paramMap.toString();
        LOG.error("Handled event with map " + paramMap.toString());
    }
}
