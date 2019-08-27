package com.ignacio.tasks.Implements;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.ignacio.tasks.Service.Implements.TasksService;


@Service("TasksService")
public class TasksServiceImpl implements TasksService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ArchivosRepository archivosRepository;

    @Override
    public boolean agregarArchivo(Archivos archivo)
    {
        try
        {
          if (archivo != null)
            {
                archivosRepository.save(archivo);
                log.info("Se agrego el archivo: "+archivo.toString());
                return true;
            }
            log.warn("El archivo vacio");
            return false;
        }
        catch (Exception ex)
        {
            log.error("ERROR:  "+ex.getMessage());
            return false;
        }

    }

    @Override
    public boolean actualizarArchivo(Archivos archivo)
    {
        try
        {
            if (archivo != null)
            {
                archivosRepository.save(archivo);
                log.info("Se actualizo el archivo: "+archivo.toString());
                return true;
            }
            log.warn("El archivo vacio");
            return false;
        }
        catch (Exception ex)
        {
            log.error("ERROR: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean borrarArchivo(Archivos archivo)
    {
        try
        {
            if (archivo != null)
            {
                archivosRepository.delete(archivo);
                log.info("Se borro el archivo correctamente");
                return true;
            }
            log.warn("El archivo vacio");
            return false;
        }
        catch (Exception ex)
        {
            log.error("ERROR: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public Archivos obtenerArchivo(int archivoID)
    {
        try {
            if (archivoID > 0)
            {
                log.info("Se consulto: ID: "+archivoID);
                return archivosRepository.findById(archivoID).get();
            }
            return null;
        }
        catch (Exception ex)
        {
            log.error("ERROR: "+ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Archivos> listaArchivos()
    {

        try
        {
            log.info("Lista de archivos\n");
            return (List<Archivos>) archivosRepository.findAll();
        }
        catch (Exception ex)
        {
            log.error("ERROR: "+ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Archivos> listarArchivosPorTipo(String tipoArchivo)
    {
        try {

            if (tipoArchivo != null)
            {
                log.info("Se recibio "+tipoArchivo);
                return archivosRepository.listarArchivosPorTipo(tipoArchivo);
            }
            log.warn("Tipo vacio");
            return null;
        }
        catch (Exception ex)
        {
            log.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public int CantidadDeArchivos(String tipo)
    {
        try {

            if (tipo != null)
            {
                log.info("Se recibio "+tipo);
                return archivosRepository.CantidadDeCadaTipo(tipo);
            }
            log.warn("Tipo vacio");
            return 0;
        }
        catch (Exception ex)
        {
            log.error(ex.getMessage());
            return 0;
        }
    }
	
}
