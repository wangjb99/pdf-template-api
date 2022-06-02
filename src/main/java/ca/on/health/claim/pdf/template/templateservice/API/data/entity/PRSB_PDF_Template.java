package ca.on.health.claim.pdf.template.templateservice.API.data.entity;

import java.io.Serializable;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity(name = "prsb_pdf_TemplateEntity")
@Table(name = "prsb_pdf_Template") // Database table name
public class PRSB_PDF_Template implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "html", length = 10000)
    private String html;

    @Column(name = "effective_date")
    @Temporal(TemporalType.DATE)
    private Date effective_date;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date end_date;

    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy,MM,dd", locale = "en-CA", timezone = "America/Toronto")
    private Date create_time;

    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy,MM,dd", locale = "en-CA", timezone = "America/Toronto")
    private Date update_time;

    @ManyToOne
    @JoinColumn(name = "service_code")
    private PRSB_PDF_Service_Code prsb_PDF_Service_Code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
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

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public PRSB_PDF_Service_Code getPrsb_PDF_Service_Code() {
        return prsb_PDF_Service_Code;
    }

    public void setPrsb_PDF_Service_Code(PRSB_PDF_Service_Code prsb_PDF_Service_Code) {
        this.prsb_PDF_Service_Code = prsb_PDF_Service_Code;
    }

    @Override
    public String toString() {
        return "PRSB_PDF_Template [create_time=" + create_time + ", effective_date=" + effective_date + ", end_date="
                + end_date + ", html=" + html + ", id=" + id + ", prsb_PDF_Service_Code=" + prsb_PDF_Service_Code
                + ", update_time=" + update_time + "]";
    }

   

}
