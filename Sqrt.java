package gui;

public class Sqrt implements OperationInterface{

	@Override
	public double calculate(double a, double b) {
		return Math.sqrt(a);
	}

}
