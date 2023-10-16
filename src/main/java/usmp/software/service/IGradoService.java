package usmp.software.service;

import java.util.List;

import usmp.software.model.Grado;

public interface IGradoService {
    void guardar(Grado grado);

    List<Grado> buscarTodas();

    Grado buscarPorId(Long idGrado);

    void eliminar(Long idGrado);
}