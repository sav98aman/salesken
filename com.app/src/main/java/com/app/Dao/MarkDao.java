package com.app.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.Mark;
import com.app.model.Student;

@Repository
public interface MarkDao extends JpaRepository<Mark, Integer> {
	@Query("SELECT s FROM Mark s WHERE s.semsester=?1")
	public Mark findBySemsester(Integer semsester);
	
	@Query("SELECT s FROM Mark s WHERE s.student=?1")
	public List<Mark> findByStudent(Student student);
	
	
	
}
