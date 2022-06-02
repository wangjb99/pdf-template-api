package ca.on.health.claim.pdf.template.templateservice.API.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.on.health.claim.pdf.template.templateservice.API.data.entity.ServiceCodeEntity;

@Repository
public interface ServiceCodeRepository extends CrudRepository<ServiceCodeEntity, Integer> {
    
}
