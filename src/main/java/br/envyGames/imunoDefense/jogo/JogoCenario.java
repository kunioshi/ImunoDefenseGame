package br.envyGames.imunoDefense.jogo;

import java.awt.event.MouseEvent;
import java.io.IOException;

import s3t.gameControl.system.GameSystem;

import br.envyGames.imunoDefense.motor.ArquivoImagem;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.CenarioItem;
import br.envyGames.imunoDefense.motor.CenarioLayer;
import br.envyGames.imunoDefense.motor.Imagem;

public class JogoCenario extends Cenario implements ChegarHordaListener {

	private HordaGerenciador hordaGerenciador = new HordaGerenciador();
	
	public JogoCenario(int largura, int altura) {
		super("JogoCenario", "Jogo", largura, altura);	
		
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
		System.out.println("Horde is comming...");

		InimigoMalaria malaria;
		try {
			malaria = new InimigoMalaria("inimigo0", this);
			GameSystem.getEntityCollection().addEntity(malaria);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
//		if (isTorreButton(e.getX(), e.getY())) {
//			TorreButtonClicked();
//		}
//		else if (isGrid(e.getX(), e.getY())) {
//			Torre torre = new MiocardioTorre("teste", new Point(e.getX(), e.getY() - 25), this);
//			GameSystem.getEntityCollection().addEntity(torre);
//		}
	}
	
	//private TEntite entidade;
	@Override
	public void mouseMoved(MouseEvent e) {	
//		if (isGrid(e.getX(), e.getY())) {
//			try {
//				if (entidade == null) {
//					entidade = new TEntite(e.getX(), e.getY(), this);
//					GameSystem.getEntityCollection().addEntity(entidade);
//				}
//				else {
//					entidade.setX(e.getX());
//					entidade.setY(e.getY());
//				}
//				
//			} 
//			catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}			
//		}
//		//else
//		//	GameSystem.getEntityCollection().removeEntity(entidade);
	}
	
	private void carregarBackground(int largura, int altura) throws IOException {		
		CenarioLayer background = CenarioLayer.criarSolidLayer("BackGround");
		
		//criando um HUD para teste
		Imagem gridImagem = new ArquivoImagem("/imagens/grid.jpg");
		Imagem coracaoImagem = new ArquivoImagem("/imagens/coracao.jpg");
		Imagem menuBarImagem = new ArquivoImagem("/imagens/menuBar.jpg");
		
		Imagem botaoTorre = new ArquivoImagem("/imagens/botaoTorre1.jpg");
		
		for (int i = 0; Tabuleiro.getTabuleiroAtual().converteCoordToTab(i) < largura; i++)
	    	for (int j = 0; Tabuleiro.getTabuleiroAtual().converteCoordToTab(j) < altura; j++) {
	    		if (i < Tabuleiro.getTabuleiroAtual().getWidth()) {
	    			if (j < Tabuleiro.getTabuleiroAtual().getHeight())
	    				background.adicionarItem(new CenarioItem("grid_" + i + "_" + j, gridImagem, Tabuleiro.getTabuleiroAtual().converteCoordToTab(i), Tabuleiro.getTabuleiroAtual().converteCoordToTab(j)));
	    			else
	    				background.adicionarItem(new CenarioItem("menuBar_" + i + "_" + j, menuBarImagem, Tabuleiro.getTabuleiroAtual().converteCoordToTab(i), Tabuleiro.getTabuleiroAtual().converteCoordToTab(j)));
	    		}
	    		else
	    			background.adicionarItem(new CenarioItem("coracao_" + i + "_" + j, coracaoImagem, Tabuleiro.getTabuleiroAtual().converteCoordToTab(i), Tabuleiro.getTabuleiroAtual().converteCoordToTab(j)));
	    	}
		
		background.adicionarItem(new CenarioItem("botaoTorre_1", botaoTorre, 6, 420));
		
		adicionarLayer(background);
	}
	
	private int convertGridPixel(int n) {
		return n * 32;
	}
	
	private boolean isGrid(int x, int y) {
		return (x >= 0 && x <= 384 && y >= 0 && y <= 420);
	}
	
	private boolean isTorreButton(int x, int y) {
		return x >= 6 && x <= 96 && y >= 420 && y <= 510;
	}
	
	private void TorreButtonClicked() {
		
	}		
}
