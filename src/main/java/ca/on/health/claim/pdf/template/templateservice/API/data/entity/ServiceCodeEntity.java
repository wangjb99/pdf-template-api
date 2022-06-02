package ca.on.health.claim.pdf.template.templateservice.API.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "prsb_pdf_Service_Code") // Database table name
public class ServiceCodeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_code")
    private Integer service_code;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private TemplateEntity templateEntity;

    @Column(name = "name")
    private String name;

    @Column(name = "effective_date")
    @Temporal(TemporalType.DATE)
    private Date effective_date;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date end_date;

    public Integer getService_code() {
        return service_code;
    }

    public void setService_code(Integer service_code) {
        this.service_code = service_code;
    }

    public TemplateEntity getTemplateEntity() {
        return templateEntity;
    }

    public void setTemplateEntity(TemplateEntity templateEntity) {
        this.templateEntity = templateEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEffective_date() {
        return effective_date;
    }

    public void setEffective_date(Date effective_date) {
        this.effective_date = effective_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "ServiceCodeEntity [effective_date=" + effective_date + ", end_date=" + end_date + ", name=" + name
                + ", service_code=" + service_code + ", templateEntity=" + templateEntity + "]";
    }

  

    

}
