package usmp.software.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTROL")
@NamedQuery(name = "Control.findAll", query = "SELECT c FROM Control c")
public class Control implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "CONTROL_GENERATOR", sequenceName = "SEQ_CONTROL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTROL_GENERATOR")
    private Long IDCON;
    private String FECCON;
    private Double PESCON;
    private Double TALCON;
    private String ALECON;

    public Control() {
    }

    public Long getIDCON() {
        return IDCON;
    }

    public void setIDCON(Long iDCON) {
        IDCON = iDCON;
    }

    public String getFECCON() {
        return FECCON;
    }

    public void setFECCON(String fECCON) {
        FECCON = fECCON;
    }

    public Double getPESCON() {
        return PESCON;
    }

    public void setPESCON(Double pESCON) {
        PESCON = pESCON;
    }

    public Double getTALCON() {
        return TALCON;
    }

    public void setTALCON(Double tALCON) {
        TALCON = tALCON;
    }

    public String getALECON() {
        return ALECON;
    }

    public void setALECON(String aLECON) {
        ALECON = aLECON;
    }

    // RELACION CON ESTUDIANTE
    @ManyToOne
    @JoinColumn(name = "DNIEST")
    private Estudiante estudiante;

    public Estudiante getEstudiante() {
        return this.estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
