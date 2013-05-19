import java.awt.Dimension;
import java.io.IOException;

import s3t.gameControl.system.GameSystem;

public class ImunoDefenseGame implements Runnable {

	private Janela janela;
	private final Dimension dimension = new Dimension(1024, 768);

	public void setup() {
		janela = new Janela(dimension);
		
		try {
			Cenario_Basico basico = new Cenario_Basico();
			
			GameSystem.getScenarioCollection().addScenario(basico);
		} catch (IOException e) {
			System.out.print("Erro ao ler cenario basico");
		}
		
		GameSystem.setPaintPanel(janela.getGamePanel());
        GameSystem.getScenarioCollection().setScenarioAtual("cena1");
        //GameSystem.setObjGameUpdate( new GameUpdate(janela) );
        GameSystem.init();
	}

	@Override
	public void run() {		
		janela.setVisible(true);
		
	}
}
