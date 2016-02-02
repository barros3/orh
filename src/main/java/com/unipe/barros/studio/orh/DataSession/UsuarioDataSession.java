package com.unipe.barros.studio.orh.DataSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.unipe.barros.studio.orh.models.Usuario;

@Component
@Scope("session")
public class UsuarioDataSession {
	
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
