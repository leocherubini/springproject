/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.season.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.http.HttpStatus;

@Entity
public class Product {
    HttpStatus status;
    @Id
    private Integer id;

    private String productName;
    private Double productPrice;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

}
