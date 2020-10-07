package com.cg.wallet.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.wallet.dto.AddMoneyDto;
import com.cg.wallet.dto.SuccessResponse;
import com.cg.wallet.dto.UserDto;
import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.exception.WalletAccountDoNotExistsException;
import com.cg.wallet.exception.WalletAccountExistsException;
import com.cg.wallet.service.AddWalletServiceImpl;
import com.cg.wallet.service.IAddWalletService;
import com.cg.wallet.util.WalletConstants;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
public class AddWalletMicroservice {
	
	@Autowired
	private IAddWalletService walletService;
	
	@Autowired
	private AddWalletServiceImpl addWalletService;
	
	//Add wallet account
	@PostMapping(WalletConstants.ADD_WALLET_URL)
	public SuccessResponse addNewWalletaccount(@RequestBody UserDto userDto) throws WalletAccountExistsException {
		String message = walletService.addNewWalletAccount(userDto);
		return new SuccessResponse(message);
	}
	
	//Add money to wallet
	@PutMapping(WalletConstants.ADD_MONEY_URL)
	public SuccessResponse addMoney(@RequestBody AddMoneyDto addmoneyDto) throws WalletAccountDoNotExistsException {
		String msg = walletService.addMoney(addmoneyDto);
		return new SuccessResponse(msg);
	}
	
	//Get all details
	@GetMapping(WalletConstants.GET_DETAIL_URL)
	public List<WalletAccount> getAllDetails(){
	 return addWalletService.getAllDetails();
	 }
	

}
