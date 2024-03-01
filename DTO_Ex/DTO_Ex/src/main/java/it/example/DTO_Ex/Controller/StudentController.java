package it.example.DTO_Ex.Controller;

import it.example.DTO_Ex.DTO.StudentDTO;
import it.example.DTO_Ex.Entity.Student;
import it.example.DTO_Ex.Repository.StudentRepository;
import it.example.DTO_Ex.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){

        return studentService.create(student);

    }

    @GetMapping("/{id}")
    public StudentDTO getOneStudent(@PathVariable Long id){

        return studentService.getStudentById(id);

    }

    @GetMapping("/all")
    public List<StudentDTO> getAllStudents(){

        return studentService.getAll();

    }

    @PutMapping("/{id}")
    public Student modifyStudent(@PathVariable Long id ,@RequestBody Student student){

        return studentService.modifyStudent(id, student);

    }

    @DeleteMapping("/{id}")
    public void deleteOneStudent(@PathVariable Long id){

        studentService.deleteStudent(id);

    }
}
