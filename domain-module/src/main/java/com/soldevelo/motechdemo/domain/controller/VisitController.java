package com.soldevelo.motechdemo.domain.controller;

import com.soldevelo.motechdemo.domain.domain.VisitStatus;
import com.soldevelo.motechdemo.domain.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
@RequestMapping("/visit")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @RequestMapping(value = "/add/{patientId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void addVisit(@PathVariable("patientId") String patientId) {
        visitService.createVisit(patientId, false);
    }

    @RequestMapping(value = "/update/{patientId}/{status}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void updateVisit(@PathVariable("patientId") String patientId, @PathVariable("status") String status) {
        visitService.updateVisit(patientId, VisitStatus.valueOf(status));
    }

    @RequestMapping(value = "/audit/{patientId}", method = RequestMethod.GET)
    @ResponseBody
    public List audit(@PathVariable("patientId") String patientId) {
        return visitService.getVisitAudit(patientId);
    }

}
