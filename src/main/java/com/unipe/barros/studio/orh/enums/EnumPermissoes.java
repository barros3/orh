package com.unipe.barros.studio.orh.enums;

public enum EnumPermissoes {
	
	NONE(0), ADMIN(1), GERENTE(2), FUNCIONARIO(3);

	private int opcao;

	EnumPermissoes(int opcao) {	
	this.opcao = opcao;
	}

	public int getOpcao(){
		return this.opcao;
	}
}

