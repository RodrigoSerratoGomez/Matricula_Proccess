package usmp.software.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import usmp.software.model.Padres;
import usmp.software.repository.PadresRepository;
import usmp.software.service.IPadresService;

@Service
@Primary
public class PadresServiceJpa implements IPadresService {

    @Autowired
    private PadresRepository padresRepo;

    @Override
    public void guardar(Padres padres) {
        padresRepo.save(padres);
    }

    @Override
    public List<Padres> buscarTodas() {
        return padresRepo.findAll();
    }

    @Override
    public Padres buscarPorId(Long idPadres) {
        Optional<Padres> optional = padresRepo.findById(idPadres);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
    
}
