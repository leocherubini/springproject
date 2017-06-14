/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.season.services;

import br.com.season.entities.Address;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    
    List<Address> addresses = new ArrayList<Address>();
    
    @Override
    public void save(Address address) {
        addresses.add(address);
    }

    @Override
    public List<Address> findAll() {
        return addresses;
    }
    
}
