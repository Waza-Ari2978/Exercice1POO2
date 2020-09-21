package employee;

import org.junit.Test;

public class StandardSalaryIncreaseTest {
	
	private final String ANY_NAME = "Bob";
	private final int ANY_SALARY = 20000;
	
	@Test (expected = IllegalArgumentException.class)
	 public void GIVEN_RaiseIsLessThanZeroPercent_WHEN_RaiseIsGiven() 
	 {
		//Arrange
		Employee employee = new Employee(ANY_SALARY,ANY_NAME);
		float raise = StandardSalaryIncrease.MINIMUM_RAISE;
		
		//Act 
		new StandardSalaryIncrease(raise);
	 }
	
	@Test (expected = IllegalArgumentException.class)
	 public void GIVEN_RaiseIsMoreThanFifteenPercent_WHEN_RaiseIsGiven() 
	 {
		//Arrange
		float raise = StandardSalaryIncrease.MAXIMUM_RAISE + 0.1f;
		
		//Act 
		new StandardSalaryIncrease(raise);
	 }
}
