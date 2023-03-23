package com.azhagar.repo;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.azhagar.entities.AccountEntity;

public interface AccountRespository extends JpaRepository<AccountEntity, Serializable>{
	
	
	Optional<AccountEntity> findByEmailId(String emailId);
	
	Optional<AccountEntity> findByMobileNumber(Long mobileNumber);
	
	@Query("UPDATE AccountEntity set active=:status where accId=:accId")
	String updateStatus(Integer accId,String status);

}
