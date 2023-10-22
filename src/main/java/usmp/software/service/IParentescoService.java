package usmp.software.service;

import java.util.List;

import usmp.software.model.Parentesco;
import usmp.software.model.ParentescoPK;

public interface IParentescoService {
    void guardar(Parentesco parentesco);

    List<Parentesco> buscarTodas();

    Parentesco buscarPorId(ParentescoPK idParentesco);

    void eliminar(ParentescoPK idParentesco);
}
