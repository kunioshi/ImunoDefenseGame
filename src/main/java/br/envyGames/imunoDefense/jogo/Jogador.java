package br.envyGames.imunoDefense.jogo;

import s3t.gameControl.GameCore;
import s3t.gameControl.system.GameSystem;
import s3t.gameEntities.Message;

public class Jogador {

	private int dinheiro;
	private int pontos;
	
	public void inicializarValores() {
		dinheiro = 40;
		pontos = 0;
	}
	
	public int getDinheiro() {
		return dinheiro;
	}
	
	public void adicionarDinheiro(int valor) {
		dinheiro += valor;
	}
	
	public void removerDinheiro(int valor) {
		dinheiro -= valor;
	}
	
	public int getPontos() {
		return pontos;		
	}
	
	public void adicionarPontos(int valor) {
		pontos += valor;		
	}
}