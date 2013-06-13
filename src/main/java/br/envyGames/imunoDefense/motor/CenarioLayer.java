package br.envyGames.imunoDefense.motor;

import s3t.gameEntities.ScenarioLayer;
import s3t.gameEntities.eScenarioBehavior;

public class CenarioLayer extends ScenarioLayer {
	
	public static CenarioLayer criarSolidLayer(String id) {
		return new CenarioLayer(id, eScenarioBehavior.SOLID);
	}
	
	public static CenarioLayer criarPassLayer(String id) {
		return new CenarioLayer(id, eScenarioBehavior.PASS);
	}

	private CenarioLayer(String id, eScenarioBehavior behavior) {
		super(id, behavior);
	}
	
	public void adicionarItem(CenarioItem item) {
		addScenarioItem(item);
	}
	
	public CenarioItem getItemPorNome(String nome) {
		return (CenarioItem)this.getScenarioItem(nome);
	}
}
