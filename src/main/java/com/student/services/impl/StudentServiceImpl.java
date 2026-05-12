package com.student.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entities.Students;
import com.student.repository.StudentsRepo;
import com.student.services.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentsRepo studentsRepo;
	
	@Override
	public Students saveStudent(Students student) {
		
		return studentsRepo.save(student);
	}

	@Override
	public Students updateStudent(Long id, Students data) {
		       Students students = studentsRepo.findById(id).orElseThrow(()-> new RuntimeException("Student not found with given id "+id));
		       students.setFullName(data.getFullName());
		       students.setDob(data.getDob());
		       students.setAddress(data.getAddress());
		       students.setQualification(data.getQualification());
		       students.setEmail(data.getEmail());
		       Students save = studentsRepo.save(students);
		return save;
	}
	
	@Override
	public Students getStudentById(Long id) {
	    return studentsRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id " + id));
	}


	@Override
	public void deleteStudent(Long id) {
		Students students = studentsRepo.findById(id).orElseThrow(()-> new RuntimeException("Students not found with given id "+id));
		studentsRepo.delete(students);
		
	}

	@Override
	public List<Students> getAllStudents() {
		
		return studentsRepo.findAll();
	}

}
