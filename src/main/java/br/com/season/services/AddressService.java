/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.season.services;

import br.com.season.entities.Address;
import java.util.List;

/**
 *
 * @author dc01acjava6
 */
public interface AddressService {
    
    void save(Address address);
    
    List<Address> findAll();
    
}
