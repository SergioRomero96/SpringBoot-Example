package com.restfull.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.restfull.core.converter.Converter;
import com.restfull.core.dto.NotaDto;
import com.restfull.core.entity.Nota;
import com.restfull.core.repository.INotaRepository;
import com.restfull.core.service.INotaService;

@Service("NotaService")
public class NotaServiceImpl implements INotaService {
	@Autowired
	@Qualifier("NotaRepository")
	private INotaRepository notaRepository;
	
	@Autowired
	@Qualifier("converter")
	private Converter converter;
	
	private static final Log logger = LogFactory.getLog(NotaServiceImpl.class);
	
	public NotaDto add(Nota nota) {
		logger.info("creando nota");
		try {
			Nota notaInDb = notaRepository.save(nota);
			logger.info("Nota Creada");
			return new NotaDto(notaInDb);
		}catch(Exception e) {
			logger.error("Error al crear la nota: " + e.getMessage());
		}
		return new NotaDto();
	
	}
	
	public NotaDto update(Nota nota) {
		Nota notaInDb = notaRepository.save(nota);
		return new NotaDto(notaInDb);
	}
	
	public void delete(long id) {
		Nota nota = notaRepository.findById(id);
		notaRepository.delete(nota);
	}
	
	public List<NotaDto> getAll(){
		List<Nota> notas = notaRepository.findAll();
		return converter.converterList(notas);
	}
	
	public NotaDto getByNombreAndTitulo(String nombre, String titulo) {
		Nota nota = notaRepository.findByNombreAndTitulo(nombre, titulo);
		return new NotaDto(nota);
	}
	
	public List<NotaDto> getByTitulo(String titulo){
		List<Nota> notas = notaRepository.findByTitulo(titulo);
		return converter.converterList(notas);
	}
	
	public List<NotaDto> getByPagination(Pageable pageable){
		List<Nota> notas = notaRepository.findAll(pageable).getContent();
		return converter.converterList(notas);
	}
}
