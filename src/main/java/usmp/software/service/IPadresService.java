package usmp.software.service;

import java.util.List;

import usmp.software.model.Padres;

public interface IPadresService {

    void guardar(Padres padres);

    List<Padres> buscarTodas();

    Padres buscarPorId(Long idPadres);

    void eliminar(Long idPadres);
}
