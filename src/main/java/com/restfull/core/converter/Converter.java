package com.restfull.core.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restfull.core.dto.NotaDto;
import com.restfull.core.entity.Nota;

@Component("converter")
public class Converter {
	public List<NotaDto> converterList(List<Nota> notas){
		List<NotaDto> notasDtos = new ArrayList<>();
		for(Nota nota : notas) {
			notasDtos.add(new NotaDto(nota));
		}
		return notasDtos;
	}
}
