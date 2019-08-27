package com.ignacio.tasks.Service.Implements;

import java.util.List;

import com.ignacio.tasks.Entity.Tarea;

public interface TasksService {

	public boolean addTask(Tarea tarea);
    public boolean updateTask(Tarea tarea);
    public boolean deleteTask(Tarea tarea);
    public Tarea getTask(int taskID);
    public List<Tarea> listaArchivos();
    
    	
}
