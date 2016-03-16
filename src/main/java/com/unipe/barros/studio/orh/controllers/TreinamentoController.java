package com.unipe.barros.studio.orh.controllers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.unipe.barros.studio.orh.enums.EnumStatusFerias;
import com.unipe.barros.studio.orh.enums.EnumStatusVagasDisponiveis;
import com.unipe.barros.studio.orh.models.Treinamento;
import com.unipe.barros.studio.orh.repositories.EnderecoRepository;
import com.unipe.barros.studio.orh.repositories.TreinamentoRepository;

@Controller
@RequestMapping("/treinamento")
@Transactional
public class TreinamentoController {

	@Autowired
	TreinamentoRepository treinamentoRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;

	@RequestMapping("/form")
	public ModelAndView form(Treinamento treinamento) {
		ModelAndView modelAndView = new ModelAndView("treinamento/form-add");
		return modelAndView;

	}

	@RequestMapping(value={"/novo-treinamento"}, method = RequestMethod.GET)
	public ModelAndView novo(Treinamento treinamento) {
		ModelAndView modelAndView = new ModelAndView("treinamento/form-add");
		return modelAndView;
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public ModelAndView save(@Valid Treinamento treinamento, BindingResult bindingResult) {				
		if (bindingResult.hasErrors()) {
			return form(treinamento);
		}
		
		
		treinamentoRepository.save(treinamento);
		if(!treinamento.equals(null) && treinamento != null){
			ModelMap mm = new ModelMap();
			mm.addAttribute("m", "Treinamento salvo com SUCESSO !");
		}
		return new ModelAndView("redirect:/treinamento/form-add");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("treinamento/form-update");
		modelAndView.addObject("treinamento", treinamentoRepository.findOne(id));
		return modelAndView;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("treinamento/list");
		modelAndView.addObject("paginatedList", treinamentoRepository.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value = "/list-visu", method = RequestMethod.GET)
	public ModelAndView listVisualizacao() {
		ModelAndView modelAndView = new ModelAndView("treinamento/list-visu");
		modelAndView.addObject("paginatedList", treinamentoRepository.findAll());
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Treinamento treinamento = treinamentoRepository.findOne(id);
		treinamentoRepository.delete(treinamento);
		return "redirect:/treinamento/list";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/form-update/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid Treinamento treinamento, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return new ModelAndView("treinamento/form-update");
		}
		treinamentoRepository.save(treinamento);
		return new ModelAndView("redirect:/treinamento/list");
	}
	
	@InitBinder
	protected void referenceData(HttpServletRequest request) throws Exception {
		Map referenceStatusFerias = new HashMap();
		Map<String, EnumStatusVagasDisponiveis> statusVagasMap = new LinkedHashMap<String, EnumStatusVagasDisponiveis>();
		statusVagasMap.put("NONE", EnumStatusVagasDisponiveis.NONE);
		statusVagasMap.put("DISPONIVEL", EnumStatusVagasDisponiveis.DISPONIVEL);
		statusVagasMap.put("LOTADO", EnumStatusVagasDisponiveis.LOTADO);
		referenceStatusFerias.put("EnumStatusVagasDisponiveis", statusVagasMap);
	}
}
