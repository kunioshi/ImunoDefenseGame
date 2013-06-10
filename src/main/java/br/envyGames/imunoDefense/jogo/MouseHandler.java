package br.envyGames.imunoDefense.jogo;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import s3t.gameControl.system.GameSystem;
import s3t.gameEntities.Scenario;

import br.envyGames.imunoDefense.motor.CenarioGerenciador;
import br.envyGames.imunoDefense.motor.CenarioItem;

public class MouseHandler implements MouseListener, MouseMotionListener {
	
	public static Point mousePos = new Point();
	public static MouseHandler mouseHandler = new MouseHandler();
	public int condicao = 0;

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		switch(condicao)
		{
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		default:
			break;			
		}
		
		int gridX = (int) (e.getX() / 32);
		int gridY = (int) (e.getY() / 32);
		
		System.out.println(gridX + "|" + gridY);
		
		//Scenario cenario = new CenarioGerenciador().getCenario();
		
		
		
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
		
		boolean jogar = (gridX >= 10 && gridX <= 15 && (gridY == 7 || gridY == 8));
		boolean instrucoes = (gridX >= 7 && gridX <= 17 && (gridY == 9 || gridY == 10));
		boolean creditos = (gridX >= 8 && gridX <= 16 && (gridY == 11 || gridY == 12));
		boolean sair = (gridX >= 10 && gridX <= 14 && (gridY == 14 || gridY == 15));
		
		
		if(jogar)
			condicao = 1;
		else if(instrucoes)
			condicao = 2;
		else if(creditos)
			condicao = 3;
		else if(sair)
			condicao = 4;
		
		//System.out.println(gridX + "|" + gridY);
		
		Scenario cenario = GameSystem.getScenarioCollection().getScenarioAtual();
		
		if (cenario.getScenarioId().equals("MenuCenario"))
		{
			switch (condicao)
			{
			case 1:				
				cenario.getScenarioLayer("background").getScenarioItem("Menu").setVisible(false);
				cenario.getScenarioLayer("background").getScenarioItem("menuJogar").setVisible(true);
				cenario.getScenarioLayer("background").getScenarioItem("menuInstrucoes").setVisible(false);
				cenario.getScenarioLayer("background").getScenarioItem("menuCreditos").setVisible(false);
				cenario.getScenarioLayer("background").getScenarioItem("menuSair").setVisible(false);
				
				break;
			
			case 2:
			
				cenario.getScenarioLayer("background").getScenarioItem("Menu").setVisible(false);
				cenario.getScenarioLayer("background").getScenarioItem("menuJogar").setVisible(false);
				cenario.getScenarioLayer("background").getScenarioItem("menuInstrucoes").setVisible(true);
				cenario.getScenarioLayer("background").getScenarioItem("menuCreditos").setVisible(false);
				cenario.getScenarioLayer("background").getScenarioItem("menuSair").setVisible(false);
				break;
			
			case 3:
				cenario.getScenarioLayer("background").getScenarioItem("Menu").setVisible(false);
				cenario.getScenarioLayer("background").getScenarioItem("menuJogar").setVisible(false);
				cenario.getScenarioLayer("background").getScenarioItem("menuInstrucoes").setVisible(false);
				cenario.getScenarioLayer("background").getScenarioItem("menuCreditos").setVisible(true);
				cenario.getScenarioLayer("background").getScenarioItem("menuSair").setVisible(false);
				break;
				
			case 4:
				cenario.getScenarioLayer("background").getScenarioItem("Menu").setVisible(false);
				cenario.getScenarioLayer("background").getScenarioItem("menuJogar").setVisible(false);
				cenario.getScenarioLayer("background").getScenarioItem("menuInstrucoes").setVisible(false);
				cenario.getScenarioLayer("background").getScenarioItem("menuCreditos").setVisible(false);
				cenario.getScenarioLayer("background").getScenarioItem("menuSair").setVisible(true);
				break;
				
			default:
				cenario.getScenarioLayer("background").getScenarioItem("Menu").setVisible(true);
				cenario.getScenarioLayer("background").getScenarioItem("menuJogar").setVisible(false);
				cenario.getScenarioLayer("background").getScenarioItem("menuInstrucoes").setVisible(false);
				cenario.getScenarioLayer("background").getScenarioItem("menuCreditos").setVisible(false);
				cenario.getScenarioLayer("background").getScenarioItem("menuSair").setVisible(false);
				break;
			}
		}
		
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
