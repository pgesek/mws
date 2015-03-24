package com.soldevelo.motechdemo.domain.security;

import com.soldevelo.motechdemo.domain.domain.Patient;
import org.motechproject.mds.dto.EntityDto;
import org.motechproject.mds.service.EntityService;
import org.motechproject.mds.util.SecurityMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class SecurityComponent {

    @Autowired
    private EntityService entityService;

    @PostConstruct
    public void setUpSecurity() {
        EntityDto entity = entityService.getEntityByClassName(Patient.class.getName());
        entity.setSecurityMode(SecurityMode.ROLES);

        Set<String> roles = new HashSet<>();
        roles.add("visit-admin");
        entity.setSecurityMembers(roles);

        //TODO: Save using DraftData???
    }
}
