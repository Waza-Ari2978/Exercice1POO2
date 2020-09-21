package employee;

public class StandardSalaryIncrease {
	/**
     * Constructeur d'objets de classe StandardSalaryIncrease
     */
	static final float MINIMUM_RAISE = 0.0f;
	static final float MAXIMUM_RAISE = 15.0f;
	private float raise;
	
    public StandardSalaryIncrease(float salaryIncreasePercentage)
    {
    	if (salaryIncreasePercentage <= MINIMUM_RAISE || salaryIncreasePercentage > MAXIMUM_RAISE) throw new IllegalArgumentException();
    	this.raise = salaryIncreasePercentage;
    }
    
    public float getSalaryIncreasePercentage(){
    	float salaryIncreasePercentage = this.raise;
    	
    	return salaryIncreasePercentage;
    }

	public float getSalaryIncreaseAmount(float salary) {
		float salaryIncreaseAmount = salary * this.getSalaryIncreasePercentage();
		
		return salaryIncreaseAmount;
	}
}
