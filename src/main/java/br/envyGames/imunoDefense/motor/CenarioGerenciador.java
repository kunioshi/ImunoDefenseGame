package br.envyGames.imunoDefense.motor;

import s3t.gameControl.system.GameSystem;

public class CenarioGerenciador {
	public static void adicionarCenario(Cenario cenario) {
		GameSystem.getScenarioCollection().addScenario(cenario);
	}
	
	public static void removerCenario(String id) {
		GameSystem.getScenarioCollection().removeScenario(id);
	}
	
	public static void setCenarioAtual(String cenarioID) {
		GameSystem.getScenarioCollection().setScenarioAtual(cenarioID);
	}
	
	public static Cenario getCenarioAtual() {		
		return (Cenario)GameSystem.getScenarioCollection().getScenarioAtual();
	}
	
	public static Cenario getCenarioByID(String cenarioID) {		
		return (Cenario)GameSystem.getScenarioCollection().getScenario(cenarioID);
	}
}
