package br.envyGames.imunoDefense.jogo;

import java.util.ArrayList;
import java.util.List;

import br.envyGames.imunoDefense.jogo.entidade.inimigo.TipoInimigo;

public class HordaGerenciador implements Runnable {
	private long tempoEsperaProximaHorda = 10000;
	private long tempoEsperaProximaInimigo = 3000;
	private boolean isRunning = false;
	private Thread temporizador;
	private List<ChegarHordaListener> chegarHordaListeners = new ArrayList<ChegarHordaListener>();
	private int condicao = 1;
	private int quantidade = 3;
	
	public class HordaCriador extends Thread {
		public void run() {
			while (isRunning) {
				
				switch(condicao)
				{
					//Wave 1
					case 1:
						for (int i = 0; i < 3; i++) {
							fireChegarHordaEvent(TipoInimigo.GRIPE);
							
							esperar(tempoEsperaProximaInimigo);
						}
						condicao = 2;
						break;
						
					//Wave 2
					case 2:
						for (int i = 0; i < 3; i++) {
							fireChegarHordaEvent(TipoInimigo.GRIPE);
							
							esperar(tempoEsperaProximaInimigo);
						}
						
						for (int i = 0; i < 2; i++) {
							fireChegarHordaEvent(TipoInimigo.EBOLA);
							
							esperar(tempoEsperaProximaInimigo);
						}
						condicao = 3;					
						break;
						
					//Wave 3					
					case 3:
						for (int i = 0; i < 1; i++) {
							fireChegarHordaEvent(TipoInimigo.GRIPE);
							
							esperar(tempoEsperaProximaInimigo);
						}
						
						for (int i = 0; i < 2; i++) {
							fireChegarHordaEvent(TipoInimigo.EBOLA);
							
							esperar(tempoEsperaProximaInimigo);
						}
						
						for (int i = 0; i < 3; i++) {
							fireChegarHordaEvent(TipoInimigo.MALARIA);
							
							esperar(tempoEsperaProximaInimigo);
						}
						
						for (int i = 0; i < 1; i++) {
							fireChegarHordaEvent(TipoInimigo.CHAGAS);
							
							esperar(tempoEsperaProximaInimigo);
						}
						condicao = 4;
					
					//Wave 4
					case 4:
						for (int i = 0; i < quantidade; i++) {
							fireChegarHordaEvent(TipoInimigo.GRIPE);
							
							esperar(tempoEsperaProximaInimigo);
						}
						
						for (int i = 0; i < quantidade; i++) {
							fireChegarHordaEvent(TipoInimigo.EBOLA);
							
							esperar(tempoEsperaProximaInimigo);
						}
						
						for (int i = 0; i < quantidade; i++) {
							fireChegarHordaEvent(TipoInimigo.MALARIA);
							
							esperar(tempoEsperaProximaInimigo);
						}
						
						for (int i = 0; i < quantidade; i++) {
							fireChegarHordaEvent(TipoInimigo.CHAGAS);
							
							esperar(tempoEsperaProximaInimigo);
						}
						quantidade++;
						break;
				}

				esperar(tempoEsperaProximaHorda);
			}				
	    }

		private void esperar(long tempo) {
			try {
				Thread.sleep(tempo);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		if (temporizador == null)
			temporizador = new Thread(new HordaCriador());
		
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
