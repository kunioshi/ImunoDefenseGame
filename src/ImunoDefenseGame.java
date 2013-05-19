import java.awt.Dimension;
import java.io.IOException;

import s3t.gameControl.system.GameSystem;

public class ImunoDefenseGame implements Runnable {

	private Janela janela;
	private Panel panelPrincipal;
	private final Dimension dimension = new Dimension(1024, 768);

	public void setup() {
		inicializarJanela();		
		inicializarPanelPrincipal();		
		criarCenarioBasico();
		inicializarSistema();        
	}	
	
	@Override
	public void run() {		
		janela.setVisible(true);		
	}
	
	private void inicializarJanela() {
		janela = new Janela(dimension);
		
		janela.addMouseListener( MouseHandler.mouseHandler );
		janela.addMouseMotionListener( MouseHandler.mouseHandler );
	}

	private void inicializarPanelPrincipal() {
		panelPrincipal = new Panel();
		
		janela.adicionarComponenteAoCentro(panelPrincipal);
		
		GameSystem.setPaintPanel(panelPrincipal);
	}
	
	private void criarCenarioBasico() {
		try {
			Cenario_Basico basico = new Cenario_Basico(dimension);
			
			GameSystem.getScenarioCollection().addScenario(basico);
		} catch (IOException e) {
			System.out.print("Erro ao ler cenario basico");
		}		

        GameSystem.getScenarioCollection().setScenarioAtual("cena1");
	}
	
	private void inicializarSistema() {
		GameSystem.init();
	}
	
}
