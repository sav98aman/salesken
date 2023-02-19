package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dao.MarkDao;
import com.app.Dao.StudentDao;
import com.app.exception.StudentException;
import com.app.model.Mark;
import com.app.model.ReportDto;
import com.app.model.Student;

@Service
public class ReportServiceimpl implements ReportService {
	
	@Autowired
	private MarkDao markDao;
	@Autowired
	private StudentDao studnetdao;
	
	@Override
	public ReportDto averagePercentageOfClass(String className) throws StudentException {
		
		List<Student> listofStudent=studnetdao.findByClassName(className);
		if(listofStudent==null) {
			throw new StudentException(" No Student is Persent");
		}
		
		int mark=0;
		int countmak=0;
		System.out.println(listofStudent);
		for (Student student : listofStudent) {
			
			List<Mark> listofMarks=markDao.findByStudent(student);
			for (Mark marks : listofMarks) {
				//recent semester
				if(marks.getSemsester()==2) {
					countmak++;
					mark+=marks.getEnglish()+marks.getScience()+marks.getMath();
				}
			}
		}
		System.out.println(mark);
		int avgmarks=mark/countmak;
		
		ReportDto rp=new ReportDto(avgmarks, className);
		return rp;
	}

}
