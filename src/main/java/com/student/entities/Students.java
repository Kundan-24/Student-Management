package com.student.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="s_id")
	private Long id;
	
	@Column(nullable = false,length = 20)
	private String fullName;
	
	@Column(name="date_of_birth",nullable = false)
	private String dob;
	
	@Lob
	private String address;
	
	@Column(nullable = false)
	private String qualification;
	
	@Column (nullable = false)
	private String email;
}
