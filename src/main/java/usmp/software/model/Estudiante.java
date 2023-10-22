package usmp.software.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ESTUDIANTE")
@NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long DNIEST;
    private String APEEST;
    private String NOMEST;
    private String FECNACEST;
    private String DIREST;
    private String LUGNACEST;
    private String ASEEST;

    public Estudiante() {
    }

    public Long getDNIEST() {
        return DNIEST;
    }

    public void setDNIEST(Long dNIEST) {
        DNIEST = dNIEST;
    }

    public String getAPEEST() {
        return APEEST;
    }

    public void setAPEEST(String aPEEST) {
        APEEST = aPEEST;
    }

    public String getNOMEST() {
        return NOMEST;
    }

    public void setNOMEST(String nOMEST) {
        NOMEST = nOMEST;
    }

    public String getFECNACEST() {
        return FECNACEST;
    }

    public void setFECNACEST(String fECNACEST) {
        FECNACEST = fECNACEST;
    }

    public String getDIREST() {
        return DIREST;
    }

    public void setDIREST(String dIREST) {
        DIREST = dIREST;
    }

    public String getLUGNACEST() {
        return LUGNACEST;
    }

    public void setLUGNACEST(String lUGNACEST) {
        LUGNACEST = lUGNACEST;
    }

    public String getASEEST() {
        return ASEEST;
    }

    public void setASEEST(String aSEEST) {
        ASEEST = aSEEST;
    }

    // RELACION CON PAIS
    @ManyToOne
    @JoinColumn(name = "IDPAIS")
    private Pais pais;

    public Pais getPais() {
        return this.pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    // RELACION CON CONTROL
    @OneToMany(mappedBy = "estudiante")
    private List<Control> controles;

    public List<Control> getControles() {
        return this.controles;
    }

    public void setControles(List<Control> controles) {
        this.controles = controles;
    }

    public Control addControl(Control control) {
        getControles().add(control);
        control.setEstudiante(this);
        return control;
    }

    public Control removeControl(Control control) {
        getControles().remove(control);
        control.setEstudiante(null);
        return control;
    }

    // RELACION CON PARENTESCO
    @OneToMany(mappedBy = "estudiante")
    private List<Parentesco> parentescos;

    public List<Parentesco> getParentescos() {
        return this.parentescos;
    }

    public void setParentescos(List<Parentesco> parentescos) {
        this.parentescos = parentescos;
    }

    public Parentesco addParentesco(Parentesco parentesco) {
        getParentescos().add(parentesco);
        parentesco.setEstudiante(this);
        return parentesco;
    }

    public Parentesco removeParentesco(Parentesco parentesco) {
        getParentescos().remove(parentesco);
        parentesco.setEstudiante(null);
        return parentesco;
    }

}
