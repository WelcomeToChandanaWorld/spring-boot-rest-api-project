package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(
                1,
                "Reema",
                "Singh"
        );
        return student;
    }

    //http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Reema", "Singh"));
        students.add(new Student(2,"Patel", "Saab"));
        students.add(new Student(3,"Ghat","Rathod"));
        students.add(new Student(4,"Hema", "Pushkar"));
        return students;
    }

    //http://localhost:8080/students/1/Pardh/Sharma
    // {id} - URI template
    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable int id, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName){
       return new Student(id, firstName, lastName);
    }

}