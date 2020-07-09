package com.nida.dao;
import java.util.List;

import com.nida.model.*;

public interface PharmacyDao {
	
	 List<Pharmacy> findAll();
	 List<Pharmacy> findById();
	 List<Pharmacy> findByName();
	 void insertEmployee(Pharmacy pharmacy);
	 void updateEmployee(Pharmacy pharmacy);
	 void deleteEmployee(Pharmacy pharmacy);


}
