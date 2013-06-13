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
	//private Torre torreSelecionado;
	
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
			miocardioTorreButtonClicked();
		}
		else if (isMedulaTorreButton(e.getX(), e.getY())) {
			medulaTorreButtonClicked();
		}
		else if (isGrid(e.getX(), e.getY())) {
			gridClicked(convertPixelToGrid(e.getX() - 20), convertPixelToGrid(e.getY() - 25));
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
		CenarioLayer background = CenarioLayer.criarPassLayer("BackGround");
		
		//criando um HUD para teste
		Imagem backgroundImagem = ResourceManager.getImagem("/imagens/BackgroundJogo.png");
		Imagem botaoMiocardioTorre = ResourceManager.getImagem("/imagens/torres/botaoMiocardioITorre.jpg");
		Imagem botaoMedulaTorre = ResourceManager.getImagem("/imagens/torres/botaoMedulaITorre.jpg");
		
		background.adicionarItem(new CenarioItem("fundo", backgroundImagem, 0, 0));
		
		background.adicionarItem(new CenarioItem("botaoMiocardioITorre", botaoMiocardioTorre, 6, 420));
		background.adicionarItem(new CenarioItem("botaoMedulaITorre", botaoMedulaTorre, 102, 420));
		
		adicionarLayer(background);
	}
	
	private int convertGridToPixel(int n) {
		return n * 32;
	}
	
	private int convertPixelToGrid(int pixel) {
		return pixel / 32;
	}
	
	private boolean isGrid(int x, int y) {
		return (x >= 0 && x <= 736 && y >= 0 && y <= 420);
	}
	
	private boolean isMiocardioTorreButton(int x, int y) {
		return x >= 6 && x <= 96 && y >= 420 && y <= 510;
	}
	
	private boolean isMedulaTorreButton(int x, int y) {
		return x >= 102 && x <= 192 && y >= 420 && y <= 510;
	}
	
	private void miocardioTorreButtonClicked() {
		///torreSelecionado = TorreFactory.criarMiocardio("teste", xy, this);
	}
	
	private void medulaTorreButtonClicked() {
		
	}
	
	private void gridClicked(int coluna, int linha) {
		adicionarTorre(coluna, linha, TorreFactory.criarMiocardio("MiocardioTore_" + coluna + "_" + linha, new Point(convertGridToPixel(coluna), convertGridToPixel(linha)), this));
	}
	
	private void adicionarTorre(int coluna, int linha, Torre torre) {
		GameSystem.getEntityCollection().addEntity(torre);
		Tabuleiro.getTabuleiroAtual().setCasa(new Point(coluna, linha), torre);
	}
}
