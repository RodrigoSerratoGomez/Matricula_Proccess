package usmp.software.service;

import java.util.List;

import usmp.software.model.Matricula;

public interface IMatriculaService {

    void guardar(Matricula matricula);

    List<Matricula> buscarTodas();

    //TODO Modificar

    //TODO Eliminar
}
