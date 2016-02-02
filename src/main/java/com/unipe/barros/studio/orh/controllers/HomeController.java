package com.unipe.barros.studio.orh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unipe.barros.studio.orh.DataSession.UsuarioDataSession;
import com.unipe.barros.studio.orh.models.Usuario;

@Controller
public class HomeController {
	
//	@Autowired
//	UsuarioDataSession usuarioDataSession;
	
	@RequestMapping("/")
	public String index() {
		
//		Usuario usuario = usuarioDataSession.getUsuario();
		
		return "index";
	}
}
