package com.nida.service;

import java.util.List;

import com.nida.model.BloodBank;

public interface BloodBankService {
	
	 List<BloodBank> findAllBloodBanks();
	 BloodBank findBloodBankById(int id);
	 BloodBank insertBloodBank(BloodBank bb);
	 BloodBank updateBloodBank(int id, BloodBank bb);
	 void deleteBloodBank(int id);

}
