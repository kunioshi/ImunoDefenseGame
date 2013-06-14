package br.envyGames.imunoDefense.motor;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import s3t.gameControl.system.GameSystem;

public class JogoMotor implements AlterarCenarioListener, AdicionarRemoverEntidadeListener {
	
	private CenarioGerenciador cenarioGerenciador;
	private EntidadeGerenciador entidadeGerenciador;
	private Janela janelaPrincipal;

	public JogoMotor() {
		cenarioGerenciador = new CenarioGerenciador();
	}
	
	public void inicializar() {
		GameSystem.init();
	}
	
	public void criarJanela(int largura, int altura) {		
		janelaPrincipal = new Janela(largura, altura);
		Painel painelPrincipal = new Painel();	

		setPaintPanel(painelPrincipal);
		janelaPrincipal.adicionarComponenteAoCentro(painelPrincipal);
	}
	
	public void exibirJanela() {
		janelaPrincipal.setVisible(true);
	}
	
	public void adicionarCenario(Cenario cenario) {
		cenario.addAlterarCenarioListener(this);
		cenario.addAdicionarRemoverEntidadeListener(this);
		
		cenarioGerenciador.adicionarCenario(cenario);		
	}	
	
	public EntidadeGerenciador getEntidadeGerenciador() {
		if (entidadeGerenciador == null)
			entidadeGerenciador = new EntidadeGerenciador();
		
		return entidadeGerenciador;
	}
		
	private void setPaintPanel(Painel painel) {
		GameSystem.setPaintPanel(painel);
	}
	
	public void loadCenario(String cenarioID) {
		pararCenarioAnterior();		
		
		executarNovoCenario(cenarioID);
	}
	
	private void pararCenarioAnterior() {
		Cenario cenarioAnterior = cenarioGerenciador.getCenarioAtual(); 
		cenarioAnterior.stop();
		
		removerListenerCenarioAntorior();
	}
	
	private void executarNovoCenario(String cenarioID) {
		cenarioGerenciador.setCenarioAtual(cenarioID);
		
		Cenario atual = cenarioGerenciador.getCenarioAtual();
		atual.run();
		
		registrarMouseListenerFromCenario(atual);
	}

	private void removerListenerCenarioAntorior() {
		Cenario cenarioAnterior = cenarioGerenciador.getCenarioAtual(); 
		if (cenarioAnterior != null)
			desregistrarMouseListenerFromCenario(cenarioAnterior);
	}
	
	private void registrarMouseListenerFromCenario(Cenario cenario) {
		registrarMouseListener(cenario);
		registrarMouseMotionListener(cenario);
	}
	
	private void registrarMouseListener(MouseListener mouseListener) {
		janelaPrincipal.addMouseListener(mouseListener);
	}
	
	private void registrarMouseMotionListener(MouseMotionListener mouseMotionListener) {
		janelaPrincipal.addMouseMotionListener(mouseMotionListener);
	}
	
	private void desregistrarMouseListenerFromCenario(Cenario cenario) {
		desregistrarMouseListener(cenario);
		desregistrarMouseMotionListener(cenario);
	}
	
	private void desregistrarMouseListener(MouseListener mouseListener) {
		janelaPrincipal.removeMouseListener(mouseListener);
	}
	
	private void desregistrarMouseMotionListener(MouseMotionListener mouseMotionListener) {
		janelaPrincipal.removeMouseMotionListener(mouseMotionListener);
	}

	@Override
	public void handleAlterarCenario(Object sender, String novoCenarioID) {
		loadCenario(novoCenarioID);		
	}

	@Override
	public void handleAdicionarEntidade(Object sender, Entidade entidade) {
		getEntidadeGerenciador().adicionarEntidade(entidade);
	}

	@Override
	public void handleRemoverEntidade(Object sender, Entidade entidade) {
		getEntidadeGerenciador().removerEntidade(entidade);		
	}
}
