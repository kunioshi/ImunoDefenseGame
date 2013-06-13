package br.envyGames.imunoDefense.motor;

import s3t.gameControl.system.GameSystem;

public class EntidadeGerenciador {

	public void adicionarEntidade(Entidade entidade) {
		GameSystem.getEntityCollection().addEntity(entidade);
	}
	
	public Entidade getEntidadePorNome(String nome) {
		return (Entidade)GameSystem.getEntityCollection().getEntityByName(nome);
	}
	
	public void removerEntidade(Entidade entidade) {
		GameSystem.getEntityCollection().removeEntity(entidade);
	}
	
	public void removerEntidade(String nome) {
		GameSystem.getEntityCollection().removeEntity(nome);
	}
	
	public void clear() {
		GameSystem.getEntityCollection().clear();
	}
}
