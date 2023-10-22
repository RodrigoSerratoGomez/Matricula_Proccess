package usmp.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import usmp.software.model.Parentesco;
import usmp.software.model.ParentescoPK;

public interface ParentescoRepository extends JpaRepository<Parentesco, ParentescoPK> {

}
