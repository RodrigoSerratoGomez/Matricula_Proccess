package usmp.software.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import usmp.software.model.Grado;
import usmp.software.repository.GradoRepository;
import usmp.software.service.IGradoService;

@Service
@Primary
public class GradoServiceJpa implements IGradoService {

    @Autowired
    private GradoRepository gradoRepo;

    @Override
    public void guardar(Grado grado) {
        gradoRepo.save(grado);
    }

    @Override
    public List<Grado> buscarTodas() {
        return gradoRepo.findAll();
    }

    @Override
    public Grado buscarPorId(Long idGrado) {
        Optional<Grado> optional = gradoRepo.findById(idGrado);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void eliminar(Long idGrado) {
        gradoRepo.deleteById(idGrado);
    }
}
