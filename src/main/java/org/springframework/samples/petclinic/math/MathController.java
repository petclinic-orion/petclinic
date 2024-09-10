package org.springframework.samples.petclinic.math;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

	@Operation(summary = "Add 2 numbers.", description = "Adds 2 numbers that can be summed.", tags = { "Math" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful add",
					content = @Content(examples = @ExampleObject("0"))),
			@ApiResponse(responseCode = "500", description = "failed", content = @Content) })
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
