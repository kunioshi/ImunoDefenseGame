package br.envyGames.imunoDefense.jogo.entidade;

import java.util.ArrayList;
import java.util.List;

import br.envyGames.imunoDefense.jogo.entidade.inimigo.Inimigo;
import br.envyGames.imunoDefense.jogo.entidade.torre.Torre;

public class FormaDeVidaColecao {
	private List<FormaDeVida> lista = new ArrayList<FormaDeVida>();
	
	public void adicionar(FormaDeVida item) {
		lista.add(item);
	}
	
	public void remover(FormaDeVida item) {
		lista.remove(item);
	}
	
	public boolean isVazia() {
		return lista.isEmpty();
	}
	
	public boolean hasTorre() {
		for (FormaDeVida item : lista)
			if (item instanceof Torre)
				return true;
		
		return false;
	}
	
	public boolean hasInimigo() {
		for (FormaDeVida item : lista)
			if (item instanceof Inimigo)
				return true;
		
		return false;
	}
	
	public List<FormaDeVida> getList() {
		return lista;
	}

}
