/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.season.services;

import br.com.season.entities.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    List<User> users = new ArrayList<User>();
    
    @Override
    public User findById(Integer id) {
        User found = new User();
        found.setId(id);
        List<User> list = findAll();
        
        if(list.contains(found)) {
            found = list.get(list.indexOf(found));
        }
        
        return found;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public User update(Integer userId, User user) {
        User foundUser = findById(userId);
        BeanUtils.copyProperties(user, foundUser, "id");

        return foundUser;
    }
    
}
