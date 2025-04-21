package co.edu.unbosque.parcial.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.parcial.dto.MascotaDTO;
import co.edu.unbosque.parcial.service.MascotaService;

@RestController
@RequestMapping("/mascota")
@CrossOrigin({"*"})
public class MascotaController {
	
	@Autowired
	MascotaService mascotaSer;
	
	@PostMapping("/crear")
	public ResponseEntity<String> crear(@RequestParam String nombre, @RequestParam String raza, @RequestParam String tamaio, @RequestParam double peso, @RequestParam String genero, @RequestParam String especie) {
		MascotaDTO nuevaMascota = new MascotaDTO(nombre,raza,tamaio,peso,genero,especie);
		int estado = mascotaSer.create(nuevaMascota);
		if (estado == 0) {
			return new ResponseEntity<>("Mascota Creada con exito", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Error al crear mascota", HttpStatus.NOT_ACCEPTABLE);
		}
	
	}
	
	@PostMapping("/crearconjson")
	public ResponseEntity<String> crearConJson(@RequestBody MascotaDTO nuevaMascota){
		int status= mascotaSer.create(nuevaMascota);
		if(status==0) {
			return new ResponseEntity<>("Mascota creada con exito", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Error al crear Mascota",HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/eliminarporid/{id}")
	public ResponseEntity<String> deletById(@PathVariable Integer id) {  
	    int status = mascotaSer.deleteById(id);
	    if (status == 0) {
	        return new ResponseEntity<>("Mascota Eliminada con exito", HttpStatus.ACCEPTED);
	    } else {
	        return new ResponseEntity<>("Error al eliminar mascota", HttpStatus.NOT_FOUND);
	    }
	}
	
	@DeleteMapping("/eliminarpornombre/{nombre}")
	public ResponseEntity<String> deleteByName(@RequestParam String nombre) {
		int status = mascotaSer.deleteByNombre(nombre);
		if (status == 0) {

			return new ResponseEntity<String>("Mascota Eliminada con exito", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>("Error al eliminar mascota", HttpStatus.NOT_FOUND);
		}

	}
	
	@DeleteMapping("/eliminarporraza/{raza}")
	public ResponseEntity<String> deleteByRaza(@RequestParam String raza) {
		int status = mascotaSer.deleteByRaza(raza);
		if (status == 0) {

			return new ResponseEntity<String>("Mascota Eliminada con exito", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>("Error al eliminar mascota", HttpStatus.NOT_FOUND);
		}

	}
	
	@DeleteMapping("/eliminarportamanio/{tamanio}")
	public ResponseEntity<String> deleteByTamanio(@RequestParam String tamanio) {
		int status = mascotaSer.deleteByTamanio(tamanio);
		if (status == 0) {

			return new ResponseEntity<String>("Mascota Eliminada con exito", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>("Error al eliminar mascota", HttpStatus.NOT_FOUND);
		}

	}
	@DeleteMapping("/eliminarporpeso/{peso}")
	public ResponseEntity<String> deleteByPeso(@RequestParam double peso) {
		int status = mascotaSer.deleteByPeso(peso);
		if (status == 0) {

			return new ResponseEntity<String>("Viajero Eliminado con exito", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>("Error al eliminar estudiante", HttpStatus.NOT_FOUND);
		}

	}
	@DeleteMapping("/eliminarporgenero/{genero}")
	public ResponseEntity<String> deleteByGenero(@RequestParam String genero) {
		int status = mascotaSer.deleteByGenero(genero);
		if (status == 0) {

			return new ResponseEntity<String>("Mascota Eliminada con exito", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>("Error al eliminar mascota", HttpStatus.NOT_FOUND);
		}

	}
	
	@DeleteMapping("/eliminarporespecie/{especie}")
	public ResponseEntity<String> deleteByEspecie(@RequestParam String especie) {
		int status = mascotaSer.deleteByTamanio(especie);
		if (status == 0) {

			return new ResponseEntity<String>("Mascota Eliminada con exito", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>("Error al eliminar mascota", HttpStatus.NOT_FOUND);
		}

	}
	
	@GetMapping("/mostrartodo")
	public ResponseEntity<ArrayList<MascotaDTO>> mostrarTodo() {
		ArrayList<MascotaDTO> mascota = mascotaSer.findAll();
		if (mascota.isEmpty()) {
			return new ResponseEntity<ArrayList<MascotaDTO>>(mascota, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<ArrayList<MascotaDTO>>(mascota, HttpStatus.ACCEPTED);
		}
	}
	
	@PutMapping("/update")
	ResponseEntity<String> update(@RequestParam Integer id, @RequestParam String nombre, @RequestParam String raza, @RequestParam String tamaio, @RequestParam double peso, @RequestParam String genero, @RequestParam String especie) {
		MascotaDTO newMascota = new MascotaDTO(nombre,raza,tamaio,peso,genero,especie);
		
		int status = mascotaSer.updateById(id, newMascota);

		if (status == 0) {
			return new ResponseEntity<>("Mascota actualizada", HttpStatus.ACCEPTED);
		} else if (status == 1) {
			return new ResponseEntity<>("Mascota existente", HttpStatus.IM_USED);
		} else if (status == 2) {
			return new ResponseEntity<>("Mascota no encontrada", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Error on update", HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/updatenombre/{nombre}")
	ResponseEntity<String> updateNombre(@RequestParam Integer id, @RequestParam String nombre) {
		MascotaDTO newMascota = new MascotaDTO(nombre,null,null,0,null,null);
		
		int status = mascotaSer.updateById(id, newMascota);

		if (status == 0) {
			return new ResponseEntity<>("Mascota actualizada", HttpStatus.ACCEPTED);
		} else if (status == 1) {
			return new ResponseEntity<>("Mascota existente", HttpStatus.IM_USED);
		} else if (status == 2) {
			return new ResponseEntity<>("Mascota no encontrada", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Error on update", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateraza/{raza}")
	ResponseEntity<String> updateRaza(@RequestParam Integer id, @RequestParam String raza) {
		MascotaDTO newMascota = new MascotaDTO(null,raza,null,0,null,null);
		
		int status = mascotaSer.updateById(id, newMascota);

		if (status == 0) {
			return new ResponseEntity<>("Mascota actualizada", HttpStatus.ACCEPTED);
		} else if (status == 1) {
			return new ResponseEntity<>("Mascota existente", HttpStatus.IM_USED);
		} else if (status == 2) {
			return new ResponseEntity<>("Mascota no encontrada", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Error on update", HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/updatetamanio/{tamanio}")
	ResponseEntity<String> update(@RequestParam Integer id, @RequestParam String tamanio) {
		MascotaDTO newMascota = new MascotaDTO(null,null,tamanio,0,null,null);
		
		int status = mascotaSer.updateById(id, newMascota);

		if (status == 0) {
			return new ResponseEntity<>("Mascota actualizada", HttpStatus.ACCEPTED);
		} else if (status == 1) {
			return new ResponseEntity<>("Mascota existente", HttpStatus.IM_USED);
		} else if (status == 2) {
			return new ResponseEntity<>("Mascota no encontrada", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Error on update", HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/updatepeso/{peso}")
	ResponseEntity<String> updatePeso(@RequestParam Integer id, @RequestParam double peso) {
		MascotaDTO newMascota = new MascotaDTO(null,null,null,peso,null,null);
		
		int status = mascotaSer.updateById(id, newMascota);

		if (status == 0) {
			return new ResponseEntity<>("Mascota actualizada", HttpStatus.ACCEPTED);
		} else if (status == 1) {
			return new ResponseEntity<>("Mascota existente", HttpStatus.IM_USED);
		} else if (status == 2) {
			return new ResponseEntity<>("Mascota no encontrada", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Error on update", HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/updategenero/{genero}")
	ResponseEntity<String> updateGenero(@RequestParam Integer id, @RequestParam String genero) {
		MascotaDTO newMascota = new MascotaDTO(null,null,null,0,genero,null);
		
		int status = mascotaSer.updateById(id, newMascota);

		if (status == 0) {
			return new ResponseEntity<>("Mascota actualizada", HttpStatus.ACCEPTED);
		} else if (status == 1) {
			return new ResponseEntity<>("Mascota existente", HttpStatus.IM_USED);
		} else if (status == 2) {
			return new ResponseEntity<>("Mascota no encontrada", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Error on update", HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/updateespecie/{especie}")
	ResponseEntity<String> updateEspecie(@RequestParam Integer id, @RequestParam String especie) {
		MascotaDTO newMascota = new MascotaDTO(null,null,null,0,null,especie);
		
		int status = mascotaSer.updateById(id, newMascota);

		if (status == 0) {
			return new ResponseEntity<>("Mascota actualizada", HttpStatus.ACCEPTED);
		} else if (status == 1) {
			return new ResponseEntity<>("Mascota existente", HttpStatus.IM_USED);
		} else if (status == 2) {
			return new ResponseEntity<>("Mascota no encontrada", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Error on update", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/buscarpornombre/{nombre}")
	public ResponseEntity<ArrayList<MascotaDTO>> buscarPorNombre(@PathVariable String nombre) {
	    ArrayList<MascotaDTO> mascota = mascotaSer.findByNombre(nombre);
	    if (mascota.isEmpty()) {
	        return new ResponseEntity<>(mascota, HttpStatus.NO_CONTENT);
	    } else {
	        return new ResponseEntity<>(mascota, HttpStatus.ACCEPTED);
	    }
	}
	
	@GetMapping("/buscarporraza/{raza}")
	public ResponseEntity<ArrayList<MascotaDTO>> buscarPorRaza(@PathVariable String raza) {
	    ArrayList<MascotaDTO> mascotas = mascotaSer.findByRaza(raza);
	    if (mascotas.isEmpty()) {
	        return new ResponseEntity<>(mascotas, HttpStatus.NO_CONTENT);
	    } else {
	        return new ResponseEntity<>(mascotas, HttpStatus.ACCEPTED);
	    }
	}
	
	@GetMapping("/buscarportamanio/{tamanio}")
	public ResponseEntity<ArrayList<MascotaDTO>> buscarPortamanio(@PathVariable String tamanio) {
	    ArrayList<MascotaDTO> mascotas = mascotaSer.findByTamanio(tamanio);
	    if (mascotas.isEmpty()) {
	        return new ResponseEntity<>(mascotas, HttpStatus.NO_CONTENT);
	    } else {
	        return new ResponseEntity<>(mascotas, HttpStatus.ACCEPTED);
	    }
	}
	
	@GetMapping("/buscarporpeso/{peso}")
	public ResponseEntity<ArrayList<MascotaDTO>> buscarPorpeso(@PathVariable double peso) {
	    ArrayList<MascotaDTO> mascotas = mascotaSer.findByPeso(peso);
	    if (mascotas.isEmpty()) {
	        return new ResponseEntity<>(mascotas, HttpStatus.NO_CONTENT);
	    } else {
	        return new ResponseEntity<>(mascotas, HttpStatus.ACCEPTED);
	    }
	}
	@GetMapping("/buscarporgenero/{genero}")
	public ResponseEntity<ArrayList<MascotaDTO>> buscarPorGenero(@PathVariable String genero) {
	    ArrayList<MascotaDTO> mascotas = mascotaSer.findByGenero(genero);
	    if (mascotas.isEmpty()) {
	        return new ResponseEntity<>(mascotas, HttpStatus.NO_CONTENT);
	    } else {
	        return new ResponseEntity<>(mascotas, HttpStatus.ACCEPTED);
	    }
	}
	
	@GetMapping("/buscarporespecie/{especie}")
	public ResponseEntity<ArrayList<MascotaDTO>> buscarPorespecie(@PathVariable String especie) {
	    ArrayList<MascotaDTO> mascotas = mascotaSer.findByEspecie(especie);
	    if (mascotas.isEmpty()) {
	        return new ResponseEntity<>(mascotas, HttpStatus.NO_CONTENT);
	    } else {
	        return new ResponseEntity<>(mascotas, HttpStatus.ACCEPTED);
	    }
	}
}
