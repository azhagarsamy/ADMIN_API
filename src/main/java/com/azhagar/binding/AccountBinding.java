package com.azhagar.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AccountBinding {

	private String fName;
	private String emailId;
	private Long mobileNumber;
	private String gender;
	private LocalDate dob;
	private Long ssn;

}
