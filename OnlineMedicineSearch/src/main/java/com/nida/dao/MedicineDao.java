package com.nida.dao;
import java.util.List;

import com.nida.model.*;

public interface MedicineDao {
	
	 List<Medicine> findAll();
	 List<Medicine> findById();
	 List<Medicine> findByName();
	 void insertEmployee(Medicine medicine);
	 void updateEmployee(Medicine medicine);
	 void deleteEmployee(Medicine medicine);


}
