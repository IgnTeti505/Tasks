package com.ignacio.tasks.service;

import java.util.List;

import com.ignacio.tasks.entity.Tarea;

public interface TasksService {

	public boolean addTask(Tarea tarea);
    public boolean updateTask(Tarea tarea);
    public boolean deleteTask(Tarea tarea);
    public Tarea getTask(int taskID);
    public List<Tarea> listaTareas();
    
    	
}
