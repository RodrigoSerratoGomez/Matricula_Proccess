package usmp.software.service;

import java.util.List;

import usmp.software.model.Pais;

public interface IPaisService {
	void guardar(Pais pais);

	List<Pais> buscarTodas();

	Pais buscarPorId(Long idPais);

	void eliminar(Long idPais);
}
