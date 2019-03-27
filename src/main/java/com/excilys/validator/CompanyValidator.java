package com.excilys.validator;

import com.excilys.exception.ValidatorException;
import com.excilys.model.Company;
import com.excilys.service.CompanyService;

public class CompanyValidator {

	public static void exist(Company comp) throws ValidatorException {
		if(comp == null) 
			throw new ValidatorException("Impossible to have a company with null");

		if(comp.getId() < 0L) 
			throw new ValidatorException("Impossible to have a company with id negative");

		if(!CompanyService.getInstance().findById(comp.getId()).isPresent())
			throw new ValidatorException("Impossible to have a company with id = " + comp.getId());
		
		if(comp.getName() == null || comp.getName().equals("")) 
			throw new ValidatorException("Impossible to have a company without or with an empty name");
		
	}
}
