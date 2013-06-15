package br.envyGames.imunoDefense.jogo.entidade.torre;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import br.envyGames.imunoDefense.jogo.entidade.FormaDeVida;
import br.envyGames.imunoDefense.jogo.entidade.Tiro;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.Inimigo;
import br.envyGames.imunoDefense.motor.AdicionarRemoverEntidadeListener;
import br.envyGames.imunoDefense.motor.AlterarCenarioListener;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ImagemAnimada;
import br.envyGames.imunoDefense.motor.ImagemColecao;

public abstract class Torre extends FormaDeVida {
	protected Imagem imagemLevel1 = null;
	protected ImagemAnimada animacaoLevel1 = null;
	protected Imagem tiroImagem = null;
	protected int forca = 0;
	protected int velocidade = 0;
	protected int alcance = 0;
	protected TipoAtaque tipoAtaque;
	private int level = 1;
	
	private List<AtirarListener> atirarListeners;

	/*
	 * Construtor
	 * @param <code>nomeInstancia</code> - Nome do inimigo do qual será usado para encontra-lo na EntityCollection.
	 * @param <code>xy</code>   - Coordenadas "(x, y)" iniciais. 
	 */
	public Torre(String nomeInstancia, Point xy, Cenario cenario) {
		super(nomeInstancia, xy, cenario);
		
		this.vida = 100;
		atirarListeners = new ArrayList<AtirarListener>();
	}
	
	// Getters & Setters
	public int getForca() { return forca; }
	public int getLevel() { return level; }
	public int getVelocidade() { return velocidade; }
	public int getAlcance() { return alcance; }
	public TipoAtaque getTipoAtaque() { return tipoAtaque; }
	
	public void setForca(int dano) { forca = dano; }
	public void upgrade() { 
		level++; 
		forca++;
		vida *= 1.5;
	}
	
	public boolean isUpgradable() {
		return level <= 2;
	}
	
	@Override
	public void receberDano(int dano) {
		super.receberDano(dano);
		
		if(getImageKey() == "dano")
			setImageKey("default");
		else
			setImageKey("dano");
	}
	
	public void addAtirarListener(AtirarListener listener) {
		atirarListeners.add(listener);
	}
	
	public void removeAtirarListener(AtirarListener listener) {
		atirarListeners.remove(listener);
	}
	
	public void atirar(Inimigo alvo) {
		fireRemoverAtirarEvent(criarTiro(alvo));
	}

	private Tiro criarTiro(Inimigo alvo) {
		return new Tiro(this.getX(), this.getY(), tiroImagem, alvo, this.getCenario());
	}
	
	protected void carregarSequenciaImagem() {
		ImagemColecao imagemColecao = new ImagemColecao();
		imagemColecao.add("default", imagemLevel1);
		imagemColecao.add("dano", animacaoLevel1);
		imagemColecao.definirImagemPadrao("default");
		
		definirImagemColecao(imagemColecao);
	}
	
	private void fireRemoverAtirarEvent(Tiro tiro) {
		for (AtirarListener listener : atirarListeners)
			listener.handleAtirarEvent(tiro);
	}
}
