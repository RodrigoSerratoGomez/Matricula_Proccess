package usmp.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import usmp.software.model.Control;

public interface ControlRepository extends JpaRepository<Control, Long>{
    
}
