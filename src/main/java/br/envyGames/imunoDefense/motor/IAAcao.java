package br.envyGames.imunoDefense.motor;

import s3t.gameEntities.AIAction;
import s3t.gameEntities.Entity;
import s3t.gameEntities.IAMessage;

public abstract class IAAcao extends AIAction {

	@Override
	public void doAction(Entity e) {
		this.doAction((Entidade)e);		
	}
	
	@Override
	public void receiveMessage(IAMessage m) {
		receiveMessage((IAMensagem)m);
	}
	
	public abstract void doAction(Entidade entidade);
	public abstract void receiveMessage(IAMensagem mensagem);
}
