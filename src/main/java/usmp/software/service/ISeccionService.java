package usmp.software.service;

import java.util.List;

import usmp.software.model.Seccion;

public interface ISeccionService {
    void guardar(Seccion seccion);

    List<Seccion> buscarTodas();

    Seccion buscarPorId(Long idSeccion);

    void eliminar(Long idSeccion);
}
