package com.nida.DTO.service;

import java.util.List;

import com.nida.DTO.PharmacySearchDTO;

public interface PharmacyDTOService {
	
	List<PharmacySearchDTO> searchPharmacy(String name, int zip);
	
}
