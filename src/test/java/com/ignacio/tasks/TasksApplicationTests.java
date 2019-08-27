package com.ignacio.tasks;



import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.ignacio.tasks.Entity.Tarea;
import com.ignacio.tasks.Service.Implements.TasksService;

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TasksApplication.class, loader = AnnotationConfigContextLoader.class)
public class TasksApplicationTests {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("TasksService")
	private TasksService service;
	
	@Test
	public void agregarTareas() {
		try {
			Tarea tareas = new Tarea(1, "Titulo Nota", "Descripcion Nota", Date.valueOf("2019-08-27"));
			if(service.addTask(tareas)){
				log.info("Se agrego la tarea correctamente: ");
			} else {
				log.warn("No fue posible agregar la tarea");
			}
			
		}catch(Exception e) {
			
		}
	}

}
