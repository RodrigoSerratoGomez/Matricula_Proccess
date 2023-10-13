package usmp.software.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import usmp.software.model.Seccion;
import usmp.software.repository.SeccionRepository;
import usmp.software.service.ISeccionService;

@Service
@Primary
public class SeccionServiceJpa implements ISeccionService {

    @Autowired
    private SeccionRepository seccionRepo;

    @Override
    public void guardar(Seccion seccion) {
        seccionRepo.save(seccion);
    }

    @Override
    public List<Seccion> buscarTodas() {
        return seccionRepo.findAll();
    }

    @Override
    public Seccion buscarPorId(Long idSeccion) {
        Optional<Seccion> optional = seccionRepo.findById(idSeccion);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void eliminar(Long idSeccion) {
        seccionRepo.deleteById(idSeccion);
    }

}
