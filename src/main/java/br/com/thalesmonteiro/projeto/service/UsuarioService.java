package br.com.thalesmonteiro.projeto.service;

import java.util.List;

import br.com.thalesmonteiro.projeto.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.thalesmonteiro.projeto.entity.UsuarioEntity;
import br.com.thalesmonteiro.projeto.repository.UserRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UserRepository usuarioRepository;
	
	public List<UsuarioDTO>  listarTodos(){
			List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDTO::new).toList();
		
	}
	
	public UsuarioDTO inserir(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioRepository.save(usuarioEntity);
		return new UsuarioDTO(usuarioEntity);
	}

	public UsuarioDTO alterar(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
	}
	public void excluir(Long id) {
		UsuarioEntity usuario = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuario);
	}
	public UsuarioDTO buscarPorId(Long id) {
		return new UsuarioDTO(usuarioRepository.findById(id).get());
	}
}
