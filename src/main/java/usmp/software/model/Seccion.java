package usmp.software.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
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

    // RELACION CON MATRICULA
    @OneToMany(mappedBy = "seccion")
    private List<Matricula> matriculas;

    public List<Matricula> getMatriculas() {
        return this.matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public Matricula addMatricula(Matricula matricula) {
        getMatriculas().add(matricula);
        matricula.setSeccion(this);
        return matricula;
    }

    public Matricula removeMatricula(Matricula matricula) {
        getMatriculas().remove(matricula);
        matricula.setSeccion(null);
        return matricula;
    }
    
}
