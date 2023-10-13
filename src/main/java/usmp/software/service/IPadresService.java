package usmp.software.service;

import java.util.List;

import usmp.software.model.Padres;

public interface IPadresService {
    
    void guardar(Padres padres);

    List<Padres> buscarTodas();

}
