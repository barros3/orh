package com.unipe.barros.studio.orh.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.unipe.barros.studio.orh.models.Falta;
import com.unipe.barros.studio.orh.repositories.FaltaRepository;

@Controller
@RequestMapping("/falta")
@Transactional
public class FaltaController {

	@Autowired
	FaltaRepository faltaRepository;

	@RequestMapping("/form")
	public ModelAndView form(Falta falta) {
		ModelAndView modelAndView = new ModelAndView("falta/form-add");
		return modelAndView;

	}

	@RequestMapping(value={"/novo-falta"}, method = RequestMethod.GET)
	public ModelAndView novo(Falta falta) {
		ModelAndView modelAndView = new ModelAndView("falta/form-add");
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@Valid Falta falta, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(falta);
		}
		faltaRepository.save(falta);
		return new ModelAndView("redirect:/falta/novo-falta");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/load/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("falta/form-update");
		modelAndView.addObject("falta", faltaRepository.findOne(id));
		return modelAndView;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("falta/list");
		modelAndView.addObject("paginatedList", faltaRepository.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value = "/list-visu", method = RequestMethod.GET)
	public ModelAndView listVisualizacao() {
		ModelAndView modelAndView = new ModelAndView("falta/list-visu");
		modelAndView.addObject("paginatedList", faltaRepository.findAll());
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Falta falta = faltaRepository.findOne(id);
		faltaRepository.delete(falta);
		return "redirect:/falta/list";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/form-update/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid Falta falta, BindingResult bindingResult) {
		falta.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("falta/form-update");
		}
		faltaRepository.save(falta);
		return new ModelAndView("redirect:/falta/list");
	}
}
