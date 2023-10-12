package usmp.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import usmp.software.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {
    
}
