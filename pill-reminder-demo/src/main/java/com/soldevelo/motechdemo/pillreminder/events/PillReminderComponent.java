package com.soldevelo.motechdemo.pillreminder.events;

import org.joda.time.DateTime;
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
import java.util.UUID;

@Service
public class PillReminderComponent {

    private static final Logger LOG = LoggerFactory.getLogger(PillReminderComponent.class);

    @Autowired
    private PillReminderService pillReminderService;

    public void postReminder() {
        MedicineRequest medicineRequest = new MedicineRequest("medicine", LocalDate.now(), LocalDate.now().plusDays(1));
        DosageRequest dosageRequest = new DosageRequest(DateTime.now().getHourOfDay(), DateTime.now().getMinuteOfHour(), Arrays.asList(medicineRequest));
        DailyPillRegimenRequest request = new DailyPillRegimenRequest(UUID.randomUUID().toString(), 1, 1, 1, Arrays.asList(dosageRequest));

        pillReminderService.createNew(request);
    }

    @MotechListener(subjects = EventKeys.PILLREMINDER_REMINDER_EVENT_SUBJECT)
    public void pillReminderEventHandler(MotechEvent event) {
        Map<String, Object> paramMap = event.getParameters();
        paramMap.toString();
        LOG.info("Handled event with params: " + paramMap.toString());
    }
}
