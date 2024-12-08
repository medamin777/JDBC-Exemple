package DataAccesObject;
import java.util.List;

import models.Employee;

public interface DAOEmployeeInterface {
	
	 List<Employee> getAll();
	
	 
	 Employee FindById(int Id);
	
	 
	 void Save(Employee empoyer);
	
	 
	 void DeleteById(int Id);

}
