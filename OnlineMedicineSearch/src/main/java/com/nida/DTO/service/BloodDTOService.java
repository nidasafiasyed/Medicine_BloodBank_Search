package com.nida.DTO.service;

import java.util.List;

import com.nida.DTO.BloodSearchDTO;
import com.nida.model.BloodType;

public interface BloodDTOService {
	
	List<BloodSearchDTO> searchBlood(BloodType type, int zip);

}
