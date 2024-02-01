package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.driver.Services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);
    }

    @PostMapping("/add-teacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher) {
        return this.studentService.addTeacher(teacher);
    }

    @PutMapping("/add-student-teacher-pair")
    public ResponseEntity<String> addStudentTeacherPair(
            @RequestParam(required = false) String student,
            @RequestParam(required = false) String teacher) {

        if (student == null || teacher == null) {
            return ResponseEntity.badRequest().body("Student and teacher names are required.");
        }

        return this.studentService.addStudentTeacherPair(student, teacher);
    }

    @GetMapping("/get-student-by-name/{name}")
    public ResponseEntity<ResponseEntity<Student>> getStudentByName(@PathVariable String name) {
        ResponseEntity<Student> student = this.studentService.getStudentByName(name);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get-teacher-by-name/{name}")
    public ResponseEntity<ResponseEntity<Teacher>> getTeacherByName(@PathVariable String name) {
        ResponseEntity<Teacher> teacher = this.studentService.getTeacherByName(name);
        if (teacher != null) {
            return ResponseEntity.ok(teacher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get-students-by-teacher-name/{teacher}")
    public ResponseEntity<List<String>> getStudentsByTeacherName(@PathVariable String teacher) {
        List<String> students = (List<String>) this.studentService.getStudentsByTeacherName(teacher);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/get-all-students")
    public ResponseEntity<List<String>> getAllStudents() {
        List<String> students = (List<String>) this.studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/delete-teacher-by-name")
    public ResponseEntity<String> deleteTeacherByName(@RequestParam String teacher) {
        return this.studentService.deleteTeacherByName(teacher);
    }

    @DeleteMapping("/delete-all-teachers")
    public ResponseEntity<String> deleteAllTeachers() {
        return this.studentService.deleteAllTeachers();
    }
}
