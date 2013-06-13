package br.envyGames.imunoDefense.jogo;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.Entidade;

import s3t.gameControl.system.GameSystem;
import s3t.graphicsElements.AnimImage;
import s3t.graphicsElements.SimpleImage;

enum Estado {
	ANDANDO, PARADO, ATACANDO;
}

enum TipoLocomocao {
	Terrestre,
	Aerio
}

/*
 * Classe abstrata base dos inimigos
 */
public abstract class Inimigo extends Entidade {
	private int vida = 2;
	private int forca = 1;
	private float velocidadeNatural = 32;
	private float lentidao = 1;
	private TipoLocomocao tipoLocomocao;
	
	/*
	 * Construtor<br/>
	 * Por padrão os inimigos iniciam com força 1, velocidade 1 e com 2 de vida.
	 * @param <code>name</code> - Nome do inimigo do qual será usado para encontra-lo na EntityCollection.
	 * @param <code>xy</code>   - Coordenadas "(x, y)" iniciais. 
	 */
	public Inimigo(String name, Point xy, Cenario cenario) {
		super(name, Tabuleiro.getTabuleiroAtual().converteCoordToTab(xy.x), Tabuleiro.getTabuleiroAtual().converteCoordToTab(xy.y), cenario);
	}
	
	// Getters & Setters
	public int getVida() { return vida; }
	public int getForca() { return forca; }
	public float getVelocidade() { return velocidadeNatural * lentidao; }
	public TipoLocomocao getTipoLocomocao() { return tipoLocomocao; }
	
	public void setForca(int dano) { forca = dano; }
	public void setVelocidadeNormal(int vel) { velocidadeNatural = vel; }
	
	/*
	 * Aplica efeito de lentidão nesta unidade
	 * @param <code>porcentagem</code> - Quantos porcentos serão removidos da velocidade (0~1)
	 */
	public void addSlow(float porcentagem) {
		if(lentidao < (1 - porcentagem))
			lentidao = 1 - porcentagem;
	}
	public void removeSlow() {
		lentidao = 1;
	}
	
	public void recebeDano(int dano) {
		vida -= dano;
		
		isDead();
	}
	
	private void isDead() {
		if(vida <= 0)
			mataInimigo();
	}
	
	public void mataInimigo() {
		GameSystem.getEntityCollection().getEntityByName(getName());
	}
	
	public static AnimImage loadAnimation(String firstName, String extension, int endNumber, int period, int behavior) throws IOException {
        AnimImage animImage = new AnimImage();

        for (int i = 0; i <= endNumber; i++) {
            SimpleImage img = new SimpleImage(firstName + i + extension);
            img.setCollisionRectangle(new Rectangle(0, 0, Tabuleiro.getTabuleiroAtual().getTamanhoCasa(), Tabuleiro.getTabuleiroAtual().getTamanhoCasa()));
            animImage.addImage(img);
        }
        
        animImage.setPeriod(period);
        animImage.setBehavior(behavior);
        return animImage;
    }
	
	public Point getCasaAtual() {
		return Tabuleiro.getTabuleiroAtual().converteCoord((int)getX(), (int)getY());
	}
}
