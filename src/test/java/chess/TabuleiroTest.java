package chess;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import chess.peca.Peca;
import chess.posicao.Posicao;

@RunWith(MockitoJUnitRunner.class)
public class TabuleiroTest {

	private Tabuleiro subject;

	@Mock private Peca reiAzul;
	@Mock private Peca reiVermelho;
	@Mock private Posicao posicaoReiVermelho;
	@Mock private Posicao posicaoReiAzul;
	
	@Before
	public void before() {
		when(reiVermelho.getPosicaoAtual()).thenReturn(posicaoReiVermelho);
		when(reiAzul.getPosicaoAtual()).thenReturn(posicaoReiAzul);
	}
	
	@Test
	public void isChequeReiVermelho_unicaPeca_true() {
		Peca pecaQualquer = mock(Peca.class);
		when(pecaQualquer.getMovimentacoes()).thenReturn(asList(posicaoReiVermelho));
		
		subject = new Tabuleiro(reiVermelho, reiAzul);
		subject.addPecaAzul(pecaQualquer);
		
		boolean isCheque = subject.isChequeReiVermelho();
		
		assertTrue(isCheque);
	}
	
	@Test
	public void isChequeReiVermelho_unicaPeca_false() {
		Posicao outraPosicaoQualquer = mock(Posicao.class);
		
		Peca peca = mock(Peca.class);
		when(peca.getMovimentacoes()).thenReturn(asList(outraPosicaoQualquer));

		subject = new Tabuleiro(reiVermelho, reiAzul);
		subject.addPecaAzul(peca);
		
		boolean isCheque = subject.isChequeReiVermelho();
		
		assertFalse(isCheque);
	}
	
	@Test
	public void isChequeReiVermelho_duasPecas_umaEmCheque() {
		Posicao outraPosicaoQualquer = mock(Posicao.class);
		
		Peca peca = mock(Peca.class);
		Peca peca2 = mock(Peca.class);
		when(peca.getMovimentacoes()).thenReturn(asList(outraPosicaoQualquer));
		when(peca2.getMovimentacoes()).thenReturn(asList(posicaoReiVermelho));
		
		subject = new Tabuleiro(reiVermelho, reiAzul);
		subject.addPecaAzul(peca);
		subject.addPecaAzul(peca2);
		
		boolean isCheque = subject.isChequeReiVermelho();
		
		assertTrue(isCheque);
	}
	
	@Test
	public void isChequeReiVermelho_duasPecas_nenhumaEmCheque() {
		Posicao outraPosicaoQualquer = mock(Posicao.class);
		
		Peca peca = mock(Peca.class);
		Peca peca2 = mock(Peca.class);
		when(peca.getMovimentacoes()).thenReturn(asList(outraPosicaoQualquer));
		when(peca2.getMovimentacoes()).thenReturn(asList(outraPosicaoQualquer));
		
		subject = new Tabuleiro(reiVermelho, reiAzul);
		subject.addPecaAzul(peca);
		subject.addPecaAzul(peca2);
		
		boolean isCheque = subject.isChequeReiVermelho();
		
		assertFalse(isCheque);
	}
	
	@Test
	public void isChequeReiVermelho_unicaPeca_umaPosicaoCheque_outraNao() {
		Posicao posicaoQualquer = mock(Posicao.class);
		
		Peca pecaQualquer = mock(Peca.class);
		when(pecaQualquer.getMovimentacoes()).thenReturn(asList(posicaoReiVermelho, posicaoQualquer));
		
		subject = new Tabuleiro(reiVermelho, reiAzul);
		subject.addPecaAzul(pecaQualquer);
		
		boolean isCheque = subject.isChequeReiVermelho();
		
		assertTrue(isCheque);
	}
	
	@Test
	public void isChequeReiVermelho_unicaPeca_duasPosicoes_semCheque() {
		Posicao posicaoQualquer = mock(Posicao.class);
		Posicao posicaoQualquer2 = mock(Posicao.class);
		
		Peca pecaQualquer = mock(Peca.class);
		when(pecaQualquer.getMovimentacoes()).thenReturn(asList(posicaoQualquer2, posicaoQualquer));

		subject = new Tabuleiro(reiVermelho, reiAzul);
		subject.addPecaAzul(pecaQualquer);
		
		boolean isCheque = subject.isChequeReiVermelho();
		
		assertFalse(isCheque);
	}
	
	@Test
	public void isChequeReiAzul_unicaPeca_true() {
		Peca peca = mock(Peca.class);
		when(peca.getMovimentacoes()).thenReturn(asList(posicaoReiAzul));
		
		subject = new Tabuleiro(reiVermelho, reiAzul);
		subject.addPecaVermelha(peca);
		boolean isCheque = subject.isChequeReiAzul();
		
		assertTrue(isCheque);
	}
	
	@Test
	public void isChequeReiAzul_unicaPeca_false() {
		Peca peca = mock(Peca.class);
		when(peca.getMovimentacoes()).thenReturn(asList(mock(Posicao.class)));
		
		subject = new Tabuleiro(reiVermelho, reiAzul);
		subject.addPecaVermelha(peca);
		boolean isCheque = subject.isChequeReiAzul();
		
		assertFalse(isCheque);
	}
}