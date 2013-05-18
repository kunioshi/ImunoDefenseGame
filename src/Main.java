import java.io.IOException;

import s3t.gameControl.system.GameSystem;


public class Main {
	public static void main(String[] args) {
		Global.janela = new Janela();
		
		try {
			Cenario_Basico basico = new Cenario_Basico();
			
			GameSystem.getScenarioCollection().addScenario(basico);
		} catch (IOException e) {
			System.out.print("Erro ao ler cenario basico");
		}
		
		GameSystem.setPaintPanel(Global.janela.getGamePanel());
        GameSystem.getScenarioCollection().setScenarioAtual("cena1");
        //GameSystem.setObjGameUpdate( new GameUpdate(janela) );
        GameSystem.init();
		
		Global.janela.setVisible(true);
	}
}
