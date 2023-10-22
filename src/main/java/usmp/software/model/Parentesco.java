package usmp.software.model;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "PARENTESCO")
@NamedQuery(name = "Parentesco.findAll", query = "SELECT p FROM Parentesco p")
public class Parentesco implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ParentescoPK ID;

    @ManyToOne
    @JoinColumn(name = "DNIEST", insertable = false, updatable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "DNIPAD", insertable = false, updatable = false)
    private Padres padres;

    public Parentesco() {
    }

    public ParentescoPK getID() {
        return ID;
    }

    public void setID(ParentescoPK iD) {
        ID = iD;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Padres getPadres() {
        return padres;
    }

    public void setPadres(Padres padres) {
        this.padres = padres;
    }

}
