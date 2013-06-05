package br.envyGames.imunoDefense.motor;

import s3t.gameControl.system.GameSystem;

public class JogoMotor {
	
	public void inicializar() {
		GameSystem.init();
	}
	
	public Janela criarJanelaPrincipal(int largura, int altura) {
		Janela janela = new Janela(largura, altura);

		janela.adicionarComponenteAoCentro(criarPainelPrincipal());
		
		return janela;
	}
	
	
	private Painel criarPainelPrincipal() {
		Painel painel = new Painel();		
		
		setPaintPanel(painel);
		
		return painel;
	}
	
	private void setPaintPanel(Painel painel) {
		GameSystem.setPaintPanel(painel);
	}

}
