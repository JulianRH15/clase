package co.edu.unbosque.parcial.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.parcial.dto.MascotaDTO;
import co.edu.unbosque.parcial.model.Mascota;
import co.edu.unbosque.parcial.repository.MascotaRepository;

@Service
public class MascotaService {
@Autowired
private MascotaRepository mascotaRepo;
@Autowired
private ModelMapper modelMapper;

public MascotaService() {
	// TODO Auto-generated constructor stub
}
public int create(MascotaDTO data) {

	Mascota entity = modelMapper.map(data, Mascota.class);
	try {
		mascotaRepo.save(entity);
		return 0;

	} catch (Exception e) {
		return -1;
	}
}

public List<MascotaDTO> findAll() {
	ArrayList<Mascota> entiryList = (ArrayList<Mascota>) mascotaRepo.findAll();
	ArrayList<MascotaDTO> dtoList = new ArrayList<>();
	entiryList.forEach((entity) -> {
		MascotaDTO dto = modelMapper.map(entity, MascotaDTO.class);
		dtoList.add(dto);
	});
	return dtoList;
}

public int deleteById(int id) {
	Optional<Mascota> found = mascotaRepo.findById(id);
	if (found.isPresent()) {
		mascotaRepo.delete(found.get());
		return 0;
	} else {
		return 1;
	}
}
public int countList() {
	ArrayList<Mascota> entityList = (ArrayList<Mascota>) mascotaRepo.findAll();
	int count = entityList.size();
	return count;
}
public int deleteByNombre(String nombre) {
    List<Mascota> mascotas = mascotaRepo.findAllByNombre(nombre);
    
    if (!mascotas.isEmpty()) {
        mascotas.forEach(viajero -> mascotaRepo.delete(viajero)); 
        return 0; 
    } else {
        return 1; 
    }
}
public int deleteByRaza(String raza) {
    List<Mascota> mascotas = mascotaRepo.findByRaza(raza);
    
    if (!mascotas.isEmpty()) {
        mascotas.forEach(viajero -> mascotaRepo.delete(viajero)); 
        return 0; 
    } else {
        return 1; 
    }
}

public int deleteByTamanio(String tamanio) {
    List<Mascota> mascotas = mascotaRepo.findByTamanio(tamanio);
    
    if (!mascotas.isEmpty()) {
        mascotas.forEach(viajero -> mascotaRepo.delete(viajero)); 
        return 0; 
    } else {
        return 1; 
    }
}

public int deleteByPeso(double peso) {
    Optional<Mascota> found = mascotaRepo.findByPeso(peso);
    if (found.isPresent()) {
        mascotaRepo.delete(found.get());
        return 0;
    } else {
        return 1;
    }
}

public int deleteByGenero(String Genero) {
    List<Mascota> mascotas = mascotaRepo.findByGenero(Genero);
    
    if (!mascotas.isEmpty()) {
        mascotas.forEach(viajero -> mascotaRepo.delete(viajero)); 
        return 0; 
    } else {
        return 1; 
    }
}
public int deleteByEspecie(String especie) {
    List<Mascota> mascotas = mascotaRepo.findByEspecie(especie);
    
    if (!mascotas.isEmpty()) {
        mascotas.forEach(viajero -> mascotaRepo.delete(viajero)); 
        return 0; 
    } else {
        return 1; 
    }
}

public int updateById(Integer id, MascotaDTO newData) {
	Optional<Mascota> found= mascotaRepo.findById(id);
	Optional<Mascota> newFound= mascotaRepo.findByNombre(newData.getNombre());
	if (found.isPresent() && !newFound.isPresent()) {
		Mascota temp = found.get();
		temp.setNombre(newData.getNombre());
		temp.setRaza(newData.getRaza());
		temp.setTamanio(newData.getTamanio());
		temp.setPeso(newData.getPeso());
		temp.setGenero(newData.getGenero());
		temp.setEspecie(newData.getEspecie());
		
		mascotaRepo.save(temp);
		return 0;
	}
	if (found.isPresent() && newFound.isPresent()) {
		return 1;
	}
	if (!found.isPresent()) {
		return 2;
	} else {
		return 3;
	}
}

public int updateNombre(Integer id, MascotaDTO newData) {
	Optional<Mascota> found= mascotaRepo.findById(id);
	Optional<Mascota> newFound= mascotaRepo.findByNombre(newData.getNombre());
	if (found.isPresent() && !newFound.isPresent()) {
		Mascota temp = found.get();
		temp.setNombre(newData.getNombre());
		
		mascotaRepo.save(temp);
		return 0;
	}
	if (found.isPresent() && newFound.isPresent()) {
		return 1;
	}
	if (!found.isPresent()) {
		return 2;
	} else {
		return 3;
	}
}

public int updateRaza(Integer id, MascotaDTO newData) {
	Optional<Mascota> found= mascotaRepo.findById(id);
	Optional<Mascota> newFound= mascotaRepo.findByNombre(newData.getNombre());
	if (found.isPresent() && !newFound.isPresent()) {
		Mascota temp = found.get();
		temp.setRaza(newData.getRaza());
		mascotaRepo.save(temp);
		return 0;
	}
	if (found.isPresent() && newFound.isPresent()) {
		return 1;
	}
	if (!found.isPresent()) {
		return 2;
	} else {
		return 3;
	}
}

public int updateTamanio(Integer id, MascotaDTO newData) {
	Optional<Mascota> found= mascotaRepo.findById(id);
	Optional<Mascota> newFound= mascotaRepo.findByNombre(newData.getNombre());
	if (found.isPresent() && !newFound.isPresent()) {
		Mascota temp = found.get();
		temp.setTamanio(newData.getTamanio());	
		mascotaRepo.save(temp);
		return 0;
	}
	if (found.isPresent() && newFound.isPresent()) {
		return 1;
	}
	if (!found.isPresent()) {
		return 2;
	} else {
		return 3;
	}
}

public int updatePeso(Integer id, MascotaDTO newData) {
	Optional<Mascota> found= mascotaRepo.findById(id);
	Optional<Mascota> newFound= mascotaRepo.findByNombre(newData.getNombre());
	if (found.isPresent() && !newFound.isPresent()) {
		Mascota temp = found.get();
		temp.setPeso(newData.getPeso());
		mascotaRepo.save(temp);
		return 0;
	}
	if (found.isPresent() && newFound.isPresent()) {
		return 1;
	}
	if (!found.isPresent()) {
		return 2;
	} else {
		return 3;
	}
}

public int updateGenero(Integer id, MascotaDTO newData) {
	Optional<Mascota> found= mascotaRepo.findById(id);
	Optional<Mascota> newFound= mascotaRepo.findByNombre(newData.getNombre());
	if (found.isPresent() && !newFound.isPresent()) {
		Mascota temp = found.get();
		temp.setGenero(newData.getGenero());
		
		mascotaRepo.save(temp);
		return 0;
	}
	if (found.isPresent() && newFound.isPresent()) {
		return 1;
	}
	if (!found.isPresent()) {
		return 2;
	} else {
		return 3;
	}
}
public int updateEspecie(Integer id, MascotaDTO newData) {
	Optional<Mascota> found= mascotaRepo.findById(id);
	Optional<Mascota> newFound= mascotaRepo.findByNombre(newData.getNombre());
	if (found.isPresent() && !newFound.isPresent()) {
		Mascota temp = found.get();
		temp.setEspecie(newData.getEspecie());
		
		mascotaRepo.save(temp);
		return 0;
	}
	if (found.isPresent() && newFound.isPresent()) {
		return 1;
	}
	if (!found.isPresent()) {
		return 2;
	} else {
		return 3;
	}
}

public List<MascotaDTO> findByNombre(String nombre) {
    List<Mascota> entityList = mascotaRepo.findAllByNombre(nombre);
    ArrayList<MascotaDTO> dtoList = new ArrayList<>();
    entityList.forEach((entity) -> {
        MascotaDTO dto = modelMapper.map(entity, MascotaDTO.class);
        dtoList.add(dto);
    });
    return dtoList;
}
public List<MascotaDTO> findByRaza(String raza) {
    List<Mascota> entityList = mascotaRepo.findByRaza(raza);
    ArrayList<MascotaDTO> dtoList = new ArrayList<>();
    entityList.forEach((entity) -> {
        MascotaDTO dto = modelMapper.map(entity, MascotaDTO.class);
        dtoList.add(dto);
    });
    return dtoList;
}
public List<MascotaDTO> findByTamanio(String tamanio) {
    List<Mascota> entityList = mascotaRepo.findByTamanio(tamanio);
    ArrayList<MascotaDTO> dtoList = new ArrayList<>();
    entityList.forEach((entity) -> {
        MascotaDTO dto = modelMapper.map(entity, MascotaDTO.class);
        dtoList.add(dto);
    });
    return dtoList;
}
public List<MascotaDTO> findByPeso(double peso) {
    Optional<Mascota> entity = mascotaRepo.findByPeso(peso);
    ArrayList<MascotaDTO> dtoList = new ArrayList<>();
    entity.ifPresent((mascota) -> {
        dtoList.add(modelMapper.map(mascota, MascotaDTO.class));
    });
    return dtoList;
}

public List<MascotaDTO> findByGenero(String genero) {
    List<Mascota> entityList = mascotaRepo.findByGenero(genero);
    ArrayList<MascotaDTO> dtoList = new ArrayList<>();
    entityList.forEach((entity) -> {
        MascotaDTO dto = modelMapper.map(entity, MascotaDTO.class);
        dtoList.add(dto);
    });
    return dtoList;
}
public List<MascotaDTO> findByEspecie(String especie) {
    List<Mascota> entityList = mascotaRepo.findByEspecie(especie);
    ArrayList<MascotaDTO> dtoList = new ArrayList<>();
    entityList.forEach((entity) -> {
        MascotaDTO dto = modelMapper.map(entity, MascotaDTO.class);
        dtoList.add(dto);
    });
    return dtoList;
}
}
