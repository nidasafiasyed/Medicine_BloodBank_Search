package com.nida.service;

import java.util.List;

import com.nida.model.Blood;
import com.nida.model.BloodType;

public interface BloodService {
	
	 List<Blood> findAllBlood();
	 List<Blood> findBloodByType(BloodType type);
	 Blood updateBlood(int bbId, Blood blood);

}
