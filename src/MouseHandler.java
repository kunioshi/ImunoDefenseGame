import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import s3t.gameControl.system.GameSystem;


public class MouseHandler implements MouseListener, MouseMotionListener {

	@Override
	public void mouseClicked(MouseEvent e) {

		int gridX = (int) (e.getX() / 32);
		int gridY = (int) (e.getY() / 32);
		
		System.out.println(gridX + "|" + gridY);
		
		try {
			Spider spider = new Spider(gridX*32, gridY*32, GameSystem.getScenarioCollection().getScenarioAtual());
			GameSystem.getEntityCollection().addEntity(spider);
			
			Global.janela.incTotalTorres();
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
		Global.mousePos = e.getPoint();
	}

}
