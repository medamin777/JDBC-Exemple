package Utils;

public class clsUtil {
	public static java.sql.Date JavaDateToSql(java.util.Date JavaDate)
	{
		
		
		return  new java.sql.Date(JavaDate.getTime());
	}
}
