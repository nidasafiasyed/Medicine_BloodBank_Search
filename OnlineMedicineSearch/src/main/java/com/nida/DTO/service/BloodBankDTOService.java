package com.nida.DTO.service;

import java.util.List;

import com.nida.DTO.BloodBankSearchDTO;

public interface BloodBankDTOService {
	
	List<BloodBankSearchDTO> searchBloodBank(String name, int zip);

}
