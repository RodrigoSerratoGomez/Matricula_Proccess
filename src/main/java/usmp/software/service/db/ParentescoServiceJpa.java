package usmp.software.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import usmp.software.model.Parentesco;
import usmp.software.model.ParentescoPK;
import usmp.software.repository.ParentescoRepository;
import usmp.software.service.IParentescoService;

@Service
@Primary
public class ParentescoServiceJpa implements IParentescoService {

    @Autowired
    private ParentescoRepository parentescoRepo;

    @Override
    public void guardar(Parentesco parentesco) {
        parentescoRepo.save(parentesco);
    }

    @Override
    public List<Parentesco> buscarTodas() {
        return parentescoRepo.findAll();
    }

    @Override
    public Parentesco buscarPorId(ParentescoPK idParentesco) {
        Optional<Parentesco> optional = parentescoRepo.findById(idParentesco);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void eliminar(ParentescoPK idParentesco) {
        parentescoRepo.deleteById(idParentesco);
    }

}
