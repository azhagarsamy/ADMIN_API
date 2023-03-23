package com.azhagar.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhagar.binding.AccountBinding;
import com.azhagar.binding.AccountUpdateBinding;
import com.azhagar.entities.AccountEntity;
import com.azhagar.exception.AccountIdNotFoundException;
import com.azhagar.exception.EmailFoundException;
import com.azhagar.repo.AccountRespository;
import com.azhagar.utils.EmailUtil;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountRespository repo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EmailUtil emailUtil;

	@Override
	public String createAccount(AccountBinding accBinding) {
		Optional<AccountEntity> findEmailId = repo.findByEmailId(accBinding.getEmailId());
		findEmailId.orElseThrow(() -> new EmailFoundException(accBinding.getEmailId() + " MAIL ID ALREADY EXISTS"));
		Optional<AccountEntity> findByMobileNumber = repo.findByMobileNumber(accBinding.getMobileNumber());
		if (findByMobileNumber.isPresent()) {
			return accBinding.getMobileNumber() + " MOBILE NUMBER ALREADY EXISTS";
		}
		AccountEntity accEntity = new AccountEntity();
		BeanUtils.copyProperties(accBinding, accEntity);

		AccountEntity save = repo.save(accEntity);

		return "ACCOUNT HAS BEEN CREATED " + save.getAccId();
	}

	@Override
	public List<AccountBinding> viewAccount() {
		List<AccountEntity> lstAccEntites = repo.findAll();

		Function<AccountEntity, AccountBinding> AccEntityToBinding = acc -> modelMapper.map(acc, AccountBinding.class);

		List<AccountBinding> lstAccBindings = lstAccEntites.stream().map(AccEntityToBinding)
				.collect(Collectors.toList());
		// .map(acc -> new ModelMapper().map(acc,
		// AccountBinding.class)).collect(Collectors.toList());
		return lstAccBindings;
	}

	@Override
	public String updateActiveStatus(Integer accId, String status) {
		Optional<AccountEntity> findById = repo.findById(accId);
		if (!findById.isPresent()) {
			throw new AccountIdNotFoundException(accId + " IS NOT AVAILABLE");
		}

		repo.updateStatus(accId, status);
		return accId + " Deleted";
	}

	@Override
	public String deleteAccount(Integer accId) {
		Optional<AccountEntity> findById = repo.findById(accId);
		if (!findById.isPresent()) {
			throw new AccountIdNotFoundException(accId + " ID IS NOT FOUND");
		}
		repo.deleteById(accId);

		return "DELETED";
	}

	@Override
	public String updateAccount(AccountUpdateBinding accBinding) {

		AccountEntity accEntity = new AccountEntity();
		modelMapper.map(accBinding, accEntity);
		AccountEntity save = repo.save(accEntity);

		return save.getAccId() + "Updated";
	}

}
