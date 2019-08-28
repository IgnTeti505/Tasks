package com.ignacio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ignacio.tasks.Entity.Tarea;
import com.ignacio.tasks.Service.TasksService;

@RestController
@RequestMapping(path = "/")
public class TasksController {

	@Autowired
	@Qualifier("TasksService")
	TasksService tasksService;

	ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

	@RequestMapping(path = "tarea", method = RequestMethod.POST)
	public @ResponseBody boolean registrarTarea(@RequestBody String tareaJSON) {
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
			return false;
		}
	}

	@RequestMapping(path = "tarea", method = RequestMethod.GET)
    public @ResponseBody
    List<Tarea> listaTareas() {
        try {
                return tasksService.listaTareas();
        }
        catch (Exception ex) {
            return null;
        }
	}
}