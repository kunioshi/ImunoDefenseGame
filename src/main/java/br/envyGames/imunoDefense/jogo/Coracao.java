package br.envyGames.imunoDefense.jogo;

import java.awt.Point;

import s3t.gameControl.system.GameSystem;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.JogoMotor;

public class Coracao extends Torre {
	private int vida = 20;
	private JogoMotor motor;
	
	public Coracao(Cenario cenario) {
		super("Coracao", new Point(Tabuleiro.getTabuleiroAtual().getWidth(), 0), cenario);
	}
	
	public int getVida() { return vida; }
	public void setVida(int novaVida) { vida = novaVida; }
	
	public void receberDano(int dmg) { 
		vida -= dmg;
		if (vida <= 0){
			motor.loadCenario("GameOverCenario");
			GameSystem.getEntityCollection().clear();
		}
	}
	
	public void receberCura(int heal) { vida += heal; }
}
