package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> getAll() {
        return repo.findByIsDeletedFalse();
    }

    public Student getById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student create(Student s) {
        return repo.save(s);
    }

    public Student update(Integer id, Student s) {
        Student old = repo.findById(id).orElseThrow();
        old.setName(s.getName());
        old.setEmail(s.getEmail());
        old.setAge(s.getAge());
        return repo.save(old);
    }

    public Student patch(Integer id, Map<String, Object> data) {
        Student s = repo.findById(id).orElseThrow();

        if (data.containsKey("name"))
            s.setName((String) data.get("name"));

        if (data.containsKey("email"))
            s.setEmail((String) data.get("email"));

        if (data.containsKey("age"))
            s.setAge((Integer) data.get("age"));

        return repo.save(s);
    }

    public void delete(Integer id) {
        Student s = repo.findById(id).orElseThrow();
        s.setIsDeleted(true);
        repo.save(s);
    }
}
