package br.envyGames.imunoDefense.motor;

import s3t.gameControl.system.GameSystem;

public class JogoMotor {
	
	private CenarioGerenciador cenarioGerenciador;
	private EntidadeGerenciador entidadeGerenciador;
	
	public void inicializar() {
		GameSystem.init();
	}
	
	public Janela criarJanelaPrincipal(int largura, int altura) {
		Janela janela = new Janela(largura, altura);

		janela.adicionarComponenteAoCentro(criarPainelPrincipal());
		
		return janela;
	}
	
	public CenarioGerenciador getCenarioGerenciador() {
		if (cenarioGerenciador == null)
			cenarioGerenciador = new CenarioGerenciador();
		
		return cenarioGerenciador;
	}
	
	public EntidadeGerenciador getEntidadeGerenciador() {
		if (entidadeGerenciador == null)
			entidadeGerenciador = new EntidadeGerenciador();
		
		return entidadeGerenciador;
	}
	
	public void loadCenario(String cenarioID) {
		getCenarioGerenciador().loadCenario(cenarioID);
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
