package it.garbi.consuntivo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.garbi.consuntivo.entities.User;


public interface UserDao extends JpaRepository<User, Integer>{

	Optional<User> findById(Integer id);

}
