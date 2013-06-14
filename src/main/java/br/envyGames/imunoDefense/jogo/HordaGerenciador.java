package br.envyGames.imunoDefense.jogo;

import java.util.ArrayList;
import java.util.List;

public class HordaGerenciador implements Runnable {
	private long tempoEspera = 2000;
	private boolean isRunning = false;
	private Thread temporizador;
	private List<ChegarHordaListener> chegarHordaListeners = new ArrayList<ChegarHordaListener>();
	
	public class Temporizador extends Thread {
		public void run() {
			while (isRunning) {
				try {
					Thread.sleep(tempoEspera);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				fireChegarHordaEvent();
			}
	    }
	}
	
	@Override
	public void run() {
		if (temporizador == null)
			temporizador = new Thread(new Temporizador());
		
		isRunning = true;
		temporizador.start();
	}
	
	public void stop() {
		isRunning = false;
	}
	
	public void addChegarHordaListener(ChegarHordaListener listener) {
		chegarHordaListeners.add(listener);
	}
	
	public void removeChegarHordaListener(ChegarHordaListener listener) {
		chegarHordaListeners.remove(listener);
	}
	
	private void fireChegarHordaEvent() {
		for (ChegarHordaListener listener : chegarHordaListeners)
			listener.handleChegarHorda();
	}
}
