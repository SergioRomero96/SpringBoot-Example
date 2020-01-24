package com.restfull.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.restfull.core.dto.NotaDto;
import com.restfull.core.entity.Nota;

public interface INotaService {
	NotaDto add(Nota nota);
	NotaDto update(Nota nota);
	void delete(long id);
	List<NotaDto> getAll();
	
	NotaDto getByNombreAndTitulo(String nombre, String titulo);
	List<NotaDto> getByTitulo(String titulo);
	List<NotaDto> getByPagination(Pageable pageable);
}
