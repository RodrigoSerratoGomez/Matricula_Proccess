package usmp.software.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "SECCION")
@NamedQuery(name = "Seccion.findAll", query = "SELECT s FROM Seccion s")
public class Seccion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SECCION_GENERATOR", sequenceName = "SEQ_SECCION", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECCION_GENERATOR")
    private Long IDSEC;
    private String NOMSEC;

    public Seccion() {
    }

    public Long getIDSEC() {
        return IDSEC;
    }

    public void setIDSEC(Long iDSEC) {
        IDSEC = iDSEC;
    }

    public String getNOMSEC() {
        return NOMSEC;
    }

    public void setNOMSEC(String nOMSEC) {
        NOMSEC = nOMSEC;
    }

    // TODO RELACION CON MATRICULA
    
}
