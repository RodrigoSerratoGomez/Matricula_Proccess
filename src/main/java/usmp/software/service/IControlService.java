package usmp.software.service;

import java.util.List;

import usmp.software.model.Control;

public interface IControlService {
    void guardar(Control control);

    List<Control> buscarTodas();

    Control buscarPorId(Long idControl);

    void eliminar(Long idControl);
}
