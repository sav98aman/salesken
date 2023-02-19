package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.Dao.MarkDao;
import com.app.Dao.StudentDao;
import com.app.exception.StudentException;
import com.app.model.Mark;
import com.app.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	//make sure that is call the all StudentDao Method
	@Autowired
	private StudentDao studentdao;
	@Autowired
	private MarkDao markdao;
	
	//First check Student is Present or Not;
	public boolean checkStudent(String rollno) {
		
		//find Student by Roll No.
		Student isStudnet=studentdao.findByStudentRollNo(rollno);
		if (isStudnet == null) {
			return false;
		}else {
			return true;
		}
		
	}
	@Override
	public Student addStudent(Student student) throws StudentException {
		//First check Student is Present or Not;
		if(checkStudent(student.getStudentRollNo())) {
			throw new StudentException(" Student Is All Reday Persnet ");
		}
		//else--- save newStudent
		return studentdao.save(student);
	}
	
	@Override
	public Mark addStudentMarks(Mark marks,String rollno) throws StudentException {
		// TODO Auto-generated method stub
		
		// check at most 2 sem.marks add not more then 2
		if(marks.getSemsester()>2 || marks.getSemsester()==0) {
			throw new StudentException(" Please Enter valid semester marks  ");
		}
		
		// check roll No is Persent or Not
		if(!checkStudent(rollno)) {
			throw new StudentException(" Student Is Not Persent");
		}
		Student isStudnet=studentdao.findByStudentRollNo(rollno);
		
		marks.setStudent(isStudnet);
		
		return markdao.save(marks);
		
	}
	

}
