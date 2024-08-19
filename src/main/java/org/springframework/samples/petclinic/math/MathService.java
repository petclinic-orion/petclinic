package org.springframework.samples.petclinic.math;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MathService {

	private final MathOperationRepository mathOperationRepository;

	@Autowired
	public MathService(MathOperationRepository mathOperationRepository) {
		this.mathOperationRepository = mathOperationRepository;
	}

	public double add(double number1, double number2) {
		double result = number1 + number2;
		saveOperation("ADD", number1, number2, result);
		return result;
	}

	public double subtract(double number1, double number2) {
		double result = number1 - number2;
		saveOperation("SUBTRACT", number1, number2, result);
		return result;
	}

	public double multiply(double number1, double number2) {
		double result = number1 * number2;
		saveOperation("MULTIPLY", number1, number2, result);
		return result;
	}

	public double divide(double number1, double number2) {
		if (number2 == 0) {
			throw new IllegalArgumentException("Divider cannot be zero.");
		}
		double result = number1 / number2;
		saveOperation("DIVIDE", number1, number2, result);
		return result;
	}

	public double power(double base, double exponent) {
		double result = Math.pow(base, exponent);
		saveOperation("POWER", base, exponent, result);
		return result;
	}

	public double squareRoot(double number) {
		double result = Math.sqrt(number);
		saveOperation("SQUARE_ROOT", number, 0, result);  // İkinci parametre kullanılmadığından 0 veriyoruz.
		return result;
	}

	private void saveOperation(String operation, double number1, double number2, double result) {
		MathOperation mathOperation = new MathOperation(operation, number1, number2, result);
		mathOperationRepository.save(mathOperation);
	}
}
