package DataAccesObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Objects.Employee;
import Utils.clsUtil;
public  class DAOEmployee implements DAOEmployeeInterface{

	@Override
	public List<Employee> getAll() {
		
		Connection connection=DataBaseConnection.GetConnection();
		List<Employee> Employees=new ArrayList<>();
		if (connection==null)
			return Employees;
		
		String Query="SELECT * from employee;" ;
		try (connection; PreparedStatement preparedStatement=connection.prepareCall(Query))
		{
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Employee employee=new Employee(resultSet.getInt(1),resultSet.getString(2),resultSet.getBoolean(3),resultSet.getDate(4),resultSet.getDouble(5));
				Employees.add(employee);
			}
			return Employees;
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return Employees;
	}

	@Override
	public Employee FindById(int Id) {
		
		Connection connection=DataBaseConnection.GetConnection();
		Employee employee=new Employee();
		if (connection==null)
			return null;
		
		String Query="SELECT * FROM employee WHERE id=?;";

		try(PreparedStatement preparedStatement=connection.prepareCall(Query))
		{
			preparedStatement.setInt(1, Id);
			ResultSet resultset=preparedStatement.executeQuery();
			if(resultset.next())
				employee=new Employee(resultset.getInt(1),resultset.getString(2),resultset.getBoolean(3),resultset.getDate(4),resultset.getDouble(5));
			
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try {
				connection.close();
			}catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
		
		return employee;
	}

	@Override
	public  void Save(Employee employee)  {
		
		Connection connection=DataBaseConnection.GetConnection();
		if (connection==null)
			return;
		if(employee.get_Id()>0)
		{
			//Update Employee
			String Query="update  employee set name=? ,gender=? ,birthday=? ,salary=?  where id=?";
			try ( connection;PreparedStatement preparedStatement=connection.prepareCall(Query))
			{
				preparedStatement.setString(1,employee.get_Name());
				preparedStatement.setBoolean(2, employee.is_Gender());
				preparedStatement.setDate(3, clsUtil.JavaDateToSql(employee.getBirthday()));
				preparedStatement.setDouble(4, employee.get_Salary());
				preparedStatement.setInt(5, employee.get_Id());
				preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		else {
			//create employer
			PreparedStatement preparedStatement=null;
			try{
			String Query="insert into employee(name,gender,birthday,salary) values (?,?,?,?)";
			preparedStatement=connection.prepareCall(Query);
			preparedStatement.setString(1, employee.get_Name());
			preparedStatement.setBoolean(2, employee.is_Gender());
			preparedStatement.setDate(3, clsUtil.JavaDateToSql(employee.getBirthday()));
			preparedStatement.setDouble(4, employee.get_Salary());
			preparedStatement.executeUpdate();
			}catch(SQLException ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				try {
				connection.close();
				}catch(SQLException ex)
				{
					ex.printStackTrace();
				}
				if (preparedStatement!=null)
				{
					try {
					preparedStatement.close();
					}catch(SQLException ex)
					{
						ex.printStackTrace();
					}
				}
			}
			
		}
		
	}

	@Override
	public void DeleteById(int Id) {
		// TODO Auto-generated method stub
		
	}

}
