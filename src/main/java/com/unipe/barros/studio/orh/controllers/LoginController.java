package com.unipe.barros.studio.orh.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.unipe.barros.studio.orh.enums.EnumPermissoes;
import com.unipe.barros.studio.orh.models.Usuario;
import com.unipe.barros.studio.orh.repositories.UsuarioRepository;

@Controller
@RequestMapping("/login")
@Transactional
public class LoginController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
//	@Autowired
//	private UsuarioDataSession usuarioDataSession;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		Usuario usuario = new Usuario();
		modelMap.addAttribute("usuario", usuario);
		return "login/form";
	}

	@RequestMapping(value = "/autenticar", method = RequestMethod.POST)
	public String auth(@ModelAttribute Usuario usuario, HttpSession session, ModelMap modelMap) {
		
		// ERRO 24/02/16 :: ALTERADO DE: USUARIOREPOSITORY PARA USUARIOJPACONSULTA
		Usuario usuarioAutenticado = usuarioRepository.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());

		if (!usuarioAutenticado.equals(null) && usuarioAutenticado != null) {
			if(usuarioAutenticado.getPermissao().equals(EnumPermissoes.FUNCIONARIO)){
				session.setAttribute("funcionario", Usuario.class);
			}
			session.setAttribute("usuario", usuarioAutenticado);
//			usuarioDataSession.setUsuario(usuario);
		} else {
			return "index";
		}
		return "index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/login/";
	}

}
