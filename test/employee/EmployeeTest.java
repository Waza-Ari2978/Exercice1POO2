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
	 
	 @Test 
	 public void GIVEN_OneEmployee_WHEN_ARaiseIsGiven_THEN_TheSalaryWillBeReflectedAccordingly() 
	 {
		//Arrange
		float raiseAmount = StandardSalaryIncrease.MAXIMUM_RAISE-1; 
		Employee Employee1 = new Employee(ANY_SALARY,ANY_NAME);
		StandardSalaryIncrease raise = new StandardSalaryIncrease(raiseAmount);
		//Act 
		Employee1.applySalaryIncrease(raise);
		//Assert
		assertTrue(Employee1.getAnnualSalary() == ANY_SALARY + (ANY_SALARY*raiseAmount));
	 }
	 
	 @Test 
	 public void GIVEN_OneEmployee_WHEN_MultipleRaisesAreGiven_THEN_TheSalaryWillBeReflectedAccordingly() 
	 {
		//Arrange
		float raiseAmount = StandardSalaryIncrease.MAXIMUM_RAISE-1; 
		Employee Employee1 = new Employee(ANY_SALARY,ANY_NAME);
		StandardSalaryIncrease raise = new StandardSalaryIncrease(raiseAmount);
		StandardSalaryIncrease raise2 = new StandardSalaryIncrease(raiseAmount);
		//Act 
		Employee1.applySalaryIncrease(raise);
		Employee1.applySalaryIncrease(raise2);
		float target = ANY_SALARY + (ANY_SALARY*raiseAmount);
		float target2 = target*raiseAmount;
		//Assert
		assertTrue(Employee1.getAnnualSalary() == target + target2);
	 }
}
