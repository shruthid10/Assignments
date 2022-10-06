package com.valtech.assignments;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.valtech.assignments.Employee;
import com.valtech.assignments.EmployeeDAO;

public class EmployeeDAOTest {

	
	
	@Test
	public void testGetEmployees() throws Exception {
		EmployeeDAO dao= new EmployeeDAO();
		assertEquals(dao.count(),dao.getEmployees().size());
	}
	
	
	
	@Test
	public void testGetEmployee() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		Employee e=dao.getEmployee(34);
		assertEquals(34,e.getId());
		assertEquals(3,e.getAge());
		
	}
	/*
	@Test
	public void testsaveEmployee()throws Exception{
	    EmployeeDAO dao=new EmployeeDAO();
	int count=dao.count();
	dao.saveEmployee(new Employee(3,"samu",22,2,30000));
	assertEquals(count+1,dao.count());
	dao.deleteEmployee(4);
	assertEquals(count,dao.count());
	}
	

	@Test
	public void testupdate() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		dao.updateEmployee(new Employee (20,"abc",22,1,45000));
		Employee e = dao.getEmployee(20);
		assertEquals(e.getId(),20);
		assertEquals(e.getName(),"abc");
		assertEquals(22,e.getAge());
		assertEquals(1,e.getGender());
		assertEquals(45000,e.getSalary(),0.00001);
		
	}
	*/
	
	@Test
	public void testGetEmployeesByAge() throws Exception {
		EmployeeDAO dao=new EmployeeDAO();
		assertEquals(1,dao.getEmployeesByAge(22).size());
	}
	
	
	@Test
	public void testgetEmployeesBtwAge() throws Exception {
		EmployeeDAO dao= new EmployeeDAO();
		assertEquals(2,dao.getEmployeesBtwAge(25, 28).size());
	}
	
    
     @Test
     public void testSalarygreaterthan() throws Exception {
    	 EmployeeDAO dao = new EmployeeDAO();
    	 assertEquals(1,dao.getSalarygreatethan(50000).size());
     }

	@Test
	public void testSalarylesserthan() throws Exception {
   	 EmployeeDAO dao = new EmployeeDAO();
   	 assertEquals(3,dao.getSalarygreatethan(35000).size());
    }
	
	@Test
	public void testmalecount() throws Exception {
	   	 EmployeeDAO dao = new EmployeeDAO();
	   	 assertEquals(4,dao.getMale().size());
	    }
		
	
	@Test
	public void testfemalecount() throws Exception {
	   	 EmployeeDAO dao = new EmployeeDAO();
	   	 assertEquals(3,dao.getFemale().size());
	    }
		
	

	@Test
	public void testotherscount() throws Exception {
	   	 EmployeeDAO dao = new EmployeeDAO();
	   	 assertEquals(0,dao.getOthers().size());
	    }
			
}
