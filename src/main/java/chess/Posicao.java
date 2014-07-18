package chess;

public class Posicao implements Comparable<Posicao>{

	private final int x;
	private final int y;
	
	@SuppressWarnings("unused")
	private Posicao(){
		x = 0;
		y = 0;
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
		if (x < 0 || y < 0)
			throw new PosicaoInvalidaException();
		if (x > 7 || y > 7)
			throw new PosicaoInvalidaException();
	}
}