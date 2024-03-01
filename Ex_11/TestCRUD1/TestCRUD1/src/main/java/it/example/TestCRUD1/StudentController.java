package it.example.TestCRUD1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @PostMapping("/newstudent")
    public @ResponseBody Student create(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping("/studentlist")
    public @ResponseBody List<Student> getList(){
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Student getOne(@PathVariable Long id){
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    @PutMapping("/{id}")
    public @ResponseBody Student changeParam(@PathVariable Long id, @RequestBody @NonNull Student student){

        if (studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return studentRepository.save(student);

        }else{return null;}

    }

    @PutMapping("/{id}/working")
    public @ResponseBody Student changeIsWorking(@PathVariable Long id,@RequestParam("working") boolean isWorking){
        return studentService.setStudentIsWorkingStatus(id, isWorking);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Long id){
        studentRepository.deleteById(id);
    }

}
