package ca.on.health.claim.pdf.template.templateservice.API.data.service;


import java.util.Optional;
import com.google.gson.GsonBuilder;

import ca.on.health.claim.pdf.template.templateservice.API.data.entity.PRSB_PDF_Service_Code;
import ca.on.health.claim.pdf.template.templateservice.API.data.entity.PRSB_PDF_Template;
import ca.on.health.claim.pdf.template.templateservice.API.data.repositories.PRSB_PDF_Service_CodeRepository;
import ca.on.health.claim.pdf.template.templateservice.API.data.repositories.PRSB_PDF_TemplateRepository;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EntityService {

    @Autowired
    private PRSB_PDF_TemplateRepository tempRepo;//Database for Template Entity
    @Autowired PRSB_PDF_Service_CodeRepository serviceRepo; // Database for Service_Code Entity

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

    public ResponseEntity addTemplate(PRSB_PDF_Template newTemplate) {
        
        tempRepo.save(newTemplate);
        return new ResponseEntity<>(gson.toJson(newTemplate), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity deleteTemplate(Integer id){
        tempRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public Optional<PRSB_PDF_Template> findById(Integer id) {
       return tempRepo.findById(id);

    }

    public Iterable<PRSB_PDF_Template> findAllTemplates() {

        return tempRepo.findAll();
    }

    public Iterable<PRSB_PDF_Service_Code> getAllServiceCode() {
        
        return serviceRepo.findAll();
    }



    
}
