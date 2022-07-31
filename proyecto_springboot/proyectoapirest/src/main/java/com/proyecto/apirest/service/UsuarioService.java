package com.proyecto.apirest.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proyecto.apirest.entity.Usuario;

@Service
public interface UsuarioService {
	
	public Iterable<Usuario> findAll();
	
	public Page<Usuario> finAll(Pageable pageable);
	
	public Optional<Usuario> findById(Long Id);
	
	public Usuario save (Usuario usuario);
	
	public void deleteById(Long id);

}
