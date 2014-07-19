package chess.peca.util;

import static org.junit.Assert.assertEquals;
import chess.posicao.Posicao;

public final class AssertPosicao {

	private AssertPosicao() {}

	public static void assertPosicao(int x, int y, Posicao posicao) {
		assertEquals(x, posicao.getX());
		assertEquals(y, posicao.getY());
	}
}