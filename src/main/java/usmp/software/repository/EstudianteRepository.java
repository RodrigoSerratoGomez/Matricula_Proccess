package usmp.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import usmp.software.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{
    
}
