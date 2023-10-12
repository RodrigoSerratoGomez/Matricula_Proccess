package usmp.software.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import usmp.software.model.Control;
import usmp.software.repository.ControlRepository;
import usmp.software.service.IControlService;

@Service
@Primary
public class ControlServiceJpa implements IControlService {

    @Autowired
    private ControlRepository controlRepo;

    @Override
    public void guardar(Control control) {
        controlRepo.save(control);
    }

    @Override
    public List<Control> buscarTodas() {
        return controlRepo.findAll();
    }

    @Override
    public Control buscarPorId(Long idControl) {
        Optional<Control> optional = controlRepo.findById(idControl);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void eliminar(Long idControl) {
        controlRepo.deleteById(idControl);
    }

}
