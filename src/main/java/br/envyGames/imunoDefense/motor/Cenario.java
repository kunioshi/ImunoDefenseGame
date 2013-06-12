package br.envyGames.imunoDefense.motor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import s3t.gameEntities.Scenario;

public class Cenario extends Scenario implements MouseListener, MouseMotionListener {

	public Cenario(String id, String nome, int largura, int altura) {
		super(id, nome, largura, altura);
	}

	public void adicionarLayer(CenarioLayer layer) {
		this.addScenarioLayer(layer);
	}
	
	public CenarioLayer getLayerPorID(String layerID) {
		return (CenarioLayer)this.getScenarioLayer(layerID);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
}
