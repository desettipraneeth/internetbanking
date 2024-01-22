package com.ds.entity;

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
@Table(name = "department")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

	@Id
	@GeneratedValue(generator = "depseqgen")
	@SequenceGenerator(name = "depseqgen", sequenceName = "department_db.depseq", initialValue = 1001, allocationSize = 1, schema = "department_db")
	@Column(name = "depid")
	private Long depId;

	@Column(name = "depname")
	private String depName;

	@Column(name = "depdes")
	private String depDes;

	@Column(name = "depcode")
	private String depCode;

}
