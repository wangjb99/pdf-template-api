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

import ca.on.health.claim.pdf.template.templateservice.API.data.entity.ServiceCodeEntity;
import ca.on.health.claim.pdf.template.templateservice.API.data.service.EntityService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@RestController
@RequestMapping(name = "/service")
public class ServiceCodeController {
    
    @Autowired
    private EntityService entityService;


    @ApiOperation(value = "Find all service_code", notes = "Find all")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @GetMapping(path = "/findAll")
    public @ResponseBody Iterable<ServiceCodeEntity> getAllServiceCode(){
        Iterable<ServiceCodeEntity> services;
        services = entityService.getAllServiceCode();
        return services;
    }

    @ApiOperation(value = "Find by service_code", notes = "Find by service_code")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @GetMapping(path = "/findByCode")
    public ResponseEntity findByServiceCode(@RequestParam Integer service_code){
            return entityService.findByCode(service_code);
    }

    @ApiOperation(value = "Add new service to DB", notes = "Add service")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @PostMapping(value = "/addService")
    public ResponseEntity addService(@RequestBody ServiceCodeEntity serviceCodeEntity) {

        return entityService.addService(serviceCodeEntity);
    }

    @ApiOperation(value = "Delete service from DB", notes = "Delete service")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @DeleteMapping(value = "/deleteService")
    public ResponseEntity deleteTemplate(@RequestParam Integer id) {

        return entityService.deleteService(id);
    }

    @ApiOperation(value = "Update service in DB", notes = "Update service")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @PutMapping(value = "/updateService")
    public ResponseEntity updateTemplate(@RequestBody ServiceCodeEntity updateService) {
        return entityService.updateService(updateService);

    }
}
