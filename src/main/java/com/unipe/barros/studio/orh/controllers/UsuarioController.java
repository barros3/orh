package com.unipe.barros.studio.orh.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unipe.barros.studio.orh.enums.EnumPermissoes;
import com.unipe.barros.studio.orh.models.Usuario;
import com.unipe.barros.studio.orh.repositories.EnderecoRepository;
import com.unipe.barros.studio.orh.repositories.PaginatedRepository;
import com.unipe.barros.studio.orh.repositories.UsuarioRepository;
import com.unipe.barros.studio.orh.validation.UsuarioValidation;

/**
 * @author Luciano Barros
 *
 */

@Controller
@RequestMapping("/usuario")
@Transactional
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	PaginatedRepository paginatedRepository;

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
		ModelAndView modelAndView = new ModelAndView();
		
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorAoListar", "Erro ao realizar a buscar, tente novamente!");
		}
		
		usuarioRepository.save(usuario);
		if(!usuario.equals(null) && usuario != null){
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
	
	@RequestMapping(method = RequestMethod.GET)
   public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page){
      ModelAndView modelAndView = new ModelAndView("usuario/list");
      modelAndView.addObject("paginatedList", paginatedRepository.paginatedList(page, 10));
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
			return new ModelAndView("errorAoListar", "Erro ao realizar a buscar, tente novamente!", Entity.class);
//			return new ModelAndView("usuario/form-update");
		}
		usuarioRepository.save(usuario);
		return new ModelAndView("redirect:/usuario/list");
	}

	UsuarioValidation usuarioValidation;
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		binder.addValidators(usuarioValidation);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "dataAdmissao", new CustomDateEditor(dateFormat, true));
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), false));
    }
	
	@InitBinder
	protected void referenceData(HttpServletRequest request) throws Exception {
		Map referenceStatusPermissao = new HashMap();
		Map<String, EnumPermissoes> permissaoMap = new LinkedHashMap<String, EnumPermissoes>();
		permissaoMap.put("NONE", EnumPermissoes.NONE);
		permissaoMap.put("GERENTE", EnumPermissoes.GERENTE);
		permissaoMap.put("FUNCIONARIO", EnumPermissoes.FUNCIONARIO);
		referenceStatusPermissao.put("EnumPermissoes", permissaoMap);
	}
	
	@RequestMapping(value = "/listPesquisa", method = RequestMethod.GET)
	public ModelAndView listPesquisa( @Param(value="nome") String nome,
				@Param(value = "cpf") String cpf, 
				@Param(value = "matricula") String matricula)	{
		
		List<Usuario> usuarioList = new ArrayList<Usuario>();
		ModelAndView modelAndView = new ModelAndView("usuario/list");
		
//		if (bindingResult.getTarget().equals(usuario) || bindingResult.hasErrors()) {
//			return modelAndView.addObject("errorAoListar", "Erro ao realizar a buscar, tente novamente!");
//		}
		try{
			if(cpf != ""){			
				int cpfConv = (int) Integer.parseInt(cpf);
				if(!nome.equals("") && matricula.equals("")){
					usuarioList = usuarioRepository.findByNomeMatriculaCpf(nome, matricula, cpfConv);
					return modelAndView.addObject("paginatedList", usuarioList);
				}
				if(nome.equals("") && !matricula.equals("")){
					usuarioList = usuarioRepository.findByMatriculaCpf(matricula, cpfConv);
					return modelAndView.addObject("paginatedList", usuarioList);
				}
				if(!nome.equals("") && matricula.equals("")){
					usuarioList = usuarioRepository.findByNomeCpf(nome, cpfConv);
					return modelAndView.addObject("paginatedList", usuarioList);
				}else
					usuarioList = usuarioRepository.findByCpf(cpfConv);
					return modelAndView.addObject("paginatedList", usuarioList);
			}	
			else {
				if(!nome.equals("") && !matricula.equals("")){
					usuarioList = usuarioRepository.findByNomeMatricula(nome, matricula);	
					return modelAndView.addObject("paginatedList", usuarioList);
				}
				if(nome.equals("") && !matricula.equals("")){
					usuarioList = usuarioRepository.findByMatricula(matricula);	
					return modelAndView.addObject("paginatedList", usuarioList);
				}
				if(!nome.equals("") && matricula.equals("")){
					usuarioList = usuarioRepository.findByNome(nome);	
					return modelAndView.addObject("paginatedList", usuarioList);
				}
			}	
					
		}catch(Exception e){
			e.printStackTrace();
			modelAndView.addObject("errorAoListar", "Erro ao realizar a buscar, tente novamente!");
		}
		return modelAndView;
	}
}
