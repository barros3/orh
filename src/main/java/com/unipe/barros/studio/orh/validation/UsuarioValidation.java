package com.unipe.barros.studio.orh.validation;

import java.util.Calendar;
import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.unipe.barros.studio.orh.models.Usuario;

public class UsuarioValidation implements Validator{
		
	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "dataAdmissao", "A data de admissão não pode estar vazia!");
		Usuario u = (Usuario) target;
		Date date = u.getDataAdmissao();
		int hj = Calendar.DATE;
		if(date.getDay() > hj){
			errors.rejectValue("dataAdmissao", "A data de admissão não pode ser maior que a data de hoje!");
		}
	}

}
