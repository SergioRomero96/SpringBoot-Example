package com.restfull.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.restfull.core.entity.Nota;

@Repository("NotaRepository")
public interface INotaRepository extends JpaRepository<Nota, Serializable>, PagingAndSortingRepository<Nota, Serializable>{
	Nota findByNombre(String nombre);
	List<Nota> findByTitulo(String titulo);
	Nota findByNombreAndTitulo(String nombre, String titulo);
	Nota findById(long id);
	
	Page<Nota> findAll(Pageable pageable);
}
