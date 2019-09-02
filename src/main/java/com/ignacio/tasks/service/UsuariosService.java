package com.ignacio.tasks.service;

import java.util.List;

import com.ignacio.tasks.entity.Usuario;

public interface UsuariosService {
	public boolean addUser(Usuario usuario);
    public boolean updateUser(Usuario usuario);
    public boolean deleteUser(Usuario usuario);
    List<Usuario> listaUsuarios(int status);
    
    
    public Usuario login(Usuario usuario);
//    List<Usuario> findByStatus(int status);
    
//    public Usuario getUser(int userId);	

}
