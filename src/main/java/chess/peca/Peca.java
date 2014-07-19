package chess.peca;

import java.util.List;

import chess.posicao.Posicao;

public interface Peca {

	List<Posicao> getMovimentacoes();

	Posicao getPosicaoAtual();
}
