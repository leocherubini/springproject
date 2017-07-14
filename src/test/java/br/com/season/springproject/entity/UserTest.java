package br.com.season.springproject.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.season.daos.UserDAO;
import br.com.season.entities.User;
import br.com.season.springproject.config.TestJPAContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestJPAContextConfiguration.class})
@Transactional
@Rollback
public class UserTest {
	
	@Autowired
	private UserDAO dao;
	
	private User user;
	
	@Before
	public void before() {
		user = new User();
		user.setLastName("Teste");
		user.setFirstName("Teste");
		user.setCpf("12345");
		user.setUsername("teste");
		
		dao.save(user);
	}
	
	@Test
	public void should_save_new_user() {	
		assertNotNull(user.getId());
	}
	
	@Test
	public void verify_name_user() {
		assertEquals("Teste", user.getFirstName());
	}
	
	@Test
	public void find_user_by_cpf() {
		User userTest = dao.findByCpf("12345");
		assertEquals("teste", userTest.getUsername());
	}
	
	@Test
	public void find_all_users_with_findBy() {
		List<User> users = dao.findBy("Teste", "Teste", "12345");
		
		assertEquals(1, users.size());
	}
	
	@Test
	public void find_all_users() {
		User newUser = new User();
		newUser.setLastName("Teste2");
		newUser.setFirstName("Teste2");
		newUser.setCpf("123452");
		newUser.setUsername("teste2");
		
		dao.save(newUser);
		
		List<User> users = dao.findAll();
		
		assertEquals(2, users.size());
	}
	
}
