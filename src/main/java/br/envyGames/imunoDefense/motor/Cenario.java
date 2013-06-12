package br.envyGames.imunoDefense.motor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import s3t.gameEntities.Scenario;

public class Cenario extends Scenario implements MouseListener, MouseMotionListener {
	
	private List<AlterarCenarioListener> alterarCenarioListeners;

	public Cenario(String id, String nome, int largura, int altura) {
		super(id, nome, largura, altura);
		
		alterarCenarioListeners = new ArrayList<AlterarCenarioListener>();
	}
	
	public void addAlterarCenarioListener(AlterarCenarioListener listener) {
		alterarCenarioListeners.add(listener);
	}
	
	public void removeAlterarCenarioListener(AlterarCenarioListener listener) {
		alterarCenarioListeners.remove(listener);
	}

	public void adicionarLayer(CenarioLayer layer) {
		this.addScenarioLayer(layer);
	}
	
	public CenarioLayer getLayerPorID(String layerID) {
		return (CenarioLayer)this.getScenarioLayer(layerID);
	}
	
	protected void carregarNovoCenario(String novoCenarioID) {
		fireAlterarCenarioEvent(novoCenarioID);
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
	
	private void fireAlterarCenarioEvent(String novoCenarioID) {
		for (AlterarCenarioListener listener : alterarCenarioListeners)
			listener.handleAlterarCenario(this, novoCenarioID);
	}
}
