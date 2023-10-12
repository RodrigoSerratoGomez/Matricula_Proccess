package usmp.software.service;

import java.util.List;

import usmp.software.model.Estudiante;

public interface IEstudianteService {
    void guardar(Estudiante estudiante);

    List<Estudiante> buscarTodas();

    Estudiante buscarPorId(Long idEstudiante);

    void eliminar(Long idEstudiante);
}
