package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.exception.StudentException;
import com.app.model.Mark;
import com.app.model.ReportDto;
import com.app.model.Student;
import com.app.service.ReportServiceimpl;
import com.app.service.StudentServiceImpl;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	
	//call service method through Autowired
	@Autowired
	private StudentServiceImpl studentserviceimpl;
	
	@Autowired
	private ReportServiceimpl reportserviceimpl;
	
	//add Student
	@PostMapping(value = "/add")
	public ResponseEntity<Student> add_Student(@RequestBody Student student) throws StudentException{
		
		Student newStduent=studentserviceimpl.addStudent(student);
		return new ResponseEntity<Student>(newStduent,HttpStatus.CREATED);
	}
	
	
	//add Studnet marks;
	@PostMapping(value = "add/marks/{roll}")
	public ResponseEntity<Mark> add_Student_marks(@RequestBody Mark mark,@PathVariable String roll) throws StudentException{
		Mark studentmarks=studentserviceimpl.addStudentMarks(mark, roll);
		return new ResponseEntity<Mark>(studentmarks,HttpStatus.CREATED);
	}
	
	
	@GetMapping(value = "/average/marks/class/{className}")
	public ResponseEntity<ReportDto> add_Student_marks(@PathVariable String className) throws StudentException{
		ReportDto avgmarks=reportserviceimpl.averagePercentageOfClass(className);
		return new ResponseEntity<ReportDto>(avgmarks,HttpStatus.OK);
	}
}
