package Objects;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import DataAccesObject.DAOEmployee;
import DataAccesObject.DAOEmployeeInterface;
public class Test {
	public static void main(String args[]) throws ParseException
	{
		SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy");
		Employee employee4=new Employee(5,"Salima",false,DateFormat.parse("18-10-1989"),2322);
		DAOEmployeeInterface daoemployee=new DAOEmployee();
		daoemployee.Save(employee4);
	}
}