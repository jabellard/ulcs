// Group [J Team]: Joe Nathan Abellard, Joel Lapompe, and Joel Singleton
// CET 3640 - [Class Session]
// Final Project
import java.util.Scanner;

public class CircuitDriver 
{
	public static void main(String[] args)
	{
		System.out.println("------------Welcome to the ladder circuit solver------------");
		System.out.println("Enter the source voltage (in Volts)of the circuit:");
		Scanner input = new Scanner(System.in);
		double sourceVoltage = input.nextDouble(); // read the source voltage
		System.out.println("Enter the number of resistors the circuit consists of (4 + 2n):");
		int numbOfResistors = input.nextInt();
		System.out.println("Creating circuit...");
		LadderCircuit circuit0 = new LadderCircuit(sourceVoltage, numbOfResistors);
		circuit0.setResitorValues();
		circuit0.calculateTotalResitance();
		circuit0.calculateBranchCurrents();
		circuit0.finalOutput();
	} // end method main
} // end class CircuitDriver
