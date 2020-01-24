package com.restfull.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restfull.core.dto.NotaDto;
import com.restfull.core.entity.Nota;
import com.restfull.core.service.INotaService;

@RestController
@RequestMapping("/api")
public class NotaController {
	@Autowired
	@Qualifier("NotaService")
	private INotaService notaService;

	@PostMapping("/notas/new")
	public NotaDto add(@RequestBody Nota nota) {
		return notaService.add(nota);
	}
	
	@PutMapping("/notas/{id}")
	public NotaDto update(@RequestBody Nota nota, @PathVariable("id") long id) {
		nota.setId(id);
		return notaService.update(nota);
	}
	
	//"/notas/{id}/{nombre}"
	@DeleteMapping("/notas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") long id) {
		notaService.delete(id);
	}
	
	@GetMapping("/notas/all")
	public List<NotaDto> getNotas(){
		return notaService.getAll();
	}
	
	@GetMapping("/notas")
	public List<NotaDto> getNotas(Pageable pageable){
		return notaService.getByPagination(pageable);
	}
	
	
}
