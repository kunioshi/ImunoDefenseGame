package br.envyGames.imunoDefense.jogo;

public class Jogador {

	private int dinheiro = 40;
	private int pontos = 0;
	
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
