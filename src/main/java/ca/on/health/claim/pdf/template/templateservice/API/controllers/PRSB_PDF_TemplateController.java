package ca.on.health.claim.pdf.template.templateservice.API.controllers;


import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ca.on.health.claim.pdf.template.templateservice.API.data.entity.PRSB_PDF_Template;
import ca.on.health.claim.pdf.template.templateservice.API.data.service.EntityService;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/templates")
public class PRSB_PDF_TemplateController {
    
    @Autowired
    private EntityService entityService;

    // Find all templates
    @GetMapping(path = "/findAll")
    public @ResponseBody Iterable<PRSB_PDF_Template> findAllTemplates() {
        Iterable<PRSB_PDF_Template> templates;
        templates = entityService.findAllTemplates();
        return templates;

    }

    // Find template by id
    @GetMapping(value = "/findById")
    public @ResponseBody Optional<PRSB_PDF_Template> findbyId(@RequestParam Integer id) {

        return entityService.findById(id);

    }

    // Delete a template by id
    @DeleteMapping(value = "/deleteTemplate")
    public ResponseEntity deleteTemplate(@RequestParam Integer id) {

        return entityService.deleteTemplate(id);
    }

   
    @ApiOperation(value = "Add new template to DB", notes = "Add template")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @PostMapping(value = "/addTemplate")
    public ResponseEntity addTemplate(@RequestBody PRSB_PDF_Template prsb_PDF_Template) {
        
        return entityService.addTemplate(prsb_PDF_Template);
    }
}
