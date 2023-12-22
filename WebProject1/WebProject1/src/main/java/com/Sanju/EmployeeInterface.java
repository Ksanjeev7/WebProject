package com.Sanju;
import java.util.List;
public interface EmployeeInterface {
	public  int InsertEmp(EmployeeDao emp ) ;
	public int UpdateEmp(EmployeeDao emp);
	public int Delete(int Id );
	public int Delete(EmployeeDao emp);
	public  EmployeeDao getemployee(int Id);
	public List<EmployeeDao> getAll();

}
