package com.cg.wallet;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.wallet.dto.AccountForm;
import com.cg.wallet.dto.UserDto;
//import com.cg.wallet.exception.BankAccountException;
import com.cg.wallet.exception.WalletAccountExistsException;
import com.cg.wallet.service.AddWalletServiceImpl;

@SpringBootTest
class PaymentWalletApplicationTests {
	/*
	@Autowired
	private AddWalletServiceImpl service;
	
	@Test
	public void testAddWallet1() throws WalletAccountExistsException 
	{
		UserDto user = new UserDto();
		
		user.setPhoneNo("9219210123");
		user.setBalance(5000);
		user.setUserName("astha gupta");
		user.setPassword("forever21");
		
		String result= service.addNewWalletAccount(user);
		Assertions.assertEquals("Wallet account created successfully",result);
	}
	@Test
	
	public void testAddWallet2() throws WalletAccountExistsException 
	{
		UserDto user = new UserDto();
		
		user.setPhoneNo("9219210123");
		user.setBalance(5000);
		user.setUserName("astha gupta");
		user.setPassword("forever21");

		assertThrows(WalletAccountExistsException.class, ()->service.addNewWalletAccount(user));
	}
	@Test
	public void testAddBank1() throws WalletAccountExistsException, BankAccountException
	{
		AccountForm form = new AccountForm();
		
		form.setAccountId("2");
		form.setBankName("PNB");
		form.setPhoneNo("9219210123");
		form.setPin("7853");
		
		String result= service.addBankAccount(form);
		Assertions.assertEquals("bank account added successfully",result);
	}
	@Test
	public void testAddBank2() throws WalletAccountExistsException, BankAccountException
	{
		AccountForm form = new AccountForm();
		
		form.setAccountId("1");
		form.setBankName("SBI");
		form.setPhoneNo("9797697979");
		form.setPin("5467");
		
		assertThrows(BankAccountException.class, ()->service.addBankAccount(form));
	}
	*/
	

}
