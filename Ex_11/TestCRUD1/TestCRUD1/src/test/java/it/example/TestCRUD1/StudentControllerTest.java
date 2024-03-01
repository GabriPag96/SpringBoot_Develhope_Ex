package it.example.TestCRUD1;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
class StudentControllerTest {

	@Autowired
	private StudentController studentController;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	void contextLoad(){assertThat(studentController).isNotNull();}

	private Student createStudent() throws Exception {

		Student student = new Student(1L, "Mario", "Rossi", false);

		String studentJSON = objectMapper.writeValueAsString(student);

		MvcResult result = this.mockMvc.perform(post("/student/newstudent")
				.contentType(MediaType.APPLICATION_JSON).content(studentJSON))
				.andExpect(status().isOk()).andReturn();

		return objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);

	}

	private Student getStudentById(Long id) throws Exception   {

		MvcResult result = this.mockMvc.perform(get("/student/"+id))
				.andDo(print()).andExpect(status().isOk()).andReturn();

		return objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
	}

	@Test
	void  createStudentTest() throws Exception{

		Student student  = createStudent();

		assertThat(student.getId()).isNotNull();

	}

	@Test
	void studentById() throws Exception{

		Student student = createStudent();
		assertThat(student.getId()).isNotNull();

		Student studentResponse = getStudentById(student.getId());
		assertThat(studentResponse.getId()).isEqualTo(student.getId());

	}

	@Test
	void updateStudent() throws Exception{

		Student student1 = createStudent();
		Student student2 = new Student(2L, "Pippo", "Baudo" ,true);

		assertThat(student1.getId()).isNotNull();
		assertThat(student2.getId()).isNotNull();

		MvcResult result = this.mockMvc.perform(put("/student/"+student1.getId())
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(student2)))
				.andDo(print()).andExpect(status().isOk()).andReturn();

		Student studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
		assertThat(studentFromResponse).isNotNull();
		assertThat(studentFromResponse.getId()).isEqualTo(student2.getId());

	}

	@Test
	void deleteStudentById() throws Exception{

		Student student =  createStudent();
		assertThat(student.getId()).isNotNull();

		this.mockMvc.perform(delete("/student/" + student.getId()))
				.andDo(print()).andExpect(status().isOk()).andReturn();

//		Student studentFromResponse = getStudentById(student.getId());
//		assertThat(student).isNull();
		assertThatNullPointerException();

	}

	@Test
	void updateWorking() throws Exception {

		Student student =  createStudent();
		assertThat(student.getId()).isNotNull();

		MvcResult result = this.mockMvc.perform(put("/student/"+student.getId()+"/working?working=true"))
				.andDo(print()).andExpect(status().isOk()).andReturn();

		Student studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
		assertThat(studentFromResponse.getId()).isEqualTo(student.getId());
		assertThat(studentFromResponse.isWorking()).isEqualTo(true);

	}
//	@Test
//	void createStudent() throws Exception {
//		Student student = new Student();
//		student.setWorking(true);
//		student.setName("Carlo");
//		student.setSurname("Verdi");
//
//		String studentJSON = objectMapper.writeValueAsString(student);
//
//		MvcResult result = this.mockMvc.perform(post("/student/newstudent")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(studentJSON)).andDo(print())
//				.andExpect(status().isOk()).andReturn();
//
//		Student studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
//		assertThat(studentFromResponse.getId()).isNotNull();
//	}
//
//	@Test
//	void readStudentList() throws Exception {
//		createStudent();
//
//		MvcResult result = this.mockMvc.perform(get("/student/studentlist"))
//				.andDo(print())
//				.andExpect(status().isOk())
//				.andReturn();
//
//		List<Student> studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), List.class);
//		assertThat(studentFromResponse.size()).isNotZero();
//	}

}
