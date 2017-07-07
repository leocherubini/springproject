/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.season.services;

import java.util.List;

import br.com.season.entities.User;
import br.com.season.generic.JPAGeneric;

/**
 *
 * @author dc01acjava6
 */
public interface UserService extends JPAGeneric<User> {
    
    User findByCpf(String cpf);

	List<User> findBy(String lastName, String firstName, String cpf);

	User findUsername(String username);
    
}
