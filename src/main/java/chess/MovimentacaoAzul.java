package chess;

public class MovimentacaoAzul implements Movimentacao {

	@Override
	public Posicao getPosicaoFrente(Posicao posicao) {
		return new Posicao(posicao.getX(), posicao.getY() - 1);
	}

	@Override
	public Posicao getPosicaoTraz(Posicao posicao) {
		return new Posicao(posicao.getX(), posicao.getY() + 1);
	}

	@Override
	public Posicao getPosicaoEsquerda(Posicao posicao) {
		return new Posicao(posicao.getX() + 1, posicao.getY());
	}

	@Override
	public Posicao getPosicaoDireita(Posicao posicao) {
		return new Posicao(posicao.getX() - 1, posicao.getY());
	}

	@Override
	public Posicao getPosicaoDiagonalDireitaFrente(Posicao posicao) {
		return new Posicao(posicao.getX() - 1, posicao.getY() - 1);
	}

	@Override
	public Posicao getPosicaoDiagonalEsquerdaFrente(Posicao posicao) {
		return new Posicao(posicao.getX() + 1, posicao.getY() - 1);
	}

	@Override
	public Posicao getPosicaoDiagonalDireitaTraz(Posicao posicao) {
		return new Posicao(posicao.getX() - 1, posicao.getY() + 1);
	}

	@Override
	public Posicao getPosicaoDiagonalEsquerdaTraz(Posicao posicao) {
		return new Posicao(posicao.getX() + 1, posicao.getY() + 1);
	}
}