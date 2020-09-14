package employee;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * @author Cédric Bouchard
 * @version 2020
 */
public class EmployeeTest
{
	 private static final int EMPLOYEE_NUMBER_INCREMENT = 10;
	 private final String ANY_NAME = "Roger";
 	 private final int ANY_SALARY = 50000;
 	 private final int ANY_EMPLOYEE_NUMBER = 10;
	
	 @Test (expected = IllegalArgumentException.class)
	 public void GIVEN_EmployeeHasNoName_WHEN_EmployeeIsCreated() 
	 {
		//Arrange
		String emptyName = "";
		
		//Act 
		new Employee(ANY_SALARY,emptyName);
	 }
	 
	 @Test (expected = IllegalArgumentException.class)
	 public void GIVEN_EmployeeHasBadSalary_WHEN_EmployeeIsCreated() 
	 {
		//Arrange
		int badSalary = 1000000000;
		
		//Act 
		new Employee(badSalary,ANY_NAME);
	 } 
	
	 @Test 
	 public void GIVEN_TwoEmployees_WHEN_TwoEmployeesAreCreated_THEN_TheirNumbersWillRespectTheIncrements() 
	 {
		//Arrange
		Employee Employee1 = new Employee(ANY_SALARY,ANY_NAME);
		Employee Employee2 = new Employee(ANY_SALARY,ANY_NAME);
		//Act 
		int id1 = Employee1.getEmployeeNb();
		int id2 = Employee2.getEmployeeNb();
		//Assert
		assertTrue(id1 == id2 - EMPLOYEE_NUMBER_INCREMENT);
	 }
	 
}
