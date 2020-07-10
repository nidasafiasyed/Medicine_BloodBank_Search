package com.nida.dao;
import java.util.List;

import com.nida.model.*;

public interface PharmacyDao {
	
	 List<Pharmacy> findByName(String name);
	 List<Pharmacy> findByAddress(String zip);


}
