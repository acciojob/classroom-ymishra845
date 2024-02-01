package com.driver.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.driver.Student;
import com.driver.Teacher;

@Repository
public class StudentRepository {

    public Map<String, Student> students = new HashMap<>();
    public Map<String, Teacher> teachers = new HashMap<>();
    public Map<String, String> StudentTeacher = new HashMap<>();

    public ResponseEntity<Student> getStudentByName(String name) {
        try {
            for (Map.Entry<String, Student> entry : students.entrySet()) {
                if (entry.getKey().equals(name)) {
                    return ResponseEntity.ok(entry.getValue());
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public ResponseEntity<Teacher> getTeacherByName(String name) {
        try {
            for (Map.Entry<String, Teacher> entry : teachers.entrySet()) {
                if (entry.getKey().equals(name)) {
                    return ResponseEntity.ok(entry.getValue());
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public ResponseEntity<List<String>> getAllStudents() {
        try {
            List<String> list = null;
            for (Map.Entry<String, Student> entry : students.entrySet()) {
                list.add(entry.getValue().getName());
            }
            return (ResponseEntity<List<String>>) list;
        } catch (Exception e) {
            return null;
        }
    }

    public ResponseEntity<String> deleteTeacherByName(String teacher) {
        try {
            List<String> list1 = null;
            for (Map.Entry<String, Teacher> entry : teachers.entrySet()) {
                if (entry.getKey().equals(teacher)) {
                    teachers.remove(teacher);
                } else {
                    list1.add(entry.getValue().getName());
                }
            }
            return (ResponseEntity<String>) list1;
        } catch (Exception e) {
            return null;
        }
    }

    public ResponseEntity<List<String>> getStudentsByTeacherName(String teacher) {
        try {
            List<String> list2 = null;
            for (Map.Entry<String, String> entry : StudentTeacher.entrySet()) {
                if (entry.getValue().equals(teacher)) {
                    list2.add(entry.getKey());
                }
            }
            return (ResponseEntity<List<String>>) list2;
        } catch (Exception e) {
            return null;
        }
    }
}
