package com.ignacio.tasks.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Column(name = "NOMBRE")
	private String nombre;

	@NotNull
	@Column(name = "USUARIO")
	private String usuario;

	@NotNull
	@Column(name = "CONTRASENIA")
	private String contrasenia;
	
	@NotNull
	@Column(name = "CORREO")
	private String correo;
	
	@NotNull
	@Column(name = "STATUS")
	private int status;
	
	public Usuario() { }
	

	public Usuario(String usuario, String contrasenia) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}


	public Usuario(String nombre, String usuario, String contrasenia, @NotNull @Size(min = 2, max = 120) String correo, @NotNull int status) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.correo = correo;
		this.status = status;
	}



	public Usuario(int id, String nombre, String usuario, String contrasenia, @NotNull @Size(min = 2, max = 120) String correo, @NotNull int status) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.correo = correo;
		this.status = status;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getContrasenia() {
		return contrasenia;
	}



	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", usuario=" + usuario + ", contrasenia=" + contrasenia
				+ ", correo=" + correo + ", status=" + status + "]";
	}




	
}
