package com.unipe.barros.studio.orh.interceptors;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControleAcessoInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		if (uri.endsWith("login") || uri.endsWith("autenticar")) {
			return true;
		}
		if((uri.endsWith("novo-usuario") || uri.endsWith("novo-aviso") || uri.endsWith("save") || uri.endsWith("list")) && session.getAttribute("funcionario") != null){
			response.sendRedirect("/orh/");
			return false;
		}

		if (session.getAttribute("usuario") != null) {
			return true;
		}
		response.sendRedirect(request.getContextPath() + "/login");
		return false;
	}
}
