package com.valtech.assignments;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class PasswordStrengthTest {

	@Test
	public void test() {
	    String s="Xyz@2349";
	    PasswordStrength pc=new PasswordStrength();
	    assertEquals(23, pc.checker(s));
	            
	    }
	
	@Test
	public void testlower() {
		String s="Xyz@2349";
	    PasswordStrength pc=new PasswordStrength();
	    assertEquals(true, pc.lowerC(s));
	}
	
	
	@Test
	public void testUpper() {
		String s="Xyz@2349";
	    PasswordStrength pc=new PasswordStrength();
	    assertEquals(true, pc.upperC(s));	
	}
	
	@Test
	public void testCount() {
		String s="Xyz@2349";
	    PasswordStrength pc=new PasswordStrength();
	    assertEquals(5, pc.countSC(s));	
	}
	
	@Test
	public void testNumber() {
		String s="Xyz@2349";
	    PasswordStrength pc=new PasswordStrength();
	    assertEquals(8, pc.countNum(s));	
	}
	
	
	@Test
	public void testNum() {
		char c ='5';
		PasswordStrength pc=new PasswordStrength();
		assertEquals(true,pc.isNumber(c));
	}
	
	}


