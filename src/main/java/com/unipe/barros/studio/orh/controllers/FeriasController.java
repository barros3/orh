package com.unipe.barros.studio.orh.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sun.beans.editors.EnumEditor;
import com.unipe.barros.studio.orh.enums.EnumPermissoes;
import com.unipe.barros.studio.orh.enums.EnumStatusFerias;
import com.unipe.barros.studio.orh.models.Ferias;
import com.unipe.barros.studio.orh.repositories.FeriasRepository;
import com.unipe.barros.studio.orh.validation.FeriasValidation;

@Controller
@RequestMapping("/ferias")
@Transactional
public class FeriasController {

	@Autowired
	FeriasRepository feriasRepository;

	@RequestMapping("/form")
	public ModelAndView form(Ferias ferias) {
		ModelAndView modelAndView = new ModelAndView("ferias/form-add");
		return modelAndView;

	}

	@RequestMapping(value={"/novo-ferias"}, method = RequestMethod.GET)
	public ModelAndView novo(Ferias ferias) {
		ModelAndView modelAndView = new ModelAndView("ferias/form-add");
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@Valid Ferias ferias, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(ferias);
		}
		feriasRepository.save(ferias);
		return new ModelAndView("redirect:/ferias/novo-ferias");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/load/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("ferias/form-update");
		modelAndView.addObject("ferias", feriasRepository.findOne(id));
		return modelAndView;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("ferias/list");
		modelAndView.addObject("paginatedList", feriasRepository.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value = "/list-visu", method = RequestMethod.GET)
	public ModelAndView listVisualizacao() {
		ModelAndView modelAndView = new ModelAndView("ferias/list-visu");
		modelAndView.addObject("paginatedList", feriasRepository.findAll());
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Ferias ferias = feriasRepository.findOne(id);
		feriasRepository.delete(ferias);
		return "redirect:/ferias/list";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/form-update/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid Ferias ferias, BindingResult bindingResult) {
		ferias.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("ferias/form-update");
		}
		feriasRepository.save(ferias);
		return new ModelAndView("redirect:/ferias/list");
	}
	
	FeriasValidation feriasValidation;
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		binder.addValidators(feriasValidation);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "dataInicio", new CustomDateEditor(dateFormat, true));
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), false));
    }
	
	@InitBinder
	protected void referenceData(HttpServletRequest request) throws Exception {
		Map referenceStatusFerias = new HashMap();
		Map<String, EnumStatusFerias> statusFeriasMap = new LinkedHashMap<String, EnumStatusFerias>();
		statusFeriasMap.put("NONE", EnumStatusFerias.NONE);
		statusFeriasMap.put("SOLICITADA", EnumStatusFerias.SOLICITADA);
		statusFeriasMap.put("VENDIDA", EnumStatusFerias.VENDIDA);
		statusFeriasMap.put("ANDAMENTO", EnumStatusFerias.ANDAMENTO);
		statusFeriasMap.put("AUTORIZADA", EnumStatusFerias.AUTORIZADA);
		referenceStatusFerias.put("EnumStatusFerias", statusFeriasMap);
	}
}
