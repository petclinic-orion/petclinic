/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * PetClinic Spring Boot Application.
 *
 * @author Dave Syer
 *
 */
@SpringBootApplication
@ImportRuntimeHints(PetClinicRuntimeHints.class)
@OpenAPIDefinition(info = @Info(version = "1.0",
	title = "PetClinicApplication API",
	description = "All Administration Operations"))
public class PetClinicApplication {

	private static final Logger logger = LogManager.getLogger(PetClinicApplication.class);

	public static void main(String[] args) {

		logger.info("This is an INFO log message");
		logger.warn("This is a WARN log message");
		logger.error("This is an ERROR log message");


		SpringApplication.run(PetClinicApplication.class, args);
	}

}
