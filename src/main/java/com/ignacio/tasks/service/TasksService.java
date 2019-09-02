package com.ignacio.tasks.service;

import java.util.List;

import com.ignacio.tasks.entity.Tarea;
import com.ignacio.tasks.entity.Usuario;

public interface TasksService {

	public boolean addTask(Tarea tarea);
    public boolean updateTask(Tarea tarea);
    public boolean deleteTask(Tarea tarea);
    public Tarea getTask(int taskID);
    public List<Tarea> listaTareas();
    
//    public List<Tarea> tasksById(int id);
    public List<Tarea> listaById(int id);

}
