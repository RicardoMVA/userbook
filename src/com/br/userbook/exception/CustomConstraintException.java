package com.br.userbook.exception;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.br.userbook.model.Phone;
import com.br.userbook.model.User;

public class CustomConstraintException extends ConstraintViolationException {

	/**
	 * This exception returns a string that is build upon the result of the
	 * ConstraintViolationException.getConstraintViolations() entries
	 */
	private static final long serialVersionUID = 1L;

	public CustomConstraintException(Set<ConstraintViolation<?>> constraintViolations) {
		super(constraintViolations);
	}

	public CustomConstraintException(String string, Set<ConstraintViolation<User>> constraintViolations) {
		super(constraintViolations);
	}

	public CustomConstraintException(Set<ConstraintViolation<Phone>> constraintViolations, String string) {
		super(constraintViolations);
	}

	@Override
	public String getMessage() {
		String errors = super.getConstraintViolations().stream().map(cv -> cv == null ? "null" : cv.getMessage())
				.collect(Collectors.joining(", "));

		return errors;
	}

}
