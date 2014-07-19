package chess.movimentacao;

import chess.posicao.Posicao;

class MovimentacaoVermelha implements Movimentacao {

	public Posicao getPosicaoFrente(Posicao posicao) {
		return new Posicao(posicao.getX(), posicao.getY() + 1);
	}

	public Posicao getPosicaoTraz(Posicao posicao) {
		return new Posicao(posicao.getX(), posicao.getY() - 1);
	}

	public Posicao getPosicaoEsquerda(Posicao posicao) {
		return new Posicao(posicao.getX() - 1, posicao.getY());
	}

	public Posicao getPosicaoDireita(Posicao posicao) {
		return new Posicao(posicao.getX() + 1, posicao.getY());
	}

	public Posicao getPosicaoDiagonalDireitaFrente(Posicao posicao) {
		return new Posicao(posicao.getX() + 1, posicao.getY() + 1);
	}

	public Posicao getPosicaoDiagonalEsquerdaFrente(Posicao posicao) {
		return new Posicao(posicao.getX() - 1, posicao.getY() + 1);
	}

	public Posicao getPosicaoDiagonalDireitaTraz(Posicao posicao) {
		return new Posicao(posicao.getX() + 1, posicao.getY() - 1);
	}

	public Posicao getPosicaoDiagonalEsquerdaTraz(Posicao posicao) {
		return new Posicao(posicao.getX() - 1, posicao.getY() - 1);
	}
}