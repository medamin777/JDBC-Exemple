package DataAccesObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Objects.Employee;
import Utils.clsUtil;
public  class DAOEmployee implements DAOEmployeeInterface{

	@Override
	public List<Employee> FindAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee FindById(int Id) {
		// TODO Auto-generated method stub
		return null;
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
