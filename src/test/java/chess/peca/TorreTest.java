package chess.peca;

import static chess.peca.util.AssertPosicao.assertPosicao;
import static java.util.Collections.sort;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import chess.posicao.Posicao;

@RunWith(MockitoJUnitRunner.class)
public class TorreTest {

	private Torre subject = new Torre(new Posicao(5, 5));
	
	@Test
	public void getMovimentacoes_assertQuantidadeMovimentacoes() {
		List<Posicao> movimentacoes = subject.getMovimentacoes();
		
		assertEquals(14, movimentacoes.size());
	}
	
	@Test
	public void getMovimentacoes_assertPosicoes() {
		List<Posicao> movimentacoes = subject.getMovimentacoes();
		
		sort(movimentacoes);
		
		assertPosicao(0, 5, movimentacoes.get(0));
		assertPosicao(1, 5, movimentacoes.get(1));
		assertPosicao(2, 5, movimentacoes.get(2));
		assertPosicao(3, 5, movimentacoes.get(3));
		assertPosicao(4, 5, movimentacoes.get(4));
		assertPosicao(5, 0, movimentacoes.get(5));
		assertPosicao(5, 1, movimentacoes.get(6));
		assertPosicao(5, 2, movimentacoes.get(7));
		assertPosicao(5, 3, movimentacoes.get(8));
		assertPosicao(5, 4, movimentacoes.get(9));
		assertPosicao(5, 6, movimentacoes.get(10));
		assertPosicao(5, 7, movimentacoes.get(11));
		assertPosicao(6, 5, movimentacoes.get(12));
		assertPosicao(7, 5, movimentacoes.get(13));
	}
}