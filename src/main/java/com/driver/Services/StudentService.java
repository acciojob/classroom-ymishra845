package com.driver.Services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.driver.Student;
import com.driver.Teacher;

public interface StudentService {
	
	 public ResponseEntity<String> addStudent(Student student) ;
	 public ResponseEntity<String> addTeacher(Teacher teacher);
	 public ResponseEntity<String> addStudentTeacherPair(String student,String teacher);
	  public ResponseEntity<Student> getStudentByName(String name);
	  public ResponseEntity<Teacher> getTeacherByName(String name);
	  public ResponseEntity<List<String>> getStudentsByTeacherName(String teacher);
	  public ResponseEntity<List<String>> getAllStudents();
	  public ResponseEntity<String> deleteTeacherByName(String teacher);
	  public ResponseEntity<String> deleteAllTeachers();

}
