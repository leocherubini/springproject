package br.com.season.daos;

import java.util.List;

import br.com.season.entities.User;

public interface UserDAO {

	User findById(Integer id);
	
	List<User> findAll();
	
	void save(User user);
	
	void update(User user);
	
	void delete(User user);
}
