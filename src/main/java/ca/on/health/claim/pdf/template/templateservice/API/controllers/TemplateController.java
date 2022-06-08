package ca.on.health.claim.pdf.template.templateservice.API.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ca.on.health.claim.pdf.template.templateservice.API.data.entity.TemplateEntity;
import ca.on.health.claim.pdf.template.templateservice.API.data.service.EntityService;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@RestController
@RequestMapping("/templates")
public class TemplateController {

    @Autowired
    private EntityService entityService;

    @ApiOperation(value = "Find all templates", notes = "Find all")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @GetMapping(path = "/findAll")
    public @ResponseBody Iterable<TemplateEntity> findAllTemplates() {
        Iterable<TemplateEntity> templates;
        templates = entityService.findAllTemplates();
        return templates;

    }

    @ApiOperation(value = "Find template by id", notes = "Find by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @GetMapping(value = "/findById")
    public ResponseEntity findbyId(@RequestParam Integer id) {

        return entityService.findById(id);

    }

    @ApiOperation(value = "Find template by service code", notes = "Find by service code")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @GetMapping(value = "/findByServiceCode")
    public ResponseEntity findByServiceCode(@RequestParam Integer service_code) {
        return entityService.findByServiceCode(service_code);
    }

    @ApiOperation(value = "Delete template from DB", notes = "Delete template")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
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
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @PostMapping(value = "/addTemplate")
    public ResponseEntity addTemplate(@RequestBody TemplateEntity templateEntity) {

        return entityService.addTemplate(templateEntity);
    }

    @ApiOperation(value = "Update template in DB", notes = "Update template")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @PutMapping(value = "/updateTemplate")
    public ResponseEntity updateTemplate(@RequestBody TemplateEntity updateTemplate) {
        return entityService.updateTemplate(updateTemplate);

    }

}
