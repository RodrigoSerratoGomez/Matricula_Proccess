package usmp.software.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import usmp.software.model.Matricula;
import usmp.software.repository.MatriculaRepository;
import usmp.software.service.IMatriculaService;

@Service
@Primary
public class MatriculaServiceJpa implements IMatriculaService{
    
    @Autowired
	private MatriculaRepository matriculasRepo;
	
	@Override
	public void guardar(Matricula matricula) {
		matriculasRepo.save(matricula);
	}

	@Override
	public List<Matricula> buscarTodas() {
		return matriculasRepo.findAll();
	}

    @Override
	public Matricula buscarPorId(Long idMatricula) {
		Optional<Matricula> optional = matriculasRepo.findById(idMatricula);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

    //TODO Eliminar
}
