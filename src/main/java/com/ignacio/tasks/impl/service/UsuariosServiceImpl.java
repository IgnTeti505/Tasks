package com.ignacio.tasks.impl.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignacio.tasks.entity.Usuario;
import com.ignacio.tasks.repository.UsersRepository;
import com.ignacio.tasks.service.UsuariosService;

@Service("UsuariosService")
public class UsuariosServiceImpl implements UsuariosService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public UsersRepository usersRepository;
	
	@Override
	public List<Usuario> listaUsuarios(int status) {

		try {
			log.info("Lista de ususarios\n");
			return (List<Usuario>) usersRepository.findAll();
		} catch (Exception ex) {
			log.error("ERROR: " + ex.getMessage());
		}
		return null;
	}

	@Override
	public boolean addUser(Usuario usuario) {
		try {
			if (usuario != null) {
				usersRepository.save(usuario);
				log.info("Se agrego el usuario: " + usuario.toString());
				return true;
			}
			log.warn("usuario vacio");
			return false;
		} catch (Exception ex) {
			log.error("ERROR:  " + ex.getMessage());
			return false;
		}

	}

	@Override
	public boolean updateUser(Usuario usuario) {
		try {
			if (usuario != null) {
				usersRepository.save(usuario);
				log.info("Se actualizo el archivo: " + usuario.toString());
				return true;
			}
			log.warn("El archivo vacio");
			return false;
		} catch (Exception ex) {
			log.error("ERROR: " + ex.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteUser(Usuario usuario) {
		try {
			if (usuario != null) {
				usersRepository.save(usuario);
				log.info("Se borro la tarea correctamente");
				return true;
			}
			log.warn("Tarea vacia");
			return false;
		} catch (Exception ex) {
			log.error("ERROR: " + ex.getMessage());
			return false;
		}
	}

//	@Override
//	public Usuario getUser(int usuarioID) {
//		try {
//			if (usuarioID > 0) {
//				log.info("Se consulto: ID: " + usuarioID);
//				return usersRepository.findById(usuarioID).get(usuarioID);
//			}
//			return null;
//		} catch (Exception ex) {
//			log.error("ERROR: " + ex.getMessage());
//			return null;
//		}
//	}
	

	@Override
	public Usuario login(Usuario usuario) {
			try {
				if(usuario != null) {
				Usuario user =	usersRepository.login(usuario.getUsuario());
					log.info("se encontrooooo: " + usuario.toString());
					log.info("USER: " + user);
					if(user.getContrasenia().equals(usuario.getContrasenia())) {
						return user;
					} else {
						log.info("NO RETURN");
					}
	                
				}
				return null;
			}catch(Exception ex) {
				return null;
			}
		}

}
