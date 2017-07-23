// Group [J Team]: Joe Nathan Abellard, Joel Lapompe, and Joel Singleton
// CET 3640 - [Class Session]
// Final Project
public class Resistor 
{

	private double resistance; // the resistance of the resistor
	private double current; // the current across the resistor
	private double voltage; // the voltage drop across the resistor
	private double conductance; // the conductance of the resistor [1 / resistance]
	private double power; // the power delivered to the resistor
	
	// default constructor
	Resistor()
	{
		this.resistance = 1.0; // initial value of resistor is 1 ohm
		this.conductance = 1.0 / this.resistance; 
	} // end default constructor
	
	Resistor(double resistance)
	{
		if (resistance <= 0)
		{
			this.resistance = 1.0;
		} 
		else
		{
			this.resistance = resistance;
		}
		this.conductance = 1.0 / this.resistance; 
	}
	
	// accessor methods
	
	double getResistance()
	{
		return resistance;
	} // end method getResistance
	
	double getConductance()
	{
		updateQuantities();
		return conductance;
	} // end method getConductance
	
	double getCurrent()
	{
		return current;
	} // end method getCurrent
	
	double getVoltage()
	{
		updateQuantities();
		return voltage;
	} // end method getVoltage
	
	double getPower()
	{
		updateQuantities();
		return power;
	} // end method getPower
	
	// mutator methods
	
	void setCurrent(double current)
	{
		this.current = current;
	} // end method setCurrent
	
	
	void updateQuantities()
	{
		conductance = 1.0 / resistance;
		voltage = current * resistance; // set the voltage
		power = current * voltage; // the the power
	} // end method updateQuantities
	public void setResitance(double resistance)
	{
		if (resistance <= 0)
		{
			System.out.println("WARNING: Resistance value must be greater than 0; setting value to 1.0 ohms");
			this.resistance = 1.0;
		} 
		else
		{
			this.resistance = resistance;
		}
	} // end method setResistance
	void displayQuantities()
	{
		System.out.printf("Resistance = %.5f ohms%n", getResistance());
		System.out.printf("Conductance = %.5f ohms^-1%n", getConductance());
		System.out.printf("Current = %.5f amperes%n",getCurrent());
		System.out.printf("Voltage = %.5f volts%n", getVoltage());
		System.out.printf("Power = %.5f watts%n", getPower());
		System.out.printf("----------------------------------------------" + "%n");
	} // end method displayQuantities
} // end class Resistor
