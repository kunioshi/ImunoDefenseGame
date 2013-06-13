package br.envyGames.imunoDefense.motor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import s3t.gameEntities.Scenario;

public abstract class Cenario extends Scenario implements MouseListener, MouseMotionListener, Runnable {
	
	private List<AlterarCenarioListener> alterarCenarioListeners;
	private List<AdicionarRemoverEntidadeListener> adicionarRemoverEntidadeListenerListeners;	

	public Cenario(String id, String nome, int largura, int altura) {
		super(id, nome, largura, altura);
		
		alterarCenarioListeners = new ArrayList<AlterarCenarioListener>();
		adicionarRemoverEntidadeListenerListeners = new ArrayList<AdicionarRemoverEntidadeListener>();
	}
	
	public void addAlterarCenarioListener(AlterarCenarioListener listener) {
		alterarCenarioListeners.add(listener);
	}
	
	public void removeAlterarCenarioListener(AlterarCenarioListener listener) {
		alterarCenarioListeners.remove(listener);
	}
	
	public void addAdicionarRemoverEntidadeListener(AdicionarRemoverEntidadeListener listener) {
		adicionarRemoverEntidadeListenerListeners.add(listener);
	}
	
	public void removeAdicionarRemoverEntidadeListener(AdicionarRemoverEntidadeListener listener) {
		adicionarRemoverEntidadeListenerListeners.remove(listener);
	}

	protected void adicionarLayer(CenarioLayer layer) {
		this.addScenarioLayer(layer);
	}
	
	protected CenarioLayer getLayerPorID(String layerID) {
		return (CenarioLayer)this.getScenarioLayer(layerID);
	}
	
	protected void adicionarEntidade(Entidade entidade) {
		fireAdicionarEntidadeEvent(entidade);
	}
	
	protected void removerEntidade(Entidade entidade) {
		fireRemoverEntidadeEvent(entidade);
	}
	
	protected void carregarNovoCenario(String novoCenarioID) {
		fireAlterarCenarioEvent(novoCenarioID);
	}
	
	private void fireAlterarCenarioEvent(String novoCenarioID) {
		for (AlterarCenarioListener listener : alterarCenarioListeners)
			listener.handleAlterarCenario(this, novoCenarioID);
	}
	
	private void fireAdicionarEntidadeEvent(Entidade entidade) {
		for (AdicionarRemoverEntidadeListener listener : adicionarRemoverEntidadeListenerListeners)
			listener.handleAdicionarEntidade(this, entidade);
	}
	
	private void fireRemoverEntidadeEvent(Entidade entidade) {
		for (AdicionarRemoverEntidadeListener listener : adicionarRemoverEntidadeListenerListeners)
			listener.handleRemoverEntidade(this, entidade);
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
