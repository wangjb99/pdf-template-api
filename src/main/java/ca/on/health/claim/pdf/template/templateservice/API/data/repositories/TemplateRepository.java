package ca.on.health.claim.pdf.template.templateservice.API.data.repositories;

import org.springframework.data.repository.CrudRepository;

import ca.on.health.claim.pdf.template.templateservice.API.data.entity.TemplateEntity;

public interface TemplateRepository extends CrudRepository<TemplateEntity, Integer> {

// Example to work from    
// @Repository
// public  interface TemplateRepository extends CrudRepository<Template, Integer> {
//     // Query to search DB for record by name, returns a Template object.
//     @Query(value =  "SELECT * FROM templates.temps WHERE temps.name = ?#{#temp.name}", nativeQuery = true)
//     public Template findByName(@Param("temp")Template temp);

    
//     }
    
}
