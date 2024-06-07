package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    //http://localhost:8080/student
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "Reema",
                "Singh"
        );
        return ResponseEntity.ok()
                .header("custom-header", "chandana")
                .body(student);
    }

    //http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Reema", "Singh"));
        students.add(new Student(2,"Patel", "Saab"));
        students.add(new Student(3,"Ghat","Rathod"));
        students.add(new Student(4,"Hema", "Pushkar"));
        return ResponseEntity.ok(students);
    }

    //http://localhost:8080/students/1/Pardh/Sharma
    // {id} - URI template
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable int id, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName){
       Student student = new Student(id, firstName, lastName);
       return ResponseEntity.ok(student);
    }

    //http://localhost:8080/students/query?id=1&firstName=Reema&lastName=Singh
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestParam(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);

    }

    //http://localhost:8080/student/create
    @PostMapping("/student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //http://localhost:8080/student/1/update
    @PutMapping("/student/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //http://localhost:8080/student/3/delete
    @DeleteMapping("/student/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        return ResponseEntity.ok("Student deleted successfully");
    }

}
