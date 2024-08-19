package org.springframework.samples.petclinic.math;


import jakarta.persistence.*;

@Entity
@Table(name = "math_operations")
public class MathOperation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String operation;
	private double number1;
	private double number2;
	private double result;

	// Constructors
	public MathOperation() {}

	public MathOperation(String operation, double number1, double number2, double result) {
		this.operation = operation;
		this.number1 = number1;
		this.number2 = number2;
		this.result = result;
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public double getNumber1() {
		return number1;
	}

	public void setNumber1(double number1) {
		this.number1 = number1;
	}

	public double getNumber2() {
		return number2;
	}

	public void setNumber2(double number2) {
		this.number2 = number2;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
}
