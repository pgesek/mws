package com.soldevelo.motechdemo.domain.repository;

import com.soldevelo.motechdemo.domain.domain.Patient;
import org.joda.time.DateTime;
import org.motechproject.commons.api.Range;
import org.motechproject.mds.annotations.Lookup;
import org.motechproject.mds.annotations.LookupField;
import org.motechproject.mds.service.MotechDataService;

import java.util.List;
import java.util.Set;

public interface PatientDataService extends MotechDataService<Patient> {

    @Lookup
    List<Patient> getByBirthDate(@LookupField(name = "birthdate") Range<DateTime> birthdate);

    @Lookup
    Patient getByBirthplace(@LookupField(name = "name") Set<String> name);
}
