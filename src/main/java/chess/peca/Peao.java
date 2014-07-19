package chess.peca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chess.movimentacao.Movimentacao;
import chess.posicao.Posicao;
import chess.posicao.PosicaoInvalidaException;

class Peao implements Peca {

	private final Posicao posicaoAtual;
	private final Movimentacao movimentacao;
	
	public Peao(Posicao posicaoAtual, Movimentacao movimentacao) {
		this.posicaoAtual = posicaoAtual;
		this.movimentacao = movimentacao;
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
			Posicao p = movimentacao.getPosicaoFrente(posicaoAtual);
			posicoes.add(movimentacao.getPosicaoFrente(p));
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