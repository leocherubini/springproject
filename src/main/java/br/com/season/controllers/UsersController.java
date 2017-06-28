/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.season.controllers;

import br.com.season.entities.User;
import br.com.season.services.UserService;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
        User found = new User();
        found.setId(userId);
        List<User> list = userService.findAll();
        
        if(list.contains(found)) {
            found = list.get(list.indexOf(found));
        }
        
        map.addAttribute("user", found);
        map.addAttribute("users", list);
        return "users";
    }
    
    @RequestMapping(value="/{userId}", method=RequestMethod.PUT)
    public ModelAndView update(@PathVariable("userId") Integer userId, User user) {
        ModelAndView view = new ModelAndView("user");
        user = userService.update(userId, user);
        view.addObject("user", user);
        
        return view;
    }
}
