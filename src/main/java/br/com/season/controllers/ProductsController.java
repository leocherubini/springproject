/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.season.controllers;

import br.com.season.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ProductsController {

	@RequestMapping("/products")
	public String products(ModelMap map){
		Product product = new Product();
		map.addAttribute("product",product);
		
		return "products";
	}
	
	@RequestMapping("/product/save")
	public String save(Product product, ModelMap map){
		System.out.println("Product name: " + product.getProductName());
		System.out.println("Price: " + product.getProductPrice());
		
		product = new Product();
		map.addAttribute("product",product);
		
		return "products";
	}

}
