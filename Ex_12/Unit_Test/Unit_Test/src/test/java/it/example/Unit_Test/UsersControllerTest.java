package it.example.Unit_Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.example.Unit_Test.Controller.UsersController;
import it.example.Unit_Test.Entity.Users;
import it.example.Unit_Test.Repository.UsersRepository;
import it.example.Unit_Test.Service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest//(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles(value = "test")
class UsersControllerTest {

	@Autowired
	private UsersController usersController;

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() { assertThat(usersController).isNotNull(); }

	@Test
	public void createUser() throws Exception{

		Users users = new Users(1L, "pippo", "bianchi", 22);

		mockMvc.perform(post("/users/new").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(users)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.name").value("pippo"))
				.andExpect(jsonPath("$.surname").value("bianchi"))
				.andExpect(jsonPath("$.age").value(22));

	}

	@Test
	public void getUserById() throws Exception {

		Users users = new Users(1L, "pippo", "bianchi", 22);
		Users userSaved = usersRepository.save(users);

		mockMvc.perform(get("/users/{id}", users.getId()))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(users.getId()));

	}

	@Test
	public void updateUser() throws Exception {

		Users users = new Users(1L, "pippo", "bianchi", 22);
		Users userSaved = usersRepository.save(users);

		Users usersTwo = new Users(1L, "matteo", "bianchi", 24);

		mockMvc.perform(put("/users/update/{id}", users.getId())
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(usersTwo)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(userSaved.getId()))
				.andExpect(jsonPath("$.name").value("matteo"))
				.andExpect(jsonPath("$.surname").value("bianchi"))
				.andExpect(jsonPath("$.age").value(24));

	}

	@Test
	public void deleteUserById() throws Exception {

		Users users = new Users(1L, "pippo", "bianchi", 22);
		Users userSaved = usersRepository.save(users);

		mockMvc.perform(delete("/users/delete/{id}", userSaved.getId()))
				.andExpect(status().isOk());

		mockMvc.perform(get("/users/{id}", userSaved.getId()))
				.andExpect(status().isOk());

	}

}
