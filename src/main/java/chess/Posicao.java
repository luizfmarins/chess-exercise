package chess;

public class Posicao implements Comparable<Posicao>{

	private static final int POSICAO_FINAL_TABULEIRO = 7;
	private static final int POSICAO_INICIAL_TABULEIRO = 0;
	
	private final int x;
	private final int y;
	
	@SuppressWarnings("unused")
	private Posicao(){
		x = POSICAO_INICIAL_TABULEIRO;
		y = POSICAO_INICIAL_TABULEIRO;
	}
	
	public Posicao(int x, int y) {
		validaPosicoes(x, y);
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Posicao getPosicaoFrente() {
		return new Posicao(getX(), getY() + 1);
	}
	
	public Posicao getPosicaoTraz() {
		return new Posicao(getX(), getY() - 1);
	}

	public Posicao getPosicaoEsquerda() {
		return new Posicao(getX() - 1, getY());
	}
	
	public Posicao getPosicaoDireita() {
		return new Posicao(getX() + 1, getY());
	}

	public Posicao getPosicaoDiagonalDireitaFrente() {
		return getPosicaoFrente().getPosicaoDireita();
	}

	public Posicao getPosicaoDiagonalEsquerdaFrente() {
		return getPosicaoFrente().getPosicaoEsquerda();
	}

	public Posicao getPosicaoDiagonalDireitaTraz() {
		return getPosicaoTraz().getPosicaoDireita();
	}

	public Posicao getPosicaoDiagonalEsquerdaTraz() {
		return getPosicaoTraz().getPosicaoEsquerda();
	}
	
	@Override
	public int compareTo(Posicao other) {
		if (x < other.getX()) return -1;
		if (x > other.getX()) return 1;
		if (y > other.getY()) return 1;
		if (y < other.getY()) return -1;
		return 0;
	}
	
	@Override
	public String toString() {
		return "X: " + x + " - Y: " + y;
	}
	
	private void validaPosicoes(int x, int y) {
		if (x < POSICAO_INICIAL_TABULEIRO || y < POSICAO_INICIAL_TABULEIRO)
			throw new PosicaoInvalidaException();
		if (x > POSICAO_FINAL_TABULEIRO || y > POSICAO_FINAL_TABULEIRO)
			throw new PosicaoInvalidaException();
	}
}