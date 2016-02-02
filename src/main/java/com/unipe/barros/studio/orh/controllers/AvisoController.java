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

import com.unipe.barros.studio.orh.models.Aviso;
import com.unipe.barros.studio.orh.repositories.AvisoRepository;

@Controller
@RequestMapping("/aviso")
@Transactional
public class AvisoController {

	@Autowired
	AvisoRepository avisoRepository;

	@RequestMapping("/form")
	public ModelAndView form(Aviso aviso) {
		ModelAndView modelAndView = new ModelAndView("aviso/form-add");
		return modelAndView;

	}

	@RequestMapping(value={"/novo-aviso"}, method = RequestMethod.GET)
	public ModelAndView novo(Aviso aviso) {
		ModelAndView modelAndView = new ModelAndView("aviso/form-add");
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@Valid Aviso aviso, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(aviso);
		}
		aviso.setDescricao(aviso.getDescricao());
		aviso.setId(aviso.getId());
		aviso.setTitulo(aviso.getTitulo());
		avisoRepository.save(aviso);
		return new ModelAndView("redirect:/aviso/novo-aviso");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/load/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("aviso/form-update");
		modelAndView.addObject("aviso", avisoRepository.findOne(id));
		return modelAndView;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("aviso/list");
		modelAndView.addObject("paginatedList", avisoRepository.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value = "/list-visu", method = RequestMethod.GET)
	public ModelAndView listVisualizacao() {
		ModelAndView modelAndView = new ModelAndView("aviso/list-visu");
		modelAndView.addObject("paginatedList", avisoRepository.findAll());
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Aviso aviso = avisoRepository.findOne(id);
		avisoRepository.delete(aviso);
		return "redirect:/aviso/list";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/form-update/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid Aviso aviso, BindingResult bindingResult) {
		aviso.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("aviso/form-update");
		}
		avisoRepository.save(aviso);
		return new ModelAndView("redirect:/aviso/list");
	}
}
