package com.restfull.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restfull.core.entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable>{
	Usuario findByUsername(String username);
	
}
