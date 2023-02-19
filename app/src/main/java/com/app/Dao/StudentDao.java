package com.app.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
	
	@Query("SELECT s FROM Student s WHERE s.studentRollNo=?1")
	public Student findByStudentRollNo(String studentRollNo);
	
	@Query("SELECT s FROM Student s WHERE s.studentRollNo=?1 AND s.className=?2")
	public Student findByStudentRollNoAndClassName(String studentRollNo,String className);
	
	@Query("SELECT s FROM Student s WHERE s.className=?1")
	public List<Student> findByClassName(String className);
	
}
