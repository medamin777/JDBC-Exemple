package Objects;

import java.util.Date;

public class Employee {
	private int _Id;
	private String _Name;
	private boolean _Gender;
	private Date _Birthday;
	private double _Salary;
	public Employee()
	{
		
	}
	public Employee(int Id,String Name,boolean Gender,Date Birthday,double Salary)
	{
		_Id=Id;
		_Name=Name;
		_Gender=Gender;
		_Birthday=Birthday;
		_Salary=Salary;
		
	}
	public Employee (String Name,boolean Gender,Date Birthday,double Salary)
	{
		_Name=Name;
		_Gender=Gender;
		_Birthday=Birthday;
		_Salary=Salary;
	}
	@Override
	public String toString() {
		return "Employer [_Id=" + _Id + ", _Name=" + _Name + ", _Gender=" + _Gender + ", Birthday=" + _Birthday
				+ ", _Salary=" + _Salary + "]";
	}
	public int get_Id() {
		return _Id;
	}
	public void set_Id(int _Id) {
		this._Id = _Id;
	}
	public String get_Name() {
		return _Name;
	}
	public void set_Name(String _Name) {
		this._Name = _Name;
	}
	public boolean is_Gender() {
		return _Gender;
	}
	public void set_Gender(boolean _Gender) {
		this._Gender = _Gender;
	}
	public Date getBirthday() {
		return _Birthday;
	}
	public void setBirthday(Date birthday) {
		_Birthday = birthday;
	}
	public double get_Salary() {
		return _Salary;
	}
	public void set_Salary(double _Salary) {
		this._Salary = _Salary;
	}

	
}
