package com.app.service;

import com.app.exception.StudentException;
import com.app.model.Mark;
import com.app.model.Student;

public interface StudentService {
	
	public Student addStudent(Student student)throws StudentException;
	public Mark addStudentMarks(Mark mark,String rollno) throws StudentException;
}
