package org.springframework.samples.petclinic.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Log {

	@Before("within(@org.springframework.stereotype.Controller *) ")
	public void logControllerMethods(JoinPoint joinPoint){
		System.out.println("Received request: " + joinPoint.getTarget().getClass().getSimpleName());

	}

}
