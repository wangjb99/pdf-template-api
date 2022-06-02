package ca.on.health.claim.pdf.template.templateservice.API.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ca.on.health.claim.pdf.template.templateservice.API.data.entity.PRSB_PDF_Service_Code;
import ca.on.health.claim.pdf.template.templateservice.API.data.service.EntityService;

@RestController
@RequestMapping(name = "/service")
public class PRSB_PDF_Service_CodeController {
    
    @Autowired
    private EntityService entityService;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<PRSB_PDF_Service_Code> getAllServiceCode(){
        Iterable<PRSB_PDF_Service_Code> services;
        services = entityService.getAllServiceCode();
        return services;
    }
}
