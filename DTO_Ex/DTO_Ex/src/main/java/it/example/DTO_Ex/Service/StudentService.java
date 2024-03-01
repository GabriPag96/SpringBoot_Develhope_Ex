package it.example.DTO_Ex.Service;

import it.example.DTO_Ex.DTO.StudentDTO;
import it.example.DTO_Ex.Entity.Student;
import it.example.DTO_Ex.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student create(Student student){

        return studentRepository.save(student);

    }

    public StudentDTO getStudentById(Long id){

        Student student = studentRepository.findById(id).orElse(null);

        return convertStudentDTO(student);
    }

    public List<StudentDTO> getAll(){

        List<Student> students = studentRepository.findAll();

        List<StudentDTO> studentDTOS = new ArrayList<>();

        for (Student student : students){

            studentDTOS.add(convertStudentDTO(student));

        }
        return studentDTOS;
    }

    public Student modifyStudent(Long id, Student student){

        Student student1 = studentRepository.findById(id).orElse(null);

        if (student1 != null){

            student1.setName(student.getName());
            student1.setMail(student.getMail());
            student1.setAge(student.getAge());

            studentRepository.save(student1);
        }

        return student1;
    }

    public void deleteStudent(Long id){

        studentRepository.deleteById(id);

    }

    public StudentDTO convertStudentDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setName(student.getName());
        studentDTO.setMail(student.getMail());

        return studentDTO;
    }
}
