package com.unipe.barros.studio.orh.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.unipe.barros.studio.orh.models.Endereco;
import com.unipe.barros.studio.orh.models.Usuario;
import com.unipe.barros.studio.orh.repositories.EnderecoRepository;
import com.unipe.barros.studio.orh.repositories.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
@Transactional
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;

	@RequestMapping("/form")
	public ModelAndView form(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("usuario/form-add");
		return modelAndView;

	}

	@RequestMapping(value={"/novo-usuario"}, method = RequestMethod.GET)
	public ModelAndView novo(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("usuario/form-add");
		return modelAndView;
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public ModelAndView save(@Valid Usuario usuario, BindingResult bindingResult) {
				
		if (bindingResult.hasErrors()) {
			return form(usuario);
		}
		usuarioRepository.save(usuario);
		if(usuario != null){
			ModelMap mm = new ModelMap();
			mm.addAttribute("m", "Usuario salvo com SUCESSO !");
		}
		return new ModelAndView("redirect:/usuario/form");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("usuario/form-update");
		modelAndView.addObject("usuario", usuarioRepository.findOne(id));
		return modelAndView;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("usuario/list");
		modelAndView.addObject("paginatedList", usuarioRepository.findAll());
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Usuario usuario = usuarioRepository.findOne(id);
		usuarioRepository.delete(usuario);
		return "redirect:/usuario/list";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/form-update/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid Usuario usuario, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return new ModelAndView("usuario/form-update");
		}
		usuarioRepository.save(usuario);
		return new ModelAndView("redirect:/usuario/list");
	}
}
