package br.com.thalesmonteiro.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thalesmonteiro.projeto.entity.UsuarioEntity;

public interface UserRepository  extends JpaRepository<UsuarioEntity, Long>{

}
