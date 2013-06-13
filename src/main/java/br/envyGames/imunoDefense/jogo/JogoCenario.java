package br.envyGames.imunoDefense.jogo;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.IOException;

import s3t.gameControl.system.GameSystem;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.CenarioItem;
import br.envyGames.imunoDefense.motor.CenarioLayer;
import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class JogoCenario extends Cenario implements ChegarHordaListener {
	private Coracao coracao = new Coracao(this);
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
			adicionarEntidade(malaria);
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
			gridClicked(convertPixelToGrid(e.getX() - 3), convertPixelToGrid(e.getY() - 25));
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {		
		if (isGrid(e.getX(), e.getY())) {
			if (seguidorMouse != null) {
				seguidorMouse.setX(e.getX() - 20);
				seguidorMouse.setY(e.getY() - 25 - 10);
			}			
		}
	}
	
	private void carregarBackground(int largura, int altura) throws IOException {		
		CenarioLayer background = CenarioLayer.criarPassLayer("BackGround");
		
		//criando um HUD para teste
		Imagem backgroundImagem = ResourceManager.getImagem("/imagens/BackgroundJogo.jpg");
		Imagem botaoMiocardioTorre = ResourceManager.getImagem("/imagens/entidades/torres/botaoMiocardioTorre.png");
		Imagem botaoMedulaTorre = ResourceManager.getImagem("/imagens/entidades/torres/botaoMedulaTorre.png");
		
		Imagem coracao = ResourceManager.getImagem("/imagens/entidades/CoracaoVivo.png");
		
		background.adicionarItem(new CenarioItem("fundo", backgroundImagem, 0, 0));
		
		background.adicionarItem(new CenarioItem("botaoMiocardioITorre", botaoMiocardioTorre, 6, 420));
		background.adicionarItem(new CenarioItem("botaoMedulaITorre", botaoMedulaTorre, 102, 420));
		background.adicionarItem(new CenarioItem("coracaoasdasd", coracao, 702, 0));
		
		adicionarLayer(background);
	}
	
	private int convertGridToPixel(int n) {
		return n * 32;
	}
	
	private int convertPixelToGrid(int pixel) {
		return pixel / 32;
	}
	
	private boolean isGrid(int x, int y) {
		return (x >= 32 && x <= 702 && y >= 0 && y <= 420);
	}
	
	private boolean isMiocardioTorreButton(int x, int y) {
		return x >= 6 && x <= 96 && y >= 420 && y <= 510;
	}
	
	private boolean isMedulaTorreButton(int x, int y) {
		return x >= 102 && x <= 192 && y >= 420 && y <= 510;
	}
	
	private Entidade seguidorMouse;
	private String novaConstrucaoSelecionada;
	
	private void miocardioTorreButtonClicked() {
		novaConstrucaoSelecionada = "Miocardio";
		removerSeguidorMouse();
		
		adicionarSeguidorMouse(6, 420, MiocardioTorre.getImagemLevel1());
	}
	
	private void medulaTorreButtonClicked() {
		novaConstrucaoSelecionada = "Medula";
		removerSeguidorMouse();
		
		adicionarSeguidorMouse(102, 420, MedulaTorre.getImagemLevel1());
	}
	
	private void adicionarSeguidorMouse(int x, int y, Imagem imagem) {
		seguidorMouse = new SeguidorMouse(x, y, imagem, this);
		adicionarEntidade(seguidorMouse);
	}

	private void removerSeguidorMouse() {
		if (seguidorMouse != null) {
			removerEntidade(seguidorMouse);
			seguidorMouse = null;
		}
	}
	
	private void gridClicked(int coluna, int linha) {
		if (Tabuleiro.getTabuleiroAtual().isCasaVazia(coluna, linha)) {
			if (isNovaConstrucaoSelecionada())
				construirTorre(coluna, linha);
		}
		else if (Tabuleiro.getTabuleiroAtual().isTorre(coluna, linha)) {
			
		}

	}
	
	private boolean isNovaConstrucaoSelecionada() {
		return novaConstrucaoSelecionada != null && novaConstrucaoSelecionada != "";
	}
	
	private void construirTorre(int coluna, int linha) {
		switch(novaConstrucaoSelecionada) {
			case "Miocardio":
				adicionarTorre(coluna, linha, TorreFactory.criarMiocardio("MiocardioTorre_" + coluna + "_" + linha, new Point(convertGridToPixel(coluna), convertGridToPixel(linha)), this));
				novaConstrucaoSelecionada = "";
				break;
			case "Medula":
				adicionarTorre(coluna, linha, TorreFactory.criarMedula("MedulaTorre_" + coluna + "_" + linha, new Point(convertGridToPixel(coluna), convertGridToPixel(linha)), this));
				novaConstrucaoSelecionada = "";
				break;
		}
		
		removerSeguidorMouse();	
	}
	
	private void adicionarTorre(int coluna, int linha, Torre torre) {
		adicionarEntidade(torre);
		Tabuleiro.getTabuleiroAtual().setCasa(new Point(coluna, linha), torre);
	}
	
	public Coracao getCoracao() { return coracao; }
}
