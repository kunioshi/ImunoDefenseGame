package br.envyGames.imunoDefense.jogo;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.IOException;

import s3t.gameControl.system.GameSystem;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.CenarioItem;
import br.envyGames.imunoDefense.motor.CenarioLayer;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class JogoCenario extends Cenario implements ChegarHordaListener {

	private HordaGerenciador hordaGerenciador = new HordaGerenciador();
	
	public JogoCenario(int largura, int altura) {
		super("JogoCenario", "Jogo", largura, altura);	
		
		setBackgroundColor(Color.WHITE);
		
		hordaGerenciador.addChegarHordaListener(this);
		
		try {
			carregarBackground(largura, altura);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	@Override
	public void run() {
		hordaGerenciador.run();			
	}
	
	@Override
	public void handleChegarHorda() {
		InimigoMalaria malaria;
		try {
			malaria = new InimigoMalaria("inimigo0", this);
			GameSystem.getEntityCollection().addEntity(malaria);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX() + "|" + e.getY());
		if (isMiocardioTorreButton(e.getX(), e.getY())) {
			TorreButtonClicked();
		}
		else if (isGrid(e.getX(), e.getY())) {
			Torre torre = new MiocardioTorre("teste", new Point(e.getX() - 20, e.getY() - 25), this);
			GameSystem.getEntityCollection().addEntity(torre);
		}
	}
	
	private Torre torre;
	@Override
	public void mouseMoved(MouseEvent e) {	
		if (isGrid(e.getX(), e.getY())) {
			if (torre == null) {
				torre = new MiocardioTorre("seguindo", new Point(e.getX() - 20, e.getY() - 25), this);
				GameSystem.getEntityCollection().addEntity(torre);
			}
			else {
				torre.setX(e.getX() - 20);
				torre.setY(e.getY() - 25);
			}			
		}
		//else
		//	GameSystem.getEntityCollection().removeEntity(entidade);
	}
	
	private void carregarBackground(int largura, int altura) throws IOException {		
		CenarioLayer background = CenarioLayer.criarSolidLayer("BackGround");
		
		//criando um HUD para teste
		Imagem backgroundImagem = ResourceManager.getImagem("/imagens/BackgroundJogo.png");
		Imagem botaoMiocardioTorre = ResourceManager.getImagem("/imagens/torres/botaoMiocardioITorre.jpg");
		Imagem botaoMedulaTorre = ResourceManager.getImagem("/imagens/torres/botaoMedulaITorre.jpg");
		
		background.adicionarItem(new CenarioItem("fundo", backgroundImagem, 0, 0));
		background.adicionarItem(new CenarioItem("botaoMiocardioITorre", botaoMiocardioTorre, 6, 420));
		background.adicionarItem(new CenarioItem("botaoMedulaITorre", botaoMedulaTorre, 102, 420));
		
		adicionarLayer(background);
	}
	
	private int convertGridPixel(int n) {
		return n * 32;
	}
	
	private boolean isGrid(int x, int y) {
		return (x >= 0 && x <= 384 && y >= 0 && y <= 420);
	}
	
	private boolean isMiocardioTorreButton(int x, int y) {
		return x >= 6 && x <= 96 && y >= 420 && y <= 510;
	}
	
	private boolean isMedulaTorreButton(int x, int y) {
		return x >= 6 && x <= 96 && y >= 420 && y <= 510;
	}
	
	private void TorreButtonClicked() {
		
	}		
}
