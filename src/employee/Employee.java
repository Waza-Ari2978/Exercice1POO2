package employee;

import java.util.ArrayList;

/**
 * @author Cédric Bouchard
 * @version 2020
 */
public class Employee
{
    private int employeeNb;
    private String employeeName;
    private int salary;
    private static int employeeNumber = 0;
    public final int EMPLOYEE_NUMBER_INCREMENT = 10;
    private ArrayList<StandardSalaryIncrease> historyOfSalaryIncrease = new ArrayList<StandardSalaryIncrease>();

    /**
     * Constructeur d'objets de classe Employee
     */
    public Employee(int salary, String employeeName)
    {
    	if (salary > 100000 || salary < 0) throw new IllegalArgumentException();
    	if (employeeName == "") throw new IllegalArgumentException();
        this.salary = salary;
        this.employeeName = employeeName;
        this.employeeNb = employeeNumber+EMPLOYEE_NUMBER_INCREMENT;
        employeeNumber = employeeNumber+EMPLOYEE_NUMBER_INCREMENT;
    }
    public int getEmployeeNb() {
    	int employeeNb = 0;
    	employeeNb = this.employeeNb;
    	return employeeNb;
    }
    public void applySalaryIncrease(StandardSalaryIncrease raise) {
    	this.historyOfSalaryIncrease.add(raise);
    }
	public float getAnnualSalary() {
		float annualSalary = this.salary;
		for (StandardSalaryIncrease i : historyOfSalaryIncrease) {
				float salaryIncreaseAmount = i.getSalaryIncreaseAmount(annualSalary);
				annualSalary+= salaryIncreaseAmount;
		    }
		
		
		
		return annualSalary;
	}
}