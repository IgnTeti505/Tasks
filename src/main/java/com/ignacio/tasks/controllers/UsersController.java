package com.ignacio.tasks.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ignacio.tasks.entity.Usuario;
import com.ignacio.tasks.service.UsuariosService;

@RestController
@RequestMapping(path = "/")
public class UsersController {
	
	@Autowired
	@Qualifier("UsuariosService")
	UsuariosService usuariosService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
	
	@RequestMapping(path = "usuario", method = RequestMethod.GET)
	public @ResponseBody 
	List<Usuario> listaUsuarios() {
		try {
			return usuariosService.listaUsuarios(1);
		} catch (Exception ex) {
			log.error("ERROR" + ex.getMessage());
			return null;
		}
	}

	@RequestMapping(path = "usuario", method = RequestMethod.POST)
	public @ResponseBody boolean registrarTarea(@RequestBody String tareaJSON) {
		System.out.println(tareaJSON);
		try {
			Usuario usuario = new Usuario();
			usuario = mapper.readValue(tareaJSON, Usuario.class);

			
			if (usuariosService.addUser(usuario)) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

	@RequestMapping(path = "usuario", method = RequestMethod.PUT)
	public @ResponseBody boolean actualizarTarea(@RequestBody String tareaJSON) {
		try {
			Usuario usuario = new Usuario();

			usuario = mapper.readValue(tareaJSON, Usuario.class);

			if (usuariosService.updateUser(usuario)) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

	@RequestMapping(path = "usuario", method = RequestMethod.DELETE)
	public @ResponseBody boolean borrarTarea(@RequestBody String tareaJSON) {
		try {
			if (tareaJSON != null) {
				Usuario usuario = mapper.readValue(tareaJSON, Usuario.class);
				return usuariosService.deleteUser(usuario);
			}
			return false;
		} catch (Exception ex) {
			System.out.println("ERROR borrando" + ex.getMessage());
			return false;
		}
	}


}
