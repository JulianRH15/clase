package co.edu.unbosque.parcial.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.parcial.model.Mascota;

public interface MascotaRepository extends CrudRepository<Mascota, Integer> {
	public Optional<Mascota> findByNombre(String nombre);

	public Optional<Mascota> findByPeso(double peso);
	List<Mascota> findAllByNombre(String nombre);
	List<Mascota> findByRaza(String raza);
	List<Mascota> findByTamanio(String tamanio);
	List<Mascota> findByGenero(String genero);
	List<Mascota> findByEspecie(String especie);

	


	
}
