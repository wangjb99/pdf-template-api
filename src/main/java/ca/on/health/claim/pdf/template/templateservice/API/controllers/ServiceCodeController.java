package ca.on.health.claim.pdf.template.templateservice.API.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ca.on.health.claim.pdf.template.templateservice.API.data.entity.ServiceCodeEntity;
import ca.on.health.claim.pdf.template.templateservice.API.data.service.EntityService;

@RestController
@RequestMapping(name = "/service")
public class ServiceCodeController {
    
    @Autowired
    private EntityService entityService;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<ServiceCodeEntity> getAllServiceCode(){
        Iterable<ServiceCodeEntity> services;
        services = entityService.getAllServiceCode();
        return services;
    }
}
