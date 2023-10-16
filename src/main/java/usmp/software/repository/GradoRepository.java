package usmp.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import usmp.software.model.Grado;

public interface GradoRepository extends JpaRepository<Grado, Long>{
    
}
