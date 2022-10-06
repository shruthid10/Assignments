package com.valtech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
		
			ex.printStackTrace();
		}
	}
	
	public static final String TABLE_NAME="employee";
	
	public int getNextValidId() throws Exception{
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement
				("select max(id) from "+TABLE_NAME);
		ResultSet rs = ps.executeQuery();
		int id = -1;
		if(rs.next()) {
			id= rs.getInt(1);
		}
		con.close();
		return id+1;
	}
	
	public int getFirstId(int currId) throws Exception{
        int id=-1;
        Connection con=getConnection();
        PreparedStatement ps = con.prepareStatement("select min(id) from "+TABLE_NAME);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) id = rs.getInt(1);
        con.close();
        return id;
            
        }
    public int getLastId(int currId) throws Exception{
        int id=-1;
        Connection con=getConnection();
        PreparedStatement ps = con.prepareStatement("select max(id) from "+TABLE_NAME);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) id = rs.getInt(1);
        con.close();
        return id;
            
        }
	
	
	
	
	public int getNextId(int currId) throws Exception {
		int id = -1;
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement
				("select id from "+ TABLE_NAME+" where id > ? fetch next 1 row only");
		ps.setInt(1, currId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) id = rs.getInt(1);
		con.close();
		return id;
	}
	
	public int getPreviousId(int currId) throws Exception {
		int id = -1;
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement
				("select max( id ) from "+ TABLE_NAME+" where id < ? fetch next 1 row only");
		ps.setInt(1, currId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) id = rs.getInt(1);
		con.close();
		return id;
		
	}
	
	//Update employeee
public void updateEmployee(Employee emp) throws Exception{
	Connection con=getConnection();
	PreparedStatement ps=con.prepareStatement("Update "+ TABLE_NAME + " Set name = ?,age = ?,gender = ?, salary = ? Where id = ?");
	
	ps.setInt(5, emp.getId());
	ps.setString(1, emp.getName());
	ps.setInt(2, emp.getAge());
	ps.setInt(3, emp.getGender());
	ps.setFloat(4, emp.getSalary());
	
	int affected=ps.executeUpdate();
	con.close();
	
}
	
//employee by age
public List<Employee> getEmployeesByAge(int age) throws Exception {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("Select id,name,age,gender,salary from "+ TABLE_NAME +" where age = "+age);
	ResultSet rs = ps.executeQuery();
	List<Employee> employees = new ArrayList<>();
	while(rs.next()) {
		employees.add(employeeFromResultSet(rs));
	}
	con.close();
	return employees;
	
}



//employee by between age
public List<Employee> getEmployeesBtwAge(int minage,int maxage) throws Exception {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("Select id,name,age,gender,salary from "+ TABLE_NAME +" where age between " +minage+" and " +maxage);
	ResultSet rs = ps.executeQuery();
	List<Employee> employees = new ArrayList<>();
	while(rs.next()) {
		employees.add(employeeFromResultSet(rs));
	}
	con.close();
	return employees;
	
}

	
//employee by salarygreaterthan
public List<Employee> getSalarygreatethan(float salary) throws Exception {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("Select id,name,age,gender,salary from "+ TABLE_NAME +" where salary>" +salary);
	ResultSet rs = ps.executeQuery();
	List<Employee> employees = new ArrayList<>();
	while(rs.next()) {
		employees.add(employeeFromResultSet(rs));
	}
	con.close();
	return employees;
	
}

//employee by salarylesssthan
public List<Employee> getSalarylessthan(float salary) throws Exception {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("Select id,name,age,gender,salary from "+ TABLE_NAME +" where salary<" +salary);
	ResultSet rs = ps.executeQuery();
	List<Employee> employees = new ArrayList<>();
	while(rs.next()) {
		employees.add(employeeFromResultSet(rs));
	}
	con.close();
	return employees;	
}

//male count
public List<Employee> getMale() throws Exception {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("Select id,name,age,gender,salary from "+ TABLE_NAME +" where gender=1");
	ResultSet rs = ps.executeQuery();
	List<Employee> employees = new ArrayList<>();
	while(rs.next()) {
		employees.add(employeeFromResultSet(rs));
	}
	con.close();
	return employees;	
}
	
//female count
public List<Employee> getFemale() throws Exception {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("Select id,name,age,gender,salary from "+ TABLE_NAME +" where gender=2");
	ResultSet rs = ps.executeQuery();
	List<Employee> employees = new ArrayList<>();
	while(rs.next()) {
		employees.add(employeeFromResultSet(rs));
	}
	con.close();
	return employees;	
}
	
//other count
public List<Employee> getOthers() throws Exception {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("Select id,name,age,gender,salary from "+ TABLE_NAME +" where gender=0");
	ResultSet rs = ps.executeQuery();
	List<Employee> employees = new ArrayList<>();
	while(rs.next()) {
		employees.add(employeeFromResultSet(rs));
	}
	con.close();
	return employees;	
}
	
	
	public void deleteEmployee(int id) throws Exception{
		Connection con= getConnection();
		PreparedStatement ps = con.prepareStatement("delete from "+TABLE_NAME+" where id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		con.close();
	}
	
	
	
	
	
	public List<Employee> getEmployees() throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select id,name,age,gender,salary from "+TABLE_NAME);
		ResultSet rs = ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		while(rs.next()) {
			employees.add(employeeFromResultSet(rs));
		}
		con.close();
		return employees;
		
	}
	
	
	
	public Employee getEmployee(int id)throws Exception {
		Connection conn = getConnection();
		PreparedStatement  ps = conn.prepareStatement("SELECT id,name,age,gender,salary from "+TABLE_NAME+" where id = ?");
	
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
		Employee e = employeeFromResultSet(rs);
		return e;
	}   else {
		return null;
	         }
}



	private Employee employeeFromResultSet(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setGender(rs.getInt(4));
		e.setSalary(rs.getFloat(5));
		
		return e;
	}
	public void saveEmployee(Employee e) throws Exception {
		Connection con=getConnection();
		PreparedStatement ps = con.prepareStatement("insert into "+TABLE_NAME+" (id,name,age,gender,salary) values (?,?,?,?,?)");
	ps.setInt(1, e.getId());	
	ps.setString(2, e.getName());
	ps.setInt(3, e.getAge());
	ps.setInt(4, e.getGender());
	ps.setDouble(5, e.getSalary());
	
	int rowsAffected = ps.executeUpdate();
	con.close();
}
	
	
	public int count() throws Exception{
		Connection con = getConnection();
		Statement st= con.createStatement();
		ResultSet rs = st.executeQuery("Select count(id) from "+TABLE_NAME);
		if(rs.next()) {
			int count = rs.getInt(1);
			con.close();
			return count;
			
		}else {
			con.close();
			return -1;
		}
	}

	public Connection getConnection() throws Exception {
		return DriverManager.getConnection("jdbc:oracle:thin:@192.168.102.38:1521/xe","valtrg16","valtrg16");
	}


}


	
