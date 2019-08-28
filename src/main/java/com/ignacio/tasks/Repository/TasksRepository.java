package com.ignacio.tasks.Repository;

import com.ignacio.tasks.Entity.Tarea;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("TasksRepository")
public interface TasksRepository extends CrudRepository<Tarea, Serializable> {

//	@Query(value = "SELECT * FROM Tareas WHERE Tipo = :tipo",nativeQuery = true)
//	public List<Tarea> listarArchivosPorTipo(@Param("tipo") String tipoArchivo);
//	
//	@Query(value = "SELECT count(tipo) FROM Tareas WHERE Tipo= :tipo",nativeQuery = true)
//	public int CantidadDeCadaTipo(@Param("tipo") String CantidadDeContenido);
}
