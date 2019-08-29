package com.ignacio.tasks.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tasks")
public class Tarea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Column(name = "TITULO")
	private String titulo;

	@NotNull
	@Column(name = "DESCRIPCION")
	private String descripcion;

	@NotNull
	@Column(name = "FECHA")
	@Temporal(TemporalType.DATE)

	private LocalDate fecha;

	public Tarea() { }
	
	public Tarea(String titulo, String descripcion, LocalDate fecha) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}
	
	public Tarea(int id, @NotNull @Size(min = 2, max = 120) String titulo, String descripcion, @NotNull LocalDate fecha) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "Tearea [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fecha=" + fecha + "]";
	}
	
}
