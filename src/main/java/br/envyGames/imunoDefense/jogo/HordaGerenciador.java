package br.envyGames.imunoDefense.jogo;

import java.util.ArrayList;
import java.util.List;

public class HordaGerenciador implements Runnable {
	private long tempoEsperaProximaHorda = 10000;
	private long tempoEsperaProximaInimigo = 2000;
	private boolean isRunning = false;
	private Thread temporizador;
	private List<ChegarHordaListener> chegarHordaListeners = new ArrayList<ChegarHordaListener>();
	
	public class Temporizador extends Thread {
		public void run() {
			while (isRunning) {
				esperaProximaHorda();
				
				for (int i = 0; i < 10; i++) {
					fireChegarHordaEvent(TipoInimigo.MALARIA);
					
					esperaProximoInimigo();
				}
			}
	    }

		private void esperaProximoInimigo() {
			try {
				Thread.sleep(tempoEsperaProximaInimigo);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		private void esperaProximaHorda() {
			try {
				Thread.sleep(tempoEsperaProximaHorda);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
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
	
	private void fireChegarHordaEvent(TipoInimigo tipoInimigo) {
		for (ChegarHordaListener listener : chegarHordaListeners)
			listener.handleChegarHorda(tipoInimigo);
	}
}
