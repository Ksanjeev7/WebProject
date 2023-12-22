package com.Sanju;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Employeebo implements EmployeeInterface {
      private static  Connection connection = null	 ;
      private static   PreparedStatement pstatement ;
      private  static  Statement statement;
      private static   ResultSet resultSet;
	  private  final static  String SelectQuery = "select * from employee";
	  private  final static  String Select_BY_ID = "select  *  from `employee` where Id = ?";
	   private final  static String Insert 	= "insert into employee (`Id`, `Name`, `Email`, `Department`, `salary`) values (?,  ?,  ?,  ?, ?)";
	  private  final  static String Delete = "Delete from employee where `Id`=?";
	  private final  static  String UpdateQuery = "Update  employee  set `Name` = ?, `Email` = ?, `Department` = ?, `salary` = ? where `Id` = ?";
	
			    public Employeebo() {
			        try {
			            Class.forName("com.mysql.cj.jdbc.Driver");
			            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcclasses", "root", "Sanju@71");
			        } catch (ClassNotFoundException | SQLException e) {
			            e.printStackTrace();
			        }
			    }
//      Insert Employee obj...... 
	@Override
  public int InsertEmp(EmployeeDao emp) {
		              try {
//		            	  Create statement using Connection Object.....
						 pstatement = connection.prepareStatement(Insert);
						  pstatement.setInt(1, emp.getId());
				          pstatement.setString(2, emp.getName());
				          pstatement.setString(3, emp.getEmail());
				          pstatement.setString(4, emp.getDepartment());
				          pstatement.setInt(5, emp.getsalary());
//				         Update Query and Return Query.......
						return pstatement.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}
		   return -1;
	}

		@Override
		public int UpdateEmp(EmployeeDao emp) {
		 try {
			pstatement = connection.prepareStatement(UpdateQuery);
			 pstatement.setString(1, emp.getName());
	          pstatement.setString(2, emp.getEmail());
	          pstatement.setString(3, emp.getDepartment());
	          pstatement.setInt(4, emp.getsalary());
	          pstatement.setInt(5, emp.getId());
			  return pstatement.executeUpdate();
		 	} catch (SQLException e) {
			e.printStackTrace();
			}
		return 0;
	}

@Override
public int Delete(int Id) {
             try {
				pstatement = connection.prepareStatement(Delete);
			    pstatement.setInt(1, Id);
				return pstatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return 0;
        }

	@Override
	public int Delete(EmployeeDao emp) {
		return Delete(emp.getId());
	}

	
	@Override
	public EmployeeDao getemployee(int Id) {
		try {
			pstatement = connection.prepareStatement(Select_BY_ID);
			 pstatement.setInt(1, Id);
			 ResultSet res = pstatement.executeQuery();
			  if(res.next()) {
            	 int id = res.getInt("Id");
            	String ename = res.getString("Name");
            	String email = res.getString("Email");
            	String dept = res.getString("Department");
            	int salary = res.getInt("salary");	
            	return new EmployeeDao(id, ename, email, dept,salary);
			     }
			} catch (SQLException e) {
			e.printStackTrace();
		    }
		           return null;
 	}

	
	@Override
	public List<EmployeeDao> getAll() {
		  List<EmployeeDao>emps = new ArrayList<>();
		try {
			     statement = connection.createStatement();
			      resultSet = statement.executeQuery(SelectQuery);
			       while(resultSet.next()) {
	                	 int id = resultSet.getInt("Id");
	                	 String ename = resultSet.getString("Name");
	                	 String email = resultSet.getString("Email");
	                	  String dept = resultSet.getString("Department");
	                	  int salary = resultSet.getInt("salary");	
	                	emps.add( new EmployeeDao(id,ename, email, dept, salary));
			      }
		    } catch (SQLException e) {
			     e.printStackTrace();
		    }
		   return emps;
	 }
}
     



















