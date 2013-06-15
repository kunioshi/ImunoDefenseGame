package br.envyGames.imunoDefense.motor;

import java.util.ArrayList;
import java.util.List;

import s3t.gameEntities.Entity;

public class Entidade extends Entity {
	
	private List<DestruirEntidadeListener> destruirEntidadeListeners;

	public Entidade(String nome, double x, double y, Cenario cenario) {
		super(nome, x, y, cenario);
		
		destruirEntidadeListeners = new ArrayList<DestruirEntidadeListener>();
	}
	
	public void definirImagemColecao(ImagemColecao imagem) {
		setImageCollection(imagem);
	}
	
	public Cenario getCenario() {
		return (Cenario) this.getScenario();
	}
	
	public void destruir() {
		fireRemoverAtirarEvent();
	}
	
	public void addDestruirEntidadeListener(DestruirEntidadeListener listener) {
		destruirEntidadeListeners.add(listener);
	}
	
	public void removeDestruirEntidadeListener(DestruirEntidadeListener listener) {
		destruirEntidadeListeners.remove(listener);
	}
	
	private void fireRemoverAtirarEvent() {
		for (DestruirEntidadeListener listener : destruirEntidadeListeners)
			listener.handleDestruirEntidade(this);
	}

}
