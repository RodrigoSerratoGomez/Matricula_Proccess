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
@Table(name = "MATRICULA")
@NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m")
public class Matricula implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "MATRICULA_GENERATOR", sequenceName = "SEQ_MATRICULA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MATRICULA_GENERATOR")
    private Long IDMAT;
    private String FECMAT;

    public Matricula() {
    }

    public Long getIDMAT() {
        return IDMAT;
    }

    public void setIDMAT(Long iDMAT) {
        IDMAT = iDMAT;
    }

    public String getFECMAT() {
        return FECMAT;
    }

    public void setFECMAT(String fECMAT) {
        FECMAT = fECMAT;
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

    // RELACION CON GRADO
    @ManyToOne
    @JoinColumn(name = "IDGRAD")
    private Grado grado;

    public Grado getGrado() {
        return this.grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    // RELACION CON SECCION
    @ManyToOne
    @JoinColumn(name = "IDSEC")
    private Seccion seccion;

    public Seccion getSeccion() {
        return this.seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

}
