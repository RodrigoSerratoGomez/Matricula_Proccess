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
@Table(name = "PAIS")
@NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PAIS_GENERATOR", sequenceName = "SEQ_PAIS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAIS_GENERATOR")
	private Long IDPAIS;
	private String NOMPAIS;

	public Pais() {
	}

	public Long getIDPAIS() {
		return IDPAIS;
	}

	public void setIDPAIS(Long iDPAIS) {
		IDPAIS = iDPAIS;
	}

	public String getNOMPAIS() {
		return NOMPAIS;
	}

	public void setNOMPAIS(String nOMPAIS) {
		NOMPAIS = nOMPAIS;
	}

	// RELACION CON ESTUDIANTE
	@OneToMany(mappedBy = "pais")
	private List<Estudiante> estudiantes;

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setPais(this);
		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setPais(null);
		return estudiante;
	}

}