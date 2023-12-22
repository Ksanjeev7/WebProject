package com.Sanju;

public class EmployeeDao {
          private int Id; 
          private String Name;
          private String Email;
          private int salary;
          private String Department ;
          public EmployeeDao() {
		}
			public EmployeeDao( int Id, String Name, String Email,  String Department ,int salary) {
				this.Id = Id;
				this.Name= Name;
				this.Email = Email;
				this.salary = salary;
				this.Department= Department;
			}
		public int getId() {
			return Id;
		}
		public String getName() {
			return Name;
		}
		public String getEmail() {
			return Email;
		}
		public int getsalary() {
			return salary;
		}
		public String getDepartment() {
			return Department;
		}
		public void setEName(String Name) {
			this.Name = Name;
		}
		public void setEmail(String Email) {
			this.Email = Email;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		public void setDepartment(String Department) {
			this.Department= Department;
		}
		@Override
		public String toString() {
			return "EmployeeDao [Id=" + Id + ", E_Name=" + Name + ", Email=" + Email + ", salary=" + salary
					+ ", Department=" + Department + "]";

		} 
		
		
		
		
}
