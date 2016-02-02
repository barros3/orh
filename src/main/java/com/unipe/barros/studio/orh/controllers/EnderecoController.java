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

import com.unipe.barros.studio.orh.models.Endereco;
import com.unipe.barros.studio.orh.repositories.EnderecoRepository;

@Controller
@RequestMapping("/endereco")
@Transactional
public class EnderecoController {

	@Autowired
	EnderecoRepository enderecoRepository;

	@RequestMapping("/form")
	public ModelAndView form(Endereco endereco) {
		ModelAndView modelAndView = new ModelAndView("endereco/form-add");
		return modelAndView;

	}

	@RequestMapping(value={"/novo-endereco"}, method = RequestMethod.GET)
	public ModelAndView novo(Endereco endereco) {
		ModelAndView modelAndView = new ModelAndView("endereco/form-add");
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@Valid Endereco endereco, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(endereco);
		}
		return new ModelAndView("redirect:/endereco/novo-endereco");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/load/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("endereco/form-update");
		modelAndView.addObject("endereco", enderecoRepository.findOne(id));
		return modelAndView;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("endereco/list");
		modelAndView.addObject("paginatedList", enderecoRepository.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value = "/list-visu", method = RequestMethod.GET)
	public ModelAndView listVisualizacao() {
		ModelAndView modelAndView = new ModelAndView("endereco/list-visu");
		modelAndView.addObject("paginatedList", enderecoRepository.findAll());
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Endereco endereco = enderecoRepository.findOne(id);
		enderecoRepository.delete(endereco);
		return "redirect:/endereco/list";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/form-update/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid Endereco endereco, BindingResult bindingResult) {
		endereco.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("endereco/form-update");
		}
		enderecoRepository.save(endereco);
		return new ModelAndView("redirect:/endereco/list");
	}
}
