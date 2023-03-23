package com.azhagar.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import lombok.Data;

@Entity
@Data
@Table(name = "cw_account_tbl", schema = "masterdb",indexes = @Index(columnList = "email_id"))
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accGen_seq")
	@SequenceGenerator(name = "accGen_seq", allocationSize = 1, initialValue = 1)
	@Column(name = "acc_id", updatable = false)
	private Integer accId;

	@Column(name = "first_name", nullable = false, length = 50)
	private String fName;

	@Column(name = "email_id", nullable = false, length = 100, unique = true)
	private String emailId;

	@Column(name = "mob_num", nullable = false, length = 50, unique = true)
	private Long mobileNumber;

	@Column(name = "gender", nullable = false, length = 10)
	private String gender;

	@Column(name = "dob", nullable = false)
	private LocalDate dob;

	@Column(name = "ssn", nullable = false)
	private Long ssn;

	@Column(name = "active", nullable = false,columnDefinition = "varchar(15)")
	private String active;

	@CreatedBy
	@Column(name = "created_by", nullable = false)
	private Integer createdBy;

	@CreationTimestamp
	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@Column(name = "updated_by", nullable = false)
	private Integer updatedBy;

	@UpdateTimestamp
	@Column(name = "update_date", nullable = false)
	private LocalDateTime updatedDate;
}
