package br.envyGames.imunoDefense.jogo.cenario;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;

import s3t.gameControl.system.GameSystem;
import s3t.gameEntities.Message;

import br.envyGames.imunoDefense.jogo.ChegarHordaListener;
import br.envyGames.imunoDefense.jogo.HordaGerenciador;
import br.envyGames.imunoDefense.jogo.InimigoFactory;
import br.envyGames.imunoDefense.jogo.Jogador;
import br.envyGames.imunoDefense.jogo.Tabuleiro;
import br.envyGames.imunoDefense.jogo.TorreFactory;
import br.envyGames.imunoDefense.jogo.entidade.Coracao;
import br.envyGames.imunoDefense.jogo.entidade.FormaDeVida;
import br.envyGames.imunoDefense.jogo.entidade.MorteListener;
import br.envyGames.imunoDefense.jogo.entidade.SeguidorMouse;
import br.envyGames.imunoDefense.jogo.entidade.Tiro;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.Inimigo;
import br.envyGames.imunoDefense.jogo.entidade.inimigo.TipoInimigo;
import br.envyGames.imunoDefense.jogo.entidade.torre.AtirarListener;
import br.envyGames.imunoDefense.jogo.entidade.torre.MedulaTorre;
import br.envyGames.imunoDefense.jogo.entidade.torre.MiocardioTorre;
import br.envyGames.imunoDefense.jogo.entidade.torre.TipoTorre;
import br.envyGames.imunoDefense.jogo.entidade.torre.Torre;
import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.CenarioItem;
import br.envyGames.imunoDefense.motor.CenarioLayer;
import br.envyGames.imunoDefense.motor.Entidade;
import br.envyGames.imunoDefense.motor.Imagem;
import br.envyGames.imunoDefense.motor.ResourceManager;

public class JogoCenario extends Cenario implements ChegarHordaListener, MorteListener, AtirarListener {
	private int waveSpot = 5;
	private Coracao coracao;
	private HordaGerenciador hordaGerenciador = new HordaGerenciador();
	private Jogador jogador = new Jogador();
	private Entidade seguidorMouse;
	private TipoTorre novaConstrucaoSelecionada;
	
	private final int larguraBotao = 90;
	private final int alturaBotao = 90;
	private final int xInicioMiocardioBotao = 6;
	private final int xInicioMedulaBotao = 102;
	private final int xInicioTimoBotao = 198;
	private final int xLeucogenBotao = 294;
	private final int xRochaganBotao = 390;
	private final int yInicioBotao = 420;
	
	public JogoCenario(int largura, int altura) {
		super("JogoCenario", "Jogo", largura, altura);	
		
		hordaGerenciador.addChegarHordaListener(this);
	}	

	@Override
	public void run() {
		jogador.inicializarValores();
		hordaGerenciador.run();			
		
		carregarBackground();
		adicionarCoracao();					
	}

	private void adicionarCoracao() {
		coracao = new Coracao(new Point(702, 0), this);
		adicionarFormaDeVida(coracao);
	}
	
	@Override
	public void stop() {
		hordaGerenciador.stop();
	}
	
	private int inimigoNumero = 1;
	
	@Override
	public void handleChegarHorda(TipoInimigo tipoInimigo) {
		adicionarFormaDeVida(InimigoFactory.criarInimigo(tipoInimigo, "inimigo" + inimigoNumero, new Point(0, waveSpot), this));
		inimigoNumero++;
		
		waveSpot++;
		if(waveSpot > 7)
			waveSpot = 5;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (isMiocardioTorreButton(e.getX(), e.getY())) {
			miocardioTorreButtonClicked();
		}
		else if (isMedulaTorreButton(e.getX(), e.getY())) {
			medulaTorreButtonClicked();
		}		
		else if (isLeucogenTorreButton(e.getX(), e.getY())) {
			leucogenTorreButtonClicked();
		}
		else if (isRochaganTorreButton(e.getX(), e.getY())) {
			rochaganTorreButtonClicked();
		}
		else if (isTimoTorreButton(e.getX(), e.getY())) {
			timoTorreButtonClicked();
		}		
		else if (isUpgradeButton(e.getX(), e.getY())) {
			upgradeButtonClicked();
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
	
	private void carregarBackground() {		
		CenarioLayer background = CenarioLayer.criarPassLayer("BackGround");
		
		//criando um HUD para teste
		Imagem backgroundImagem = ResourceManager.getImagem("/imagens/BackgroundJogo.jpg");
		
		Imagem botaoMiocardioTorre = ResourceManager.getImagem("/imagens/entidades/torres/botaoMiocardioTorre.png");
		Imagem botaoMedulaTorre = ResourceManager.getImagem("/imagens/entidades/torres/botaoMedulaTorre.png");		
		Imagem botaoTimoTorre = ResourceManager.getImagem("/imagens/entidades/torres/botaoTimo.png");
		Imagem botaoLeucogenTorre = ResourceManager.getImagem("/imagens/entidades/torres/botaoLeucogen.png");
		Imagem botaoRochaganTorre = ResourceManager.getImagem("/imagens/entidades/torres/botaoRochagan.png");
		Imagem botaoLinfoideTorre = ResourceManager.getImagem("/imagens/entidades/torres/botaoLinfoideTravado.png");
		
		Imagem botaoUpgrade = ResourceManager.getImagem("/imagens/entidades/torres/upgradeLocked.PNG");
		
		
		background.adicionarItem(new CenarioItem("fundo", backgroundImagem, 0, 0));		
		
		background.adicionarItem(new CenarioItem("botaoMiocardioTorre", botaoMiocardioTorre, xInicioMiocardioBotao, yInicioBotao));
		background.adicionarItem(new CenarioItem("botaoMedulaTorre", botaoMedulaTorre, xInicioMedulaBotao, yInicioBotao));		
		background.adicionarItem(new CenarioItem("botaoTimoTorre", botaoTimoTorre, xInicioTimoBotao, yInicioBotao));
		background.adicionarItem(new CenarioItem("botaoLeucogenTorre", botaoLeucogenTorre, xLeucogenBotao, yInicioBotao));
		background.adicionarItem(new CenarioItem("botaoRochaganTorre", botaoRochaganTorre, xRochaganBotao, yInicioBotao));
		background.adicionarItem(new CenarioItem("botaoLinfoideTorre", botaoLinfoideTorre, 486, yInicioBotao));
		background.adicionarItem(new CenarioItem("botaoUpgrade", botaoUpgrade, 600, yInicioBotao + 10));
		
		String labelScore = "Score:";
		String labelDinheiro = "$:";
		Font font = new Font("verdana", Font.BOLD, 16);
		
		Message nomeScore = GameSystem.getMessageCollection().getMessageByName("labelScore");
		if (nomeScore == null) {
			nomeScore = new Message("labelScore", labelScore, font, 610 , 500);
			GameSystem.getMessageCollection().addMessage(nomeScore);
			nomeScore.setForegroundColor(Color.WHITE);
		}
		
		Message msgDinheiro = GameSystem.getMessageCollection().getMessageByName("labelDinheiro");
		if (msgDinheiro == null) {
			msgDinheiro = new Message("labelDinheiro", "" + labelDinheiro, font, 650 , 480);
			GameSystem.getMessageCollection().addMessage(msgDinheiro);
			msgDinheiro.setForegroundColor(Color.WHITE);
		}
		
		exibirScoreEDinheiro();		
		
		
		
		adicionarLayer(background);
	}

	private void exibirScoreEDinheiro() {
		int score = jogador.getPontos();		
		int dinheiro = jogador.getDinheiro();
		
		Font font = new Font("verdana", Font.BOLD, 16);
			
		//Score
		Message msgScore = GameSystem.getMessageCollection().getMessageByName("score");
		if (msgScore == null) {
			msgScore = new Message("score", "", font, 700, 500);
            GameSystem.getMessageCollection().addMessage(msgScore);
            msgScore.setForegroundColor(Color.WHITE);
		}        
        msgScore.setMessage(String.valueOf(score));
        
        //Dinheiro		
		Message msgCash = GameSystem.getMessageCollection().getMessageByName("dinheiro");
        if (msgCash == null) {
        	msgCash = new Message("dinheiro", "", font, 700, 480);
            GameSystem.getMessageCollection().addMessage(msgCash);
            msgCash.setForegroundColor(Color.WHITE);
        }
        
        msgCash.setMessage(String.valueOf(dinheiro));
	}
	
	private int convertGridToPixel(int n) {
		return n * 32;
	}
	
	private int convertPixelToGrid(int pixel) {
		return pixel / 32;
	}
	
	private boolean isGrid(int x, int y) {
		return (x >= 32 && x <= 702 && y >= 0 && y <= 419);
	}
	
	private boolean isMiocardioTorreButton(int x, int y) {
		return x >= xInicioMiocardioBotao && x <= xInicioMiocardioBotao + larguraBotao  && y >= yInicioBotao && y <= yInicioBotao + alturaBotao;
	}
	
	private boolean isMedulaTorreButton(int x, int y) {
		return x >= xInicioMedulaBotao && x <= xInicioMedulaBotao + larguraBotao && y >= yInicioBotao && y <= yInicioBotao + alturaBotao;
	}	
	
	private boolean isTimoTorreButton(int x, int y) {
		return x >= xInicioTimoBotao && x <= xInicioTimoBotao + larguraBotao && y >= yInicioBotao && y <= yInicioBotao + alturaBotao;
	}
	
	private boolean isLeucogenTorreButton(int x, int y) {
		return x >= xLeucogenBotao && x <= xLeucogenBotao + larguraBotao && y >= yInicioBotao && y <= yInicioBotao + alturaBotao;
	}
	
	private boolean isRochaganTorreButton(int x, int y) {
		return x >= xRochaganBotao && x <= xRochaganBotao + larguraBotao && y >= yInicioBotao && y <= yInicioBotao + alturaBotao;
	}
	
	private boolean isUpgradeButton(int x, int y) {
		return x >= 600 && x <= 692 && y >= 470 && y <= 497;
	}
	
	private void miocardioTorreButtonClicked() {
		clicarTorre(TipoTorre.MIOCARDIO, xInicioMiocardioBotao, yInicioBotao);
	}
	
	private void medulaTorreButtonClicked() {
		clicarTorre(TipoTorre.MEDULA, xInicioMedulaBotao, yInicioBotao);
	}
	
	private void timoTorreButtonClicked() {
		clicarTorre(TipoTorre.TIMO, xInicioTimoBotao, yInicioBotao);
	}
	
	private void leucogenTorreButtonClicked() {
		clicarTorre(TipoTorre.LEUCOGEN, xLeucogenBotao, yInicioBotao);
	}
	
	private void rochaganTorreButtonClicked() {
		clicarTorre(TipoTorre.ROCHAGAN, xRochaganBotao, yInicioBotao);
	}
	
	private void clicarTorre(TipoTorre tipoTorre, int x, int y) {
		novaConstrucaoSelecionada = tipoTorre;
		removerSeguidorMouse();
		
		adicionarSeguidorMouse(x, y, TorreFactory.getTorreMiniatura(novaConstrucaoSelecionada));
	}
	
	private void upgradeButtonClicked() {
		
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
		else if (Tabuleiro.getTabuleiroAtual().hasTorre(coluna, linha)) {
			
		}

	}
	
	private boolean isNovaConstrucaoSelecionada() {
		return novaConstrucaoSelecionada != TipoTorre.NENHUMA;
	}
	
	private void construirTorre(int coluna, int linha) {
		String nome = "Torre_" + coluna + "_" + linha;
		Point xy = new Point(convertGridToPixel(coluna), convertGridToPixel(linha));
		Torre torre = TorreFactory.criarTorre(novaConstrucaoSelecionada, nome, xy, this);
		adicionarTorre(coluna, linha, torre);
		novaConstrucaoSelecionada = TipoTorre.NENHUMA;
		
		removerSeguidorMouse();	
	}
	
	private void adicionarTorre(int coluna, int linha, Torre torre) {
		torre.addAtirarListener(this);
		adicionarFormaDeVida(torre);		
		Tabuleiro.getTabuleiroAtual().adicionarFormaDeVida(new Point(coluna, linha), torre);
		jogador.removerDinheiro(torre.getCusto());
		exibirScoreEDinheiro();
	}
	
	private void adicionarFormaDeVida(FormaDeVida formaDeVida) {
		formaDeVida.addMorteListener(this);				
		
		adicionarEntidade(formaDeVida);		
	}	
	
	public Coracao getCoracao() { return coracao; }

	@Override
	public void handleMorteFormaDeVida(FormaDeVida morto) {
		if (morto instanceof Inimigo)
			destruirInimigo((Inimigo)morto);
		else if (morto instanceof Torre)
			destruirTorre((Torre)morto);
		else if (morto instanceof Coracao) 
			gameOver();
	}
	
	private void destruirInimigo(Inimigo inimigo) {
		Tabuleiro.getTabuleiroAtual().getCasa(inimigo.getCasaAtual()).remover(inimigo);
		jogador.adicionarDinheiro(inimigo.getBonusDinheiroToKill());
		jogador.adicionarPontos(inimigo.getBonusScoreToKill());

		exibirScoreEDinheiro();
	}
	
	private void destruirTorre(Torre torre) {
		Tabuleiro.getTabuleiroAtual().getCasa(torre.getCasaAtual()).remover(torre);
		torre.removeAtirarListener(this);
	}

	private void gameOver() {
		carregarNovoCenario("GameOverCenario");
	}

	@Override
	public void handleAtirarEvent(Tiro tiro) {
		adicionarEntidade(tiro);		
	}
}
