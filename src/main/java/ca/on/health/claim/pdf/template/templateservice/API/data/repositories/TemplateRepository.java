package ca.on.health.claim.pdf.template.templateservice.API.data.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import ca.on.health.claim.pdf.template.templateservice.API.data.entity.TemplateEntity;

@Repository
public interface TemplateRepository extends CrudRepository<TemplateEntity, Integer> {

    @Query(value = "SELECT * FROM templates.template WHERE template.service_code = :service_code", nativeQuery = true)
    ArrayList<TemplateEntity> findByServiceCode(@Param("service_code") Integer service_code);

    // public interface TemplateRepository extends CrudRepository<Template, Integer>
    // {
    // // Query to search DB for record by name, returns a Template object.
    // @Query(value = "SELECT * FROM templates.temps WHERE temps.name =
    // ?#{#temp.name}", nativeQuery = true)
    // public Template findByName(@Param("temp")Template temp);

    // }

}
