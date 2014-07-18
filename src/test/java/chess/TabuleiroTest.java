package chess;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TabuleiroTest {

	private Tabuleiro subject;

	@Test
	public void isReiChequeReiVermelho_true() {
		Posicao posicaoReiVermelho = mock(Posicao.class);
		
		Peca pecaQualquer = mock(Peca.class);
		when(pecaQualquer.getPossiveisPosicoes()).thenReturn(asList(posicaoReiVermelho));

		Peca reiVermelho = mock(Peca.class);
		when(reiVermelho.getPosicaoAtual()).thenReturn(posicaoReiVermelho);
		
		subject = new Tabuleiro(reiVermelho);
		subject.addPeca(pecaQualquer);
		
		boolean isCheque = subject.isChequeReiVermelho();
		
		assertTrue(isCheque);
	}
}