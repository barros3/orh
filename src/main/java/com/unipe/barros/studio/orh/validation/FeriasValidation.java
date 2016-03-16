package com.unipe.barros.studio.orh.validation;

import java.util.Calendar;
import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.unipe.barros.studio.orh.models.Ferias;

public class FeriasValidation implements Validator{
		
	@Override
	public boolean supports(Class<?> clazz) {
		return Ferias.class.isAssignableFrom(clazz);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "dataInicio", "A data de admissão não pode estar vazia!");
		Ferias u = (Ferias) target;
		Date date = u.getDataFim();
		int hj = Calendar.DATE;
		if(date.getDay() > hj){
			errors.rejectValue("dataInicio", "A data de admissão não pode ser maior que a data de hoje!");
		}
	}

}
