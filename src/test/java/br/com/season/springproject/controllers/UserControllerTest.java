package br.com.season.springproject.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.season.controllers.UsersController;
import br.com.season.entities.User;
import br.com.season.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	private static String ENDPOINT = "/user";
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private UsersController controller;
	
	private UserService userService;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void should_save_user() throws Exception {
		User user = new User();
		user.setLastName("Teste");
		user.setFirstName("Teste");
		user.setUsername("teste");
		user.setCpf("12345");
		user.setPassword("season");
		
		mockMvc.perform(post(ENDPOINT)
				.content(toJson(user))).andExpect(status().isOk());
	}
	
	private byte[] toJson(Object object) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsBytes(object);
	}
}
