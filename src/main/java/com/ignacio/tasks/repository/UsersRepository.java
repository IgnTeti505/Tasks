package com.ignacio.tasks.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ignacio.tasks.entity.Usuario;

@Repository("UsersRepository")
public interface UsersRepository extends CrudRepository<Usuario, Serializable> {
	List<Usuario> findByStatus(int status);
}
