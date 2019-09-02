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
import com.ignacio.tasks.entity.Tarea;
import com.ignacio.tasks.entity.Usuario;
import com.ignacio.tasks.service.TasksService;

@RestController
@RequestMapping(path = "/")
public class TasksController {

	@Autowired
	@Qualifier("TasksService")
	TasksService tasksService;

	private Logger log = LoggerFactory.getLogger(this.getClass());
	private ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
	
	@RequestMapping(path = "tarea", method = RequestMethod.GET)
	public @ResponseBody 
	List<Tarea> listaTareas() {
		try {
			return tasksService.listaTareas();
		} catch (Exception ex) {
			log.error("ERROR" + ex.getMessage());
			return null;
		}
	}
	
	@RequestMapping(path = "tareaUsuario", method = RequestMethod.GET)
	public @ResponseBody 
	List<Tarea> listaById(int id) {
		try {
			return tasksService.listaById(id);
		} catch (Exception ex) {
			log.error("ERROR" + ex.getMessage());
			return null;
		}
	}
	
//	@RequestMapping(path = "userTasks", method = RequestMethod.POST)
//	public @ResponseBody 
//	List<Tarea> listById(int usuarioId) {
//		try {
//			return tasksService.tasksById(usuarioId);
//		} catch (Exception ex) {
//			log.error("ERROR" + ex.getMessage());
//			return null;
//		}
//	}

	@RequestMapping(path = "tarea", method = RequestMethod.POST)
	public @ResponseBody boolean registrarTarea(@RequestBody String tareaJSON) {
		System.out.println(tareaJSON);
		try {
			Tarea tarea = new Tarea();
			tarea = mapper.readValue(tareaJSON, Tarea.class);

			
			if (tasksService.addTask(tarea)) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

	@RequestMapping(path = "tarea", method = RequestMethod.PUT)
	public @ResponseBody boolean actualizarTarea(@RequestBody String tareaJSON) {
		try {
			Tarea tarea = new Tarea();

			tarea = mapper.readValue(tareaJSON, Tarea.class);

			if (tasksService.updateTask(tarea)) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

	@RequestMapping(path = "tarea", method = RequestMethod.DELETE)
	public @ResponseBody boolean borrarTarea(@RequestBody String tareaJSON) {
		try {
			if (tareaJSON != null) {
				Tarea tarea = mapper.readValue(tareaJSON, Tarea.class);
				return tasksService.deleteTask(tarea);
			}
			return false;
		} catch (Exception ex) {
			System.out.println("ERROR borrando" + ex.getMessage());
			return false;
		}
	}
}