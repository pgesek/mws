package com.soldevelo.motechdemo.channel.web;

import com.soldevelo.motechdemo.domain.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller for HelloWorld message and bundle status.
 */
@Controller
public class HelloWorldController {

    @Autowired
    private VisitService visitService;

    private static final String OK = "OK";

    @RequestMapping("/web-api/status")
    @ResponseBody
    public String status() {
        return OK;
    }

    @RequestMapping(value = "/visit/{patientId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void sayHello(@PathVariable String patientId) {
        visitService.createVisit(patientId);
    }
}
