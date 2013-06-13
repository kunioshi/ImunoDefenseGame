package br.envyGames.imunoDefense.motor;

public interface AdicionarRemoverEntidadeListener {
	public void  handleAdicionarEntidade(Object sender, Entidade entidade);
	public void  handleRemoverEntidade(Object sender, Entidade entidade);
}
