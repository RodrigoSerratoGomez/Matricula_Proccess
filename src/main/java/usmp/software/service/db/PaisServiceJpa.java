package usmp.software.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import usmp.software.model.Pais;
import usmp.software.repository.PaisRepository;
import usmp.software.service.IPaisService;

@Service
@Primary
public class PaisServiceJpa implements IPaisService {
    
    @Autowired
	private PaisRepository paisRepo;

    @Override
	public void guardar(Pais pais) {
		paisRepo.save(pais);
	}

	@Override
	public List<Pais> buscarTodas() {
		return paisRepo.findAll();
	}

	@Override
	public Pais buscarPorId(Long idPais) {
		Optional<Pais> optional = paisRepo.findById(idPais);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(Long idPais) {
		paisRepo.deleteById(idPais);	
	}
}
