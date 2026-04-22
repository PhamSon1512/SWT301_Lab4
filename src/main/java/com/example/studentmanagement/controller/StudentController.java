package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // GET /api/students: Lấy list toàn bộ Student
    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    // GET /api/students/{id}: Lấy Student theo id
    @GetMapping("/{id}")
    public Student getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    // POST /api/students: Tạo mới Student
    @PostMapping
    public Student create(@RequestBody Student s) {
        return service.create(s);
    }

    // PUT /api/students/{id}: Cập nhật toàn bộ thông tin Student theo id
    @PutMapping("/{id}")
    public Student update(@PathVariable Integer id, @RequestBody Student s) {
        return service.update(id, s);
    }

    // PATCH /api/students/{id}: Cập nhật 1 phần thông tin Student theo id
    @PatchMapping("/{id}")
    public Student patch(@PathVariable Integer id,
                         @RequestBody Map<String, Object> data) {
        return service.patch(id, data);
    }

    // DELETE /api/students/{id}: Xóa Student theo id
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "Deleted (soft)";
    }
}
