package br.envyGames.imunoDefense.jogo;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import s3t.gameControl.system.GameSystem;
import s3t.gameEntities.Scenario;

import br.envyGames.imunoDefense.motor.JogoMotor;

//CLASSE DESCONTINUADA VAI SER APAGA
public class MouseHandler implements MouseListener, MouseMotionListener {
	
	public static Point mousePos = new Point();
	public static MouseHandler mouseHandler = new MouseHandler();
	public int condicao = 0;
	public int condicao2 = 0;
	private JogoMotor motor;
	public int aux = 0;

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		Scenario cenario = GameSystem.getScenarioCollection().getScenarioAtual();
		
		int gridX = (int) (e.getX() / 32);
		int gridY = (int) (e.getY() / 32);
		
		System.out.println(gridX + "|" + gridY);
		
		
		
		switch(condicao)
		{
		//Carrega o Jogo
		case 1:
			//GameSystem.getScenarioCollection().setScenarioAtual("JogoCenario");
			motor.loadCenario("JogoCenario");
			break;
		//Carrega a tela de Instruções, dentro do menu
		case 2:
			//GameSystem.getScenarioCollection().setScenarioAtual("InstrucoesCenario");			
			motor.loadCenario("InstrucoesCenario");
			break;
		//Carrega a tela de créditos, dentro do menu
		case 3:
			//GameSystem.getScenarioCollection().setScenarioAtual("CreditosCenario");
			motor.loadCenario("CreditosCenario");
			break;
		//Fecha o jogo
		case 4:
			System.exit(0);
			break;
		//Carrega a tela Menu
		case 5:
			//GameSystem.getScenarioCollection().setScenarioAtual("MenuCenario");
			motor.loadCenario("MenuCenario");
			break;
		case 6:
			cenario.getScenarioLayer("instrucoes").getScenarioItem("imgInstrucoes").setVisible(false);
			cenario.getScenarioLayer("instrucoes").getScenarioItem("imgInstrucoes2").setVisible(true);
			break;
		case 7:
			cenario.getScenarioLayer("instrucoes").getScenarioItem("imgInstrucoes").setVisible(true);
			cenario.getScenarioLayer("instrucoes").getScenarioItem("imgInstrucoes2").setVisible(false);
			break;
		case 8:
			cenario.getScenarioLayer("instrucoes").getScenarioItem("imgInstrucoes").setVisible(false);
			cenario.getScenarioLayer("instrucoes").getScenarioItem("imgInstrucoes2").setVisible(true);
		default:
			break;			
		}
		
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousePos = e.getPoint();
		int gridX = (int) (e.getX() / 32);
		int gridY = (int) (e.getY() / 32);	
		
		Scenario cenario = GameSystem.getScenarioCollection().getScenarioAtual();
		
		
		//Menu
//		if (cenario.getScenarioId().equals("MenuCenario"))
//		{
//		boolean jogar = (gridX >= 0 && gridX <= 5 && (gridY == 8 || gridY == 9));
//		boolean instrucoes = (gridX >= 1 && gridX <= 7 && (gridY == 10 || gridY == 11));
//		boolean creditos = (gridX >= 1 && gridX <= 6 && (gridY == 12 || gridY == 13));
//		boolean sair = (gridX >= 22 && gridX <= 23 && (gridY == 1 || gridY == 2));
//		
//		
//		if(jogar)
//			condicao = 1;
//		else if(instrucoes)
//			condicao = 2;
//		else if(creditos)
//			condicao = 3;
//		else if(sair)
//			condicao = 4;
//		else
//			condicao = 0;
//		
//		//System.out.println(gridX + "|" + gridY);
//		
//		
//		
//		
//			switch (condicao)
//			{
//			case 1:
//				cenario.getScenarioLayer("background").getScenarioItem("Menu").setVisible(false);
//				cenario.getScenarioLayer("background").getScenarioItem("menuJogar").setVisible(true);
//				cenario.getScenarioLayer("background").getScenarioItem("menuInstrucoes").setVisible(false);
//				cenario.getScenarioLayer("background").getScenarioItem("menuCreditos").setVisible(false);
//				cenario.getScenarioLayer("background").getScenarioItem("menuSair").setVisible(false);
//				
//				break;
//			
//			case 2:
//			
//				cenario.getScenarioLayer("background").getScenarioItem("Menu").setVisible(false);
//				cenario.getScenarioLayer("background").getScenarioItem("menuJogar").setVisible(false);
//				cenario.getScenarioLayer("background").getScenarioItem("menuInstrucoes").setVisible(true);
//				cenario.getScenarioLayer("background").getScenarioItem("menuCreditos").setVisible(false);
//				cenario.getScenarioLayer("background").getScenarioItem("menuSair").setVisible(false);
//				break;
//			
//			case 3:
//				cenario.getScenarioLayer("background").getScenarioItem("Menu").setVisible(false);
//				cenario.getScenarioLayer("background").getScenarioItem("menuJogar").setVisible(false);
//				cenario.getScenarioLayer("background").getScenarioItem("menuInstrucoes").setVisible(false);
//				cenario.getScenarioLayer("background").getScenarioItem("menuCreditos").setVisible(true);
//				cenario.getScenarioLayer("background").getScenarioItem("menuSair").setVisible(false);
//				break;
//				
//			case 4:
//				cenario.getScenarioLayer("background").getScenarioItem("Menu").setVisible(false);
//				cenario.getScenarioLayer("background").getScenarioItem("menuJogar").setVisible(false);
//				cenario.getScenarioLayer("background").getScenarioItem("menuInstrucoes").setVisible(false);
//				cenario.getScenarioLayer("background").getScenarioItem("menuCreditos").setVisible(false);
//				cenario.getScenarioLayer("background").getScenarioItem("menuSair").setVisible(true);
//				break;
//				
//			case 0:
//				cenario.getScenarioLayer("background").getScenarioItem("Menu").setVisible(true);
//				cenario.getScenarioLayer("background").getScenarioItem("menuJogar").setVisible(false);
//				cenario.getScenarioLayer("background").getScenarioItem("menuInstrucoes").setVisible(false);
//				cenario.getScenarioLayer("background").getScenarioItem("menuCreditos").setVisible(false);
//				cenario.getScenarioLayer("background").getScenarioItem("menuSair").setVisible(false);
//				break;
//				
//				}
//			
//		}
		
		
		
		//Creditos
//		if (cenario.getScenarioId().equals("CreditosCenario"))
//		{
//			if (gridX >= 1 && gridX <= 2 && (gridY == 15 || gridY == 16))
//			{
//				condicao = 5;
//				
//				cenario.getScenarioLayer("creditos").getScenarioItem("telaCreditos").setVisible(true);
//				cenario.getScenarioLayer("creditos").getScenarioItem("telaCreditosOver").setVisible(false);
//				
//			}
//			else
//			{
//				cenario.getScenarioLayer("creditos").getScenarioItem("telaCreditos").setVisible(false);
//				cenario.getScenarioLayer("creditos").getScenarioItem("telaCreditosOver").setVisible(true);
//			}
//		}
		
//		//Instrucoes
//		if (cenario.getScenarioId().equals("InstrucoesCenario"))
//		{
//			
//			if (gridX >= 1 && gridX <= 2 && (gridY == 14 || gridY == 15))
//			{
//				condicao = 5;
//			}
//			if (gridX >= 21 && gridX <= 23 && (gridY == 14 || gridY == 15))
//			{
//				
//				if (aux == 0)
//				{
//					aux = 1;
//					condicao = 6;
//				}
//				else if (aux == 1)
//				{
//					aux = 0;
//					condicao = 7;					
//				}
//			}
//		}
		
	}

	
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
