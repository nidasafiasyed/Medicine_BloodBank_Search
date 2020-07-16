package com.nida.service;

import java.util.List;

import com.nida.model.Blood;

public interface BloodService {
	
	 List<Blood> findAllBlood();
	 Blood findBloodById(int id);
	 Blood insertBlood(Blood blood);
	 void deleteBlood(int id);

}
