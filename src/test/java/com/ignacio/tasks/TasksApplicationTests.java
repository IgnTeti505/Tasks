package com.ignacio.tasks;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ignacio.tasks.entity.Tarea;
import com.ignacio.tasks.service.TasksService;

@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = TasksApplication.class, loader = AnnotationConfigContextLoader.class)
@SpringBootTest
public class TasksApplicationTests {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Qualifier("TasksService")
	private TasksService service;

	@Test
	public void addTask() {
		try {
			Tarea tareas = new Tarea("java time x2", "java time Nota", Date.valueOf("2019-09-02") );
			if (service.addTask(tareas)) { 
				log.info("Se agrego la tarea correctamente: ");
			} else {
				log.warn("No fue posible agregar la tarea");
			}

		} catch (Exception e) {
			log.error("ERROR: " + e.getMessage());
		}
	}

	@Test
	public void deleteTareas() {
		try {
			Tarea tareas = service.getTask(2);
			if (service.deleteTask(tareas)) {
				log.info("Se borro la tarea :\n" + tareas.toString());
			} else {
				log.warn("No fue posible borrar la tarea ");
			}

		} catch (Exception e) {
			log.error("ERROR: " + e.getMessage());
		}
	}

	@Test
	public void updateTareas() {
//		try {
//			Tarea tareas = new Tarea(1, " edit", "edit", LocalDate.of(2019,8,9));
//
//			if (service.getTask(1) != null) {
//				service.updateTask(tareas);
//				log.info("Se actualizo la tarea correctamente :\n" + tareas.toString());
//			} else {
//				log.warn("No fue posible actualizar la tarea");
//			}
//		} catch (Exception e) {
//			log.error("ERROR: " + e.getMessage());
//		}
	}

	@Test
	public void Listar() {
		try {
			List<Tarea> tarea = new ArrayList<>();
			tarea = service.listaTareas();
			for (Tarea tar : tarea) {
				log.info(tar.toString());
			}
		} catch (Exception ex) {
			log.error("ERROR: " + ex.getMessage());
		}
	}

}
