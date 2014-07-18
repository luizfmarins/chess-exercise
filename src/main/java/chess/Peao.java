package chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Peao implements Peca {

	private final Posicao posicaoAtual;
	
	public Peao(Posicao posicaoAtual) {
		this.posicaoAtual = posicaoAtual;
	}

	@Override
	public List<Posicao> getPossiveisPosicoes() {
		return null;
	}

	@Override
	public Posicao getPosicaoAtual() {
		return posicaoAtual;
	}

	public List<Posicao> getMovimentacoes() {
		List<Posicao> posicoes = new ArrayList<Posicao>();
		
		if (isPosicaoInicial())
			addPosicao(posicoes, posicaoAtual.getX(), posicaoAtual.getY() + 2);
		
		addPosicao(posicoes, posicaoAtual.getX(), posicaoAtual.getY() + 1);
		addPosicao(posicoes, posicaoAtual.getX() - 1, posicaoAtual.getY() + 1);
		addPosicao(posicoes, posicaoAtual.getX() + 1, posicaoAtual.getY() + 1);
		
		Collections.sort(posicoes);
		
		return posicoes;
	}

	
	public boolean isPosicaoInicial() {
		return posicaoAtual.getY() == 1;
	}
	
	private void addPosicao(List<Posicao> posicoes, int x, int y) {
		try {
			posicoes.add(new Posicao(x, y));
		} catch (PosicaoInvalidaException ex) {} 
	}
}