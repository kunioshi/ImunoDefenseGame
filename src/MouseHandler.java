import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import s3t.gameControl.system.GameSystem;
import s3t.gameEntities.Entity;
import s3t.gameEntities.Scenario;


public class MouseHandler implements MouseListener, MouseMotionListener {
	public static Point mousePos = new Point();
	public static MouseHandler mouseHandler = new MouseHandler();
	public SegueMouse spider;
	public Cenario_Basico cenario;
	
	@Override
	public void mouseClicked(MouseEvent e) {

		int gridX = (int) (e.getX() / 32);
		int gridY = (int) (e.getY() / 32);
		int gridtesteY = 12;
		
		System.out.println(gridX + "|" + gridY);
		
		
		
		try {
			
			if (gridY >= gridtesteY)
			{				
				spider = new SegueMouse(mousePos.x, mousePos.y, GameSystem.getScenarioCollection().getScenarioAtual());
				GameSystem.getEntityCollection().addEntity(spider);
				//Spider aranha = new Spider(gridX*32, gridY*32, GameSystem.getScenarioCollection().getScenarioAtual());
			}else{
				PontosDeColisao ponto = new PontosDeColisao(){};
				ponto.colisao.add(new Point(gridX, gridY));
				
				//Entity teste = new Entity(teste, gridX, gridY, cenario)
				GameSystem.getEntityCollection().removeEntity(spider);
			}
			
			
			
			

		} catch (IOException e1) {
			System.out.println("Erro na imagem spider");
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousePos = e.getPoint();
	}
}
