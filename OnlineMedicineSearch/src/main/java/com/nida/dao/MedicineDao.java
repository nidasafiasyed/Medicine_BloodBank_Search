package com.nida.dao;
import java.util.List;

import com.nida.model.*;

public interface MedicineDao {
	
	 List<MedicineModel> findAll();
	 List<MedicineModel> findById();
	 List<MedicineModel> findByName();
	 void insertEmployee(MedicineModel medicine);
	 void updateEmployee(MedicineModel medicine);
	 void deleteEmployee(MedicineModel medicine);


}
