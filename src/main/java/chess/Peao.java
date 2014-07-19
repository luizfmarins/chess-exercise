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
	public List<Posicao> getMovimentacoes() {
		List<Posicao> posicoes = new ArrayList<Posicao>();
		
		addPosicaoMovimentacaoInicial(posicoes);
		addPosicaoFrente(posicoes);
		addPosicaoDiagonalEsquerdaFrente(posicoes);
		addPosicaoDiagonalDireitaFrente(posicoes);
		
		Collections.sort(posicoes);
		
		return posicoes;
	}

	private void addPosicaoMovimentacaoInicial(List<Posicao> posicoes) {
		if (!isPosicaoInicial()) return;
		
		try {
			posicoes.add(posicaoAtual.getPosicaoFrente().getPosicaoFrente());
		} catch(PosicaoInvalidaException ex) {}
	}

	private void addPosicaoDiagonalDireitaFrente(List<Posicao> posicoes) {
		try {
			posicoes.add(posicaoAtual.getPosicaoDiagonalDireitaFrente());
		} catch (PosicaoInvalidaException ex) {}
	}

	private void addPosicaoDiagonalEsquerdaFrente(List<Posicao> posicoes) {
		try {
			posicoes.add(posicaoAtual.getPosicaoDiagonalEsquerdaFrente());
		} catch (PosicaoInvalidaException ex) {}
	}

	private void addPosicaoFrente(List<Posicao> posicoes) {
		try {
			posicoes.add(posicaoAtual.getPosicaoFrente());
		} catch (PosicaoInvalidaException ex) {}
	}

	@Override
	public Posicao getPosicaoAtual() {
		return posicaoAtual;
	}

	public boolean isPosicaoInicial() {
		return posicaoAtual.getY() == 1;
	}
}