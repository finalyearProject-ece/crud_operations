package com.example.ProjectK1.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectK1.Model.Student;
import com.example.ProjectK1.Service.StudentService;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/get")
    public ResponseEntity<?> getall(){
        return new ResponseEntity<>(studentService.get(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<?> add(@RequestBody Student student){
        studentService.save(student);
         return new ResponseEntity<>("Saved", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
       public ResponseEntity<?> add(@PathVariable("id") Long id,@RequestBody Student student){
        studentService.update(id,student);
        return new ResponseEntity<>("Saved", HttpStatus.OK);
       }

       @DeleteMapping("/Delete/{id}")
       public ResponseEntity<?> delete(@PathVariable("id") Long id){
        studentService.delete(id);
         return new ResponseEntity<>("Deleted", HttpStatus.OK);
       }
    @GetMapping("getby/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
       Optional<Student> list =  studentService.getById(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
