package com.app.service;

import com.app.exception.StudentException;
import com.app.model.ReportDto;

public interface ReportService {
	
//		Average Percentage of whole class in recent semester
//	 - Average marks of Students in a subject
//	 - Top 2 Consistent Students across all semesters (Maximum average marks)
	
		public ReportDto averagePercentageOfClass(String className)throws StudentException;
		
}
