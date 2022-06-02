package ca.on.health.claim.pdf.template.templateservice.API.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.on.health.claim.pdf.template.templateservice.API.data.entity.PRSB_PDF_Service_Code;

@Repository
public interface PRSB_PDF_Service_CodeRepository extends CrudRepository<PRSB_PDF_Service_Code, Integer> {
    
}
