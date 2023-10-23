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
@Table(name = "GRADO")
@NamedQuery(name = "Grado.findAll", query = "SELECT g FROM Grado g")
public class Grado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "GRADO_GENERATOR", sequenceName = "SEQ_GRADO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRADO_GENERATOR")
	private Long IDGRAD;
	private String NOMGRAD;

	public Grado() {
	}

	public Long getIDGRAD() {
		return IDGRAD;
	}

	public void setIDGRAD(Long iDGRAD) {
		IDGRAD = iDGRAD;
	}

	public String getNOMGRAD() {
		return NOMGRAD;
	}

	public void setNOMGRAD(String nOMGRAD) {
		NOMGRAD = nOMGRAD;
	}

	// RELACION CON MATRICULA
    @OneToMany(mappedBy = "grado")
    private List<Matricula> matriculas;

    public List<Matricula> getMatriculas() {
        return this.matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public Matricula addMatricula(Matricula matricula) {
        getMatriculas().add(matricula);
        matricula.setGrado(this);
        return matricula;
    }

    public Matricula removeMatricula(Matricula matricula) {
        getMatriculas().remove(matricula);
        matricula.setGrado(null);
        return matricula;
    }

}