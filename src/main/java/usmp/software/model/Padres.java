package usmp.software.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "PADRES")
@NamedQuery(name = "Padres.findAll", query = "SELECT p FROM Padres p")
public class Padres implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long DNIPAD;
    private String APEPAD;
    private String NOMPAD;
    private String FECNACPAD;
    private String DIRPAD;
    private String GRAINSPAD;
    private String OCUPAD;
    private String CORPAD;
    private Double SUEMENPAD;

    public Padres() {
    }

    public Long getDNIPAD() {
        return DNIPAD;
    }

    public void setDNIPAD(Long dNIPAD) {
        DNIPAD = dNIPAD;
    }

    public String getAPEPAD() {
        return APEPAD;
    }

    public void setAPEPAD(String aPEPAD) {
        APEPAD = aPEPAD;
    }

    public String getNOMPAD() {
        return NOMPAD;
    }

    public void setNOMPAD(String nOMPAD) {
        NOMPAD = nOMPAD;
    }

    public String getFECNACPAD() {
        return FECNACPAD;
    }

    public void setFECNACPAD(String fECNACPAD) {
        FECNACPAD = fECNACPAD;
    }

    public String getDIRPAD() {
        return DIRPAD;
    }

    public void setDIRPAD(String dIRPAD) {
        DIRPAD = dIRPAD;
    }

    public String getGRAINSPAD() {
        return GRAINSPAD;
    }

    public void setGRAINSPAD(String gRAINSPAD) {
        GRAINSPAD = gRAINSPAD;
    }

    public String getOCUPAD() {
        return OCUPAD;
    }

    public void setOCUPAD(String oCUPAD) {
        OCUPAD = oCUPAD;
    }

    public String getCORPAD() {
        return CORPAD;
    }

    public void setCORPAD(String cORPAD) {
        CORPAD = cORPAD;
    }

    public Double getSUEMENPAD() {
        return SUEMENPAD;
    }

    public void setSUEMENPAD(Double sUEMENPAD) {
        SUEMENPAD = sUEMENPAD;
    }

    //RELACION CON PARENTESCO
}
