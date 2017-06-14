/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.season.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String index() {
        return "home";
    }
    
    @RequestMapping("/test")
    public String getId(@RequestParam("id") String id, ModelMap map) {
        map.addAttribute("id", id);
        
        return "home";
    }
    
    @RequestMapping("/hello")
    public String hello(@RequestHeader("User-Agent") String agent,
        @RequestHeader(value = "Accept") String accept, ModelMap map) {
        
        map.addAttribute("agent", agent);
        map.addAttribute("accept", accept);
        
        return "home";
    }
    
}
