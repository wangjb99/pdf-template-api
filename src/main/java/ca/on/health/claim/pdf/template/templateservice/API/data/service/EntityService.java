package ca.on.health.claim.pdf.template.templateservice.API.data.service;

import java.util.ArrayList;
import java.util.Optional;

import com.google.gson.GsonBuilder;

import ca.on.health.claim.pdf.template.templateservice.API.data.entity.ServiceCodeEntity;
import ca.on.health.claim.pdf.template.templateservice.API.data.entity.TemplateEntity;
import ca.on.health.claim.pdf.template.templateservice.API.data.repositories.ServiceCodeRepository;
import ca.on.health.claim.pdf.template.templateservice.API.data.repositories.TemplateRepository;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EntityService {

    @Autowired
    private TemplateRepository tempRepo;// Database for Template Entity
    @Autowired
    ServiceCodeRepository serviceRepo; // Database for Service_Code Entity

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();


    @Transactional
    public ResponseEntity addTemplate(TemplateEntity newTemplate) {

        tempRepo.save(newTemplate);
        return new ResponseEntity<>(gson.toJson(newTemplate), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity deleteTemplate(Integer id) {

        tempRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity findById(Integer id) {
        TemplateEntity template;
        template = tempRepo.findById(id).get();
        return new ResponseEntity<>(gson.toJson(template), HttpStatus.OK);

    }

    public Iterable<TemplateEntity> findAllTemplates() {

        return tempRepo.findAll();
    }

    @Transactional
    public ResponseEntity updateTemplate(TemplateEntity updateTemplate) {
        TemplateEntity template;
        template = tempRepo.findById(updateTemplate.getId()).get();
        template.setCreate_time(updateTemplate.getCreate_time());
        template.setEffective_date(updateTemplate.getEffective_date());
        template.setEnd_date(updateTemplate.getEnd_date());
        template.setUpdate_time(updateTemplate.getUpdate_time());
        template.setHtml(updateTemplate.getHtml());
        
        return new ResponseEntity<>(gson.toJson(template), HttpStatus.OK);
    }

    public ResponseEntity findByServiceCode(Integer service_code) {
        ArrayList<TemplateEntity> templates = tempRepo.findByServiceCode(service_code);
        return new ResponseEntity<>(templates, HttpStatus.OK);
    }


    // ServiceCodeEntity

    public Iterable<ServiceCodeEntity> getAllServiceCode() {

        return serviceRepo.findAll();
    }

    public ResponseEntity findByCode(Integer service_code) {
        ServiceCodeEntity serviceCode;
        serviceCode = serviceRepo.findById(service_code).get();
        return new ResponseEntity<>(serviceCode, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity addService(ServiceCodeEntity serviceCodeEntity) {
        serviceRepo.save(serviceCodeEntity);
        return new ResponseEntity<>(serviceCodeEntity, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity deleteService(Integer id) {
        serviceRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity updateService(ServiceCodeEntity updateService) {
        ServiceCodeEntity service;
        service = serviceRepo.findById(updateService.getService_code()).get();
        service.setEffective_date(updateService.getEffective_date());
        service.setEnd_date(updateService.getEnd_date());
        service.setName(updateService.getName());
        
        return new ResponseEntity<>(gson.toJson(service), HttpStatus.OK);
    }



}
