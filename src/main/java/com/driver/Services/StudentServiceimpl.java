package com.driver.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.driver.Student;
import com.driver.Teacher;
import com.driver.Repository.StudentRepository;

@Service
public class StudentServiceimpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public ResponseEntity<String> addStudent(Student student) {
		// TODO Auto-generated method stub
		this.studentRepository.students.put(student.getName(), student);
		 return ResponseEntity.ok("Student added successfully");
	}

	@Override
	public ResponseEntity<String> addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		this.studentRepository.teachers.put(teacher.getName(), teacher);
		return null;
	}

	@Override
	public ResponseEntity<String> addStudentTeacherPair(String student, String teacher) {
		// TODO Auto-generated method stub
		this.studentRepository.StudentTeacher.put(student, teacher);
		return ResponseEntity.ok("Student Teacher pair added successfully");
	}

	@Override
	public ResponseEntity<Student> getStudentByName(String name) {
		// TODO Auto-generated method stub
		
		return this.studentRepository.getStudentByName(name);
	}

	@Override
	public ResponseEntity<Teacher> getTeacherByName(String name) {
		// TODO Auto-generated method stub
		return this.studentRepository.getTeacherByName(name);
	}

	@Override
	public ResponseEntity<List<String>> getStudentsByTeacherName(String teacher) {
		// TODO Auto-generated method stub
		
		return this.studentRepository.getStudentsByTeacherName(teacher);
	}

	@Override
	public ResponseEntity<List<String>> getAllStudents() {
		// TODO Auto-generated method stub
		return this.studentRepository.getAllStudents();
	}

	@Override
	public ResponseEntity<String> deleteTeacherByName(String teacher) {
		// TODO Auto-generated method stub
		
		return studentRepository.deleteTeacherByName(teacher);
	}

	@Override
	public ResponseEntity<String> deleteAllTeachers() {
		// TODO Auto-generated method stub
		try {
		this.studentRepository.teachers.clear();
		 return ResponseEntity.ok("All teachers deleted successfully");
		}catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting teachers: " + e.getMessage());
        }
		
		
	}

}
