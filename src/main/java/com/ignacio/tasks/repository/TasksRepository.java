package com.ignacio.tasks.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ignacio.tasks.entity.Tarea;

@Repository("TasksRepository")
public interface TasksRepository extends CrudRepository<Tarea, Serializable> {
	
//	@Query(value = "SELECT * FROM tasks WHERE id_usuario = :id", nativeQuery = true)
//	public Usuario tasksById(@Param("id") int id);
	
	List <Tarea> findByUsuario_Id(int id);

}
