package com.ignacio.tasks.impl.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignacio.tasks.entity.Tarea;
import com.ignacio.tasks.repository.TasksRepository;
import com.ignacio.tasks.service.TasksService;

@Service("TasksService")
public class TasksServiceImpl implements TasksService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public TasksRepository tasksRepository;

	@Override
	public boolean addTask(Tarea tarea) {
		try {
			if (tarea != null) {
				tasksRepository.save(tarea);
				log.info("Se agrego la tarea: " + tarea.toString());
				return true;
			}
			log.warn("nota vacia");
			return false;
		} catch (Exception ex) {
			log.error("ERROR:  " + ex.getMessage());
			return false;
		}

	}

	@Override
	public boolean updateTask(Tarea tarea) {
		try {
			if (tarea != null) {
				tasksRepository.save(tarea);
				log.info("Se actualizo el archivo: " + tarea.toString());
				return true;
			}
			log.warn("El archivo vacio");
			return false;
		} catch (Exception ex) {
			log.error("ERROR: " + ex.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteTask(Tarea tarea) {
		try {
			if (tarea != null) {
				tasksRepository.delete(tarea);
				log.info("Se borro la tarea correctamente");
				return true;
			}
			log.warn("Tarea vacia");
			return false;
		} catch (Exception ex) {
			log.error("ERROR: " + ex.getMessage());
			return false;
		}
	}

	@Override
	public Tarea getTask(int archivoID) {
		try {
			if (archivoID > 0) {
				log.info("Se consulto: ID: " + archivoID);
				return tasksRepository.findById(archivoID).get();
			}
			return null;
		} catch (Exception ex) {
			log.error("ERROR: " + ex.getMessage());
			return null;
		}
	}

	@Override
	public List<Tarea> listaTareas() {

		try {
			log.info("Lista de archivos\n");
			return (List<Tarea>) tasksRepository.findAll();
		} catch (Exception ex) {
			log.error("ERROR: " + ex.getMessage());
		}
		return null;
	}

}
