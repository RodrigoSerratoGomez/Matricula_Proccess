package usmp.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import usmp.software.model.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

}
