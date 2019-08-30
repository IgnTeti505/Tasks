package com.ignacio.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ignacio.tasks.entity.Usuario;
import com.ignacio.tasks.service.UsuariosService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuariosApplicationTests {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Qualifier("UsuariosService")
	private UsuariosService service;
	
	@Test
    public void login() {
        try{
            Usuario usuario = new Usuario("igo","pass");
        	
            if (service.login(usuario) != null){
                log.info("ingreso");
            }else{
                log.warn("no se encontro");
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
    }

	@Test
	public void addUsuario() {
		try {
			Usuario usuarios= new Usuario("Ignacio", "IgnTeti505", "pass", "igna-199@hotmail.com",  1);
			if (service.addUser(usuarios)) { 
				log.info("Se agrego el usuario correctamente: ");
			} else {
				log.warn("No fue posible agregar el usuario");
			}

		} catch (Exception e) {
			log.error("ERROR: " + e.getMessage());
		}
	}

	@Test
	public void deleteUsuarios() {
		try {
			Usuario usuarios = service.getUser(2);
			if (service.deleteUser(usuarios)) {
				log.info("Se borro el usario:\n" + usuarios.toString());
			} else {
				log.warn("No fue posible borrar el usario");
			}

		} catch (Exception e) {
			log.error("ERROR: " + e.getMessage());
		}
	}
}
