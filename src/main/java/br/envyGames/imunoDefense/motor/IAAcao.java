package br.envyGames.imunoDefense.motor;

import s3t.gameEntities.AIAction;
import s3t.gameEntities.Entity;
import s3t.gameEntities.IAMessage;

public abstract class IAAcao extends AIAction {
	private Thread temporizador = null;
	private boolean isRunning;
	private boolean isTime;
	
	public class Temporizador extends Thread {
		@Override
		public void run() {
			while (isRunning) {
				isTime = true;
				try {
					Thread.sleep(timeToWait());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void doAction(Entity e) {
		if (e instanceof Entidade) {
			doPreWait((Entidade)e);
			if (temporizador == null) {
				inicar();
			}
			
			if (isTime) {
				this.doAction((Entidade)e);
				isTime = false;
			}
		}
	}
	
	protected void doPreWait(Entidade e) {
		
	}

	@Override
	public void receiveMessage(IAMessage m) {
		receiveMessage((IAMensagem)m);
	}
	
	public abstract void doAction(Entidade entidade);
	public abstract void receiveMessage(IAMensagem mensagem);
	public abstract int timeToWait();	

	private void inicar() {
		isRunning = true;
		temporizador = new Temporizador();			
		temporizador.start();
	}
}
