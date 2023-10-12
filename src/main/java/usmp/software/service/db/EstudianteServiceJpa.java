package usmp.software.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import usmp.software.model.Estudiante;
import usmp.software.repository.EstudianteRepository;
import usmp.software.service.IEstudianteService;

@Service
@Primary
public class EstudianteServiceJpa implements IEstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepo;

    @Override
    public void guardar(Estudiante estudiante) {
        estudianteRepo.save(estudiante);
    }

    @Override
    public List<Estudiante> buscarTodas() {
        return estudianteRepo.findAll();
    }

    @Override
    public Estudiante buscarPorId(Long idEstudiante) {
        Optional<Estudiante> optional = estudianteRepo.findById(idEstudiante);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void eliminar(Long idEstudiante) {
        estudianteRepo.deleteById(idEstudiante);
    }

}
