/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.season.main;

import br.com.season.config.SpringProjectConfig;
import br.com.season.services.HelloWorldService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 *
 * @author dc01acjava6
 */
public class SpringProjectMain {
    
    public static void main(String[] args){
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringProjectConfig.class);
		HelloWorldService hello = context.getBean(HelloWorldService.class);
                hello.sayHello("Léo");

		context.close();
	}
}
