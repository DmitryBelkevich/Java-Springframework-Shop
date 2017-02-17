package com.hard.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.hard.models.Model;

public class HibernateValidator {
	public static void validation(Model model) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		
		Set<ConstraintViolation<Model>> constrs = validator.validate(model);
		
		for (ConstraintViolation<Model> constr : constrs) {
			StringBuilder stringBuilder = new StringBuilder();
			
			stringBuilder.append("property: ");
			stringBuilder.append(constr.getPropertyPath());
			
			stringBuilder.append("; value: ");
			stringBuilder.append(constr.getInvalidValue());
			
			stringBuilder.append("; message: ");
			stringBuilder.append(constr.getMessage());
			
			System.out.println(stringBuilder.toString());
		}
	}
}