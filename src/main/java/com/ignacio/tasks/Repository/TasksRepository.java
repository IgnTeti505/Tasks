package com.ignacio.tasks.Repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ignacio.tasks.Entity.Tarea;

@Repository("TasksRepository")
public interface TasksRepository extends CrudRepository<Tarea, Serializable> {


}
