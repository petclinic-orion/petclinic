package org.springframework.samples.petclinic.math;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/math")
public class MathController {

	private final MathService mathService;

	@Autowired
	public MathController(MathService mathService) {
		this.mathService = mathService;
	}

	@PostMapping("/add")
	public double add(@RequestBody MathRequest request) {
		return mathService.add(request.getNumber1(), request.getNumber2());
	}

	@PostMapping("/subtract")
	public double subtract(@RequestBody MathRequest request) {
		return mathService.subtract(request.getNumber1(), request.getNumber2());
	}

	@PostMapping("/multiply")
	public double multiply(@RequestBody MathRequest request) {
		return mathService.multiply(request.getNumber1(), request.getNumber2());
	}

	@PostMapping("/divide")
	public double divide(@RequestBody MathRequest request) {
		return mathService.divide(request.getNumber1(), request.getNumber2());
	}

	@GetMapping("/pow")
	public double power(@RequestParam double base, @RequestParam double exponent) {
		return mathService.power(base, exponent);
	}

	@GetMapping("/sqrt")
	public double squareRoot(@RequestParam double number) {
		return mathService.squareRoot(number);
	}
}
