package com.app.model;


import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Mark {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mark_id;
	
	@ColumnDefault("0")
	private Integer math;
	@ColumnDefault("0")
	private Integer english;
	@ColumnDefault("0")
	private Integer science;
	
	private Integer semsester;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private Student student;
}
