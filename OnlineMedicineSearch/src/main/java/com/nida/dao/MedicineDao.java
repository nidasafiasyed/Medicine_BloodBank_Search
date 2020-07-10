package com.nida.dao;
import java.util.List;

import com.nida.model.*;

public interface MedicineDao {
	
	 List<Medicine> findByName(String name);


}
