package chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PeaoTest {

	private Peao subject;
	
	@Test
	public void getMovimetacoes_posicaoInicial_quatroMovimentacoes() {
		subject = new Peao(new Posicao(1, 1));
		List<Posicao> possiveisPosicoes = subject.getMovimentacoes();
		
		assertEquals(4, possiveisPosicoes.size());	
	}
	
	@Test
	public void getMovimetacoes_posicaoNaoInicial_tresMovimentacoes() {
		subject = new Peao(new Posicao(3, 0));
		List<Posicao> possiveisPosicoes = subject.getMovimentacoes();
		
		assertEquals(3, possiveisPosicoes.size());	
	}
	
	@Test
	public void isPosicaoIncial_true() {
		for (int x = 0; x <= 7; x++) {
			subject = new Peao(new Posicao(x, 1));
			assertTrue(subject.isPosicaoInicial());
		}
	}
	
	@Test
	public void isPosicaoIncial_false() {
		for (int x= 0; x <= 7; x++) {
			subject = new Peao(new Posicao(0, 2));
			assertFalse(subject.isPosicaoInicial());
		}
	}
	
	@Test
	public void geMovimentacoes_semPecasNoCaminho_posicaoIncial() {
		subject = new Peao(new Posicao(1, 1));
		List<Posicao> posicoes = subject.getMovimentacoes();
		
		assertQuantidadePosicoes(4, posicoes);
		
		assertPosicao(0, 2, posicoes.get(0)); 
		assertPosicao(1, 2, posicoes.get(1)); 
		assertPosicao(1, 3, posicoes.get(2)); 
		assertPosicao(2, 2, posicoes.get(3)); 
	}
	
	@Test
	public void geMovimentacoes_semPecasNoCaminho_posicaoNaoIncial() {
		subject = new Peao(new Posicao(1, 2));
		List<Posicao> posicoes = subject.getMovimentacoes();
		
		assertQuantidadePosicoes(3, posicoes);
		
		assertPosicao(0, 3, posicoes.get(0)); 
		assertPosicao(1, 3, posicoes.get(1)); 
		assertPosicao(2, 3, posicoes.get(2)); 
	}
	
	@Test
	public void getMovimentacoes_extremidadeEsquerdaTabuleiro() {
		subject = new Peao(new Posicao(0, 2));
		List<Posicao> posicoes = subject.getMovimentacoes();
		
		assertQuantidadePosicoes(2, posicoes);
		
		assertPosicao(0, 3, posicoes.get(0)); 
		assertPosicao(1, 3, posicoes.get(1)); 
	}
	
	@Test
	public void getMovimentacoes_extremidadeDireitaTabuleiro() {
		subject = new Peao(new Posicao(7, 2));
		List<Posicao> posicoes = subject.getMovimentacoes();
		
		assertQuantidadePosicoes(2, posicoes);
		
		assertPosicao(6, 3, posicoes.get(0)); 
		assertPosicao(7, 3, posicoes.get(1)); 
	}

	private void assertPosicao(int x, int y, Posicao posicao) {
		assertEquals(x, posicao.getX());
		assertEquals(y, posicao.getY());
	}
	
	private void assertQuantidadePosicoes(int quant, List<Posicao> posicoes) {
		assertEquals(quant, posicoes.size());
	}
}