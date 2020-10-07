package com.cg.wallet.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.wallet.dao.WalletAccountDao;
import com.cg.wallet.dao.WalletBankDao;
import com.cg.wallet.dto.AccountForm;
import com.cg.wallet.dto.AddMoneyDto;
import com.cg.wallet.dto.UserDto;
import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.entity.WalletBank;
import com.cg.wallet.exception.WalletAccountDoNotExistsException;
import com.cg.wallet.exception.WalletAccountExistsException;
import com.cg.wallet.util.WalletConstants;

@Service
public class AddWalletServiceImpl implements IAddWalletService{

	@Autowired
	private WalletAccountDao accountDao;
	@Autowired
	private WalletBankDao bankDao;
	
	//Add new wallet account
	@Override
	@Transactional
	public String addNewWalletAccount(UserDto userDto) throws WalletAccountExistsException {
		 Optional<WalletAccount> optAccount = accountDao.findById(userDto.getPhoneNo());
		 if (optAccount.isPresent())
			 throw new WalletAccountExistsException(WalletConstants.PHONE_NO_ALREADY_EXISTS);
		WalletAccount account = new WalletAccount();
		account.setPhoneNo(userDto.getPhoneNo());
		account.setUserName(userDto.getUserName());
		account.setPassword(userDto.getPassword());
		account.setBalance(userDto.getBalance());
		account.setRole(WalletConstants.USER_ROLE);
		account.setStatus(WalletConstants.ACTIVE_USER);
		account.setAccCreatedDt(LocalDate.now());
		accountDao.save(account);
		return WalletConstants.WALLET_ACCOUNT_CREATED;
	}
	
	//Get all details 
	@Override
	public List<WalletAccount> getAllDetails() {
		return accountDao.findAll();
	}
    
	//Add money to wallet
	@Override
	public String addMoney(AddMoneyDto addmoneyDto) throws WalletAccountDoNotExistsException {
		Optional<WalletAccount> optAccount = accountDao.findById(addmoneyDto.getPhoneNo());
		if (!optAccount.isPresent())
			 throw new WalletAccountDoNotExistsException(WalletConstants.ACCOUNT_NOT_EXISTS);
		WalletAccount account=optAccount.get();
		Double balance=account.getBalance();
		balance=balance+addmoneyDto.getAmount();
		account.setBalance(balance);
		accountDao.save(account);
		return WalletConstants.MONEY_ADDED_TO_WALLET ;
	}	
}
