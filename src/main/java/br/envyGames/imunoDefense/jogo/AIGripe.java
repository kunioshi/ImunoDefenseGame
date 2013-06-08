package br.envyGames.imunoDefense.jogo;

import s3t.gameControl.system.GameSystem;
import s3t.gameEntities.AIAction;
import s3t.gameEntities.Entity;
import s3t.gameEntities.IAMessage;

public class AIGripe extends AIAction {
	private boolean atacando = false;
	private Torre alvo;
	
	@Override
	public void doAction(Entity entity) {
		Inimigo inimigo = (Inimigo)entity;
		
		if(!atacando) {
			entity.doMove(10, 0);
		} else {
			GameSystem.sendAIMessage(inimigo, alvo, "ataque", 0);
		}
	}

	@Override
	public void receiveMessage(IAMessage msg) {
		switch(msg.getMessage()) {
			case "bateu":
				alvo = (Torre)msg.getFromEntity();
				atacando = true;
				break;
			case "destruiu":
				atacando = false;
				break;
		}
	}

}
