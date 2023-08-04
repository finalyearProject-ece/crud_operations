package com.example.ProjectK1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProjectK1.Model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
    
}
