package chess;

import java.util.List;

public interface Peca {

	List<Posicao> getPossiveisPosicoes();

	Posicao getPosicaoAtual();
}
