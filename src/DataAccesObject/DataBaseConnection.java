package DataAccesObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
private static final String HOST="localhost";
private static final int PORT=3306;
private static final String DATABASENAME="mydatabase";
private static final  String USERNAME="root";
private static final String PASSWORD="";
//jdbc:mysql://localhost:3306/mydatabase
private static Connection connection;
public static Connection GetConnection() 
{
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	connection=DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s",HOST,PORT,DATABASENAME),USERNAME,PASSWORD);

	}catch(SQLException | ClassNotFoundException ex)
	{
		
		ex.printStackTrace();
	}
	return connection;
}

}
