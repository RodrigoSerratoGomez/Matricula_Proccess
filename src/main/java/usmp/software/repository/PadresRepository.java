package usmp.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import usmp.software.model.Padres;

public interface PadresRepository extends JpaRepository<Padres, Long>{
    
}
