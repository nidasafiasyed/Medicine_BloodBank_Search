package com.nida.dao;
import java.util.List;

import com.nida.model.*;

public interface PharmacyDao {
	
	 List<PharmacyModel> findAll();
	 List<PharmacyModel> findById();
	 List<PharmacyModel> findByName();
	 void insertEmployee(PharmacyModel pharmacy);
	 void updateEmployee(PharmacyModel pharmacy);
	 void deleteEmployee(PharmacyModel pharmacy);


}
