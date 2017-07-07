/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.season.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.season.entities.User;
import br.com.season.services.UserService;

@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView users(ModelMap map) {
        ModelAndView model = new ModelAndView("users");
        User user = new User();
        List<User> users = userService.findAll();
        map.addAttribute("user", user);
        map.addAttribute("users", users);
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(User user, ModelMap map) {
        userService.save(user);

        user = new User();
        map.addAttribute("user", user);
        map.addAttribute("users", userService.findAll());

        return "users";
    }
    
//    @RequestMapping(value="/{userId}", method=RequestMethod.GET)
//    public String getById(@PathVariable("userId") Integer userId, ModelMap map) {
//        User found = new User();
//        found.setId(userId);
//        List<User> list = userService.findAll();
//        
//        if(list.contains(found)) {
//            found = list.get(list.indexOf(found));
//        }
//        
//        map.addAttribute("user", found);
//        map.addAttribute("users", list);
//        return "users";
//    }
    
    @RequestMapping
    public String getById(@RequestParam("userId") Integer userId, ModelMap map) {
        User found = userService.findById(userId);
        List<User> list = userService.findAll();
        
        map.addAttribute("user", found);
        map.addAttribute("users", list);
        return "users";
    }
    
    @RequestMapping("/find-by")
    public String findBy(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName,
    		@RequestParam("cpf") String cpf, ModelMap map) {

    	List<User> users = userService.findBy(lastName, firstName, cpf);
    	map.addAttribute("user", new User());
    	map.addAttribute("users", users);
    	return "users";
    }
    
    @RequestMapping(value="/{userId}", method=RequestMethod.PUT)
    public ModelAndView update(@PathVariable("userId") Integer userId, User user) {
        ModelAndView view = new ModelAndView("user");
        User foundUser = userService.findById(userId);
        BeanUtils.copyProperties(user, foundUser, "id");
        foundUser = userService.update(foundUser);
        view.addObject("user", user);
        
        return view;
    }
    
    @RequestMapping("/getCpf/{cpf}")
    public @ResponseBody User findByCpf(@PathVariable String cpf) {
    	return userService.findByCpf(cpf);
    }

    @RequestMapping("/delete/{userId}")
    public String delete(@PathVariable("userId") Integer userId, ModelMap map) {

    	User found = userService.findById(userId);
    	if (found != null) {
    		userService.delete(found);
    	}
    	map.addAttribute("user", new User());
    	map.addAttribute("users", userService.findAll());
    	return "users";
    }
}
