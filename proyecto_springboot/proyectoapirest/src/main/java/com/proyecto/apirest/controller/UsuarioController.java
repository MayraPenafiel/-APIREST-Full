package com.proyecto.apirest.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.apirest.entity.Usuario;
import com.proyecto.apirest.service.UsuarioService;

@RestController
@RequestMapping("/api/users")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	//Crear un usuario
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));	
	}
	
	//leer usuario por id
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id") Long id){
		Optional<Usuario> oUser =usuarioService.findById(id);
		if(!oUser.isPresent())	{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUser);
	}
	
	//Actualizar un Usuario
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario usuarioDetalles,@PathVariable(value="id") Long id){
		Optional<Usuario> usuario=usuarioService.findById(id);
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		//BeanUtils.copyProperties(usuarioDetalles, usuario.get());
		usuario.get().setNombre(usuarioDetalles.getNombre());
		usuario.get().setClave(usuarioDetalles.getClave());
		usuario.get().setEmail(usuarioDetalles.getEmail());
		usuario.get().setEstado(usuarioDetalles.isEstado());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario.get()));
	}
	
	//Eliminar un Usuario
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value="id") Long id){
		if(!usuarioService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usuarioService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	//Leer todos los usuarios
	@GetMapping
	public List<Usuario> readAll(){
		List<Usuario> usuarios =StreamSupport
				.stream(usuarioService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return usuarios;
	}
	
	
	
}
