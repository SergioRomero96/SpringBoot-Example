package com.restfull.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Table(name = "Nota")
@Entity
public class Nota implements Serializable{
	
	@GeneratedValue
	@Id
	@Column(name = "IdNota")
	private long id;
	@Column(name = "Nombre")
	private String nombre;
	@Column(name = "Titulo")
	private String titulo;
	@Column(name = "Contenido")
	private String contenido;
	
	public Nota() {
		
	}
	
	public Nota(long id, String nombre, String titulo, String contenido) {
		this.id = id;
		this.nombre = nombre;
		this.titulo = titulo;
		this.contenido = contenido;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	
}
