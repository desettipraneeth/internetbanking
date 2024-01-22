package com.es.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

	@Id
	@GeneratedValue(generator = "empseqgen")
	@SequenceGenerator(name = "empseqgen", sequenceName = "employee_db.empseq", initialValue = 10001, allocationSize = 1, schema = "employee_db")
	@Column(name = "empid")
	private Long empId;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "mail", nullable = false, unique = true)
	private String empEmail;

}
