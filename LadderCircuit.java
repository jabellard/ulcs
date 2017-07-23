// Group [J Team]: Joe Nathan Abellard, Joel Lapompe, and Joel Singleton
// CET 3640 - [Class Session]
// Final Project
import java.util.Scanner;

public class LadderCircuit
{
	private double sourceVoltage;
	private double sourceCurrent;
	private double [] totalResistance; 
	private Resistor [] resistors; // array of Resistor objects

	// constructors
	LadderCircuit()
	{
		sourceVoltage = 1.0; // sourceVoltage = 1.0 Volts
		resistors = new Resistor[4]; // build a circuit consisting of 4 resistors
		// initialize resistor values
		for (int i = 0; i < resistors.length; i++)
		{
			resistors[i] = new Resistor();
		} // end for
		
		totalResistance = new double[3];
	}
	
	LadderCircuit(double sourceVoltage, int numbOfResistors)
	{
		if (sourceVoltage <= 0)
		{
			System.out.println("WARNING: Source Voltage must be greater than 0.0V; setting SourceVoltage to 1.0V");
			sourceVoltage = 1.0; // sourceVoltage = 1.0 Volts
		} // end if
		else
		{
			this.sourceVoltage = sourceVoltage;
		} // end else
		
		if (numbOfResistors < 4 || (numbOfResistors > 4 && numbOfResistors % 2 != 0))
		{
			System.out.println("WARNING: Number of resistors must be >= 4 and even; setting numbOfResitors to 4");
			resistors = new Resistor[4]; // build a circuit consisting of 4 resistors
			// initializing resistor values
			for (int i = 0; i < resistors.length; i++)
			{
				resistors[i] = new Resistor();
			} // end for
		
			totalResistance = new double[3];
		} // end if
		else
		{
			resistors = new Resistor[numbOfResistors]; 
			// initializing resistor values
			for (int i = 0; i < resistors.length; i++)
			{
				resistors[i] = new Resistor();
			} // end for
			totalResistance = new double[numbOfResistors - 1];
		}
	} 
	
	// accessor methods
	double getSourceVoltage()
	{
		return sourceVoltage;
	} // end method getSourceVoltage
	
	double getSourceCurrent()
	{
		return sourceCurrent;
	} // end method getSourceCurrent
	
	
	
	public void setResitorValues()
	{
		Scanner input = new Scanner(System.in);
		double recievedResistance;
		for (int i = 0; i < resistors.length; i++)
		{
			System.out.println("Enter the resistance (in ohms) for resitor # " + (i + 1) + ": ");
			recievedResistance = input.nextDouble();
			resistors[i].setResitance(recievedResistance); // set the resistance
		} // end for
		 
		//r1.setResitance(15.5);
		//System.out.println(r1.getResistance());
		
	} // end method setResitorValues
	
	void calculateTotalResitance()
	{
		totalResistance[0]= resistors[resistors.length - 1].getResistance()
				+ resistors[resistors.length - 2].getResistance();

		for (int i = 1; i < resistors.length - 1; i++) 
		{
			if (i % 2 != 0)
			{
				totalResistance[i] = (totalResistance[i - 1] * resistors[resistors.length - (i + 2)].getResistance()) /
						( totalResistance[i - 1] + resistors[resistors.length - (i + 2)].getResistance() );
			} // end if
			else
			{
				totalResistance[i] = totalResistance[i - 1] + resistors[resistors.length - (i + 2)].getResistance();
			} // end else
		} // end for
		totalResistance[totalResistance.length - 1] = resistors[0].getResistance() + 
				totalResistance[totalResistance.length - 2]; // the final total resistance (RT)
		} // end method calculateTotalResitance
	
	void calculateBranchCurrents()
	{
		// calculate the source current
		setSourceCurrent();
		resistors[0].setCurrent(getSourceCurrent());
		for (int i = 1; i < resistors.length - 1; i++)
		{
			if (i % 2 != 0)
			{
				double oddBranchCurrent = (resistors[i - 1].getCurrent() * totalResistance[resistors.length - (i + 3)]) /
				(totalResistance[resistors.length - (i + 3)] + resistors[i].getResistance());
				resistors[i].setCurrent(oddBranchCurrent);
			} // end if
			else
			{
				double evenBranchCurrent = (resistors[i - 2].getCurrent() * resistors[i - 1].getResistance()) /
						(totalResistance[resistors.length - (i + 2)] + resistors[i - 1].getResistance());
				resistors[i].setCurrent(evenBranchCurrent);
			} // end else
			resistors[resistors.length - 1].setCurrent(resistors[resistors.length - 2].getCurrent());
		} // end for
	} // end method calculateBranchCurrents
	double getTotalResistance()
	{
		return totalResistance[totalResistance.length - 1];
	} // end method getTotalResistance
	
	void setSourceCurrent()
	{
		sourceCurrent = sourceVoltage / totalResistance[totalResistance.length - 1];
	} // end method setSourceCurrent
	
	void finalOutput()
	{
		System.out.printf("The Source voltage of the ladder circuit is %.5f volts%n", sourceVoltage);
		System.out.printf("The Total Resistance of the ladder circuit is %.5f ohms%n", getTotalResistance());
		System.out.printf("The Source current of the ladder circuit is %.5f amperes%n", sourceCurrent);
		System.out.println(" Here are the values of Conductance, Current, Voltage, and Power across each Resistor:");
		
		for (int i = 0; i < resistors.length; i++)
		{
			System.out.println("Resistor # " + (i + 1));
			resistors[i].displayQuantities(); // print everything
		} // end for
	} // end method finalOutput
	} // end class LadderCircuit


	
		


