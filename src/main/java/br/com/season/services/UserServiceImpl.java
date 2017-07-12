/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.season.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.season.daos.UserDAO;
import br.com.season.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User findById(Integer id) {
		return userDAO.findById(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	@Override
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userDAO.save(user);
	}

	@Override
	public User update(User user) {
		userDAO.update(findById(user.getId()));
		return user;
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByCpf(String cpf) {
		// TODO Auto-generated method stub
		return userDAO.findByCpf(cpf);
	}
	
	@Override
	public List<User> findBy(String lastName, String firstName, String cpf) {

		return userDAO.findBy(lastName,firstName,cpf);
	}

	@Override
	public User findUsername(String username) {		
		return userDAO.findUsername(username);
	}
    
//    @Override
//    public User findById(Integer id) {
//        return userDAO.findById(id);
//    }
//
//    @Override
//    public List<User> findAll() {
//        return users;
//    }
//
//    @Override
//    public void save(User user) {
//        userDAO.save(user);
//    }
//
//    @Override
//    public User update(Integer userId, User user) {
//        User foundUser = findById(userId);
//        BeanUtils.copyProperties(user, foundUser, "id");
//        userDAO.update(foundUser);
//        return foundUser;
//    }
//
//	@Override
//	public void delete(User user) {
//		userDAO.delete(user);		
//	}
    
}
