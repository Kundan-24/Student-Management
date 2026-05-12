package com.student.services;

import java.util.List;
import com.student.entities.Students;

public interface StudentService {
	
	Students saveStudent(Students student);
	Students updateStudent(Long id,Students data);
	void     deleteStudent(Long id);
	List<Students> getAllStudents();
	Students getStudentById(Long id);

}
