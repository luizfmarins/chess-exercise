package chess.peca;

import java.util.ArrayList;
import java.util.List;

import chess.posicao.Posicao;
import chess.posicao.PosicaoInvalidaException;

class Torre implements Peca {

	private static final int POSICAO_FINAL_TABULEIRO = 7;
	private static final int POSICAO_INICIAL_TABULEIRO = 0;
	private final Posicao posicaoAtual;

	public Torre(Posicao posicaoAtual) {
		this.posicaoAtual = posicaoAtual;
	}
	
	@Override
	public List<Posicao> getMovimentacoes() {
		List<Posicao> posicoes = new ArrayList<Posicao>();
		
		posicoes.addAll(adicionaMovimentacoesHorizontais());
		posicoes.addAll(adicionaMovimentacoesVerticais());
		
		return posicoes;
	}

	@Override
	public Posicao getPosicaoAtual() {
		return posicaoAtual;
	}
	
	private List<Posicao> adicionaMovimentacoesVerticais() {
		List<Posicao> posicoes = new ArrayList<Posicao>();
		
		for (int y = posicaoAtual.getY() - 1; y >= POSICAO_INICIAL_TABULEIRO; y --)
			addPosicao(posicoes, posicaoAtual.getX(), y);
		
		for (int y = posicaoAtual.getY() + 1; y <= 7; y ++)
			addPosicao(posicoes, posicaoAtual.getX(), y);
		
		return posicoes;
	}

	private List<Posicao> adicionaMovimentacoesHorizontais() {
		List<Posicao> posicoes = new ArrayList<Posicao>();
		
		for (int x = posicaoAtual.getX() - 1; x >= POSICAO_INICIAL_TABULEIRO; x --)
			addPosicao(posicoes, x, posicaoAtual.getY());
		
		for (int x = posicaoAtual.getX() + 1; x <= POSICAO_FINAL_TABULEIRO; x ++)
			addPosicao(posicoes, x, posicaoAtual.getY());
		
		return posicoes;
	}

	private void addPosicao(List<Posicao> posicoes, int x, int y) {
		try {
			posicoes.add(new Posicao(x, y));
		} catch(PosicaoInvalidaException ex) {}
	}
}