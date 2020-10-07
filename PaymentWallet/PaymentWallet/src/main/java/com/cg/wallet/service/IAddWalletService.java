package com.cg.wallet.service;

import java.util.List;

import com.cg.wallet.dto.AccountForm;
import com.cg.wallet.dto.AddMoneyDto;
import com.cg.wallet.dto.UserDto;
import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.exception.WalletAccountDoNotExistsException;
import com.cg.wallet.exception.WalletAccountExistsException;

public interface IAddWalletService {
	
	
	public String addNewWalletAccount(UserDto userDto) throws WalletAccountExistsException;
	public List<WalletAccount> getAllDetails();
	public String addMoney(AddMoneyDto addmoneyDto) throws WalletAccountDoNotExistsException;
}
