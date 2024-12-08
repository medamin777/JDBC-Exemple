package DataAccesObject;
import Objects.Employee;
import java.util.List;

public interface DAOEmployeeInterface {
	
	 List<Employee> getAll();
	
	 Employee FindById(int Id);
	
	 void Save(Employee empoyer);
	
	 void DeleteById(int Id);

}
