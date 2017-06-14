/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.season.controllers;

import br.com.season.entities.Address;
import br.com.season.services.AddressService;
import br.com.season.services.AddressServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddressesController {

    @Autowired
    private AddressService addressService;
    
    @RequestMapping("/address")
    public String address(ModelMap map) {
        Address address = new Address();
        List<Address> addresses = new ArrayList<Address>();
        
        map.addAttribute("address", address);
        map.addAttribute("address", addresses);
        return "address";
    }

    @RequestMapping("/address/save")
    public String save(Address address, ModelMap map) {
        System.out.println("City: " + address.getCity());
        System.out.println("Street: " + address.getStreet());
        System.out.println("Number: " + address.getNumber());

        address = new Address();
        map.addAttribute("address", address);

        return "address";
    }
}
