package chess.movimentacao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import chess.movimentacao.MovimentacaoVermelha;
import chess.posicao.Posicao;

@RunWith(MockitoJUnitRunner.class)
public class MovimentacaoVermelhaTest {

	private Posicao posicao = new Posicao(2, 2);
	private MovimentacaoVermelha subject = new MovimentacaoVermelha();
	
	@Test
	public void getPosicaoFrente() {
		Posicao posicaoFrente = subject.getPosicaoFrente(posicao);
		assertEquals(2, posicaoFrente.getX());
		assertEquals(3, posicaoFrente.getY());
	}
	
	@Test
	public void getPosicaoTraz() {
		Posicao posicaoFrente = subject.getPosicaoTraz(posicao);
		assertEquals(2, posicaoFrente.getX());
		assertEquals(1, posicaoFrente.getY());
	}
	
	@Test
	public void getPosicaoEsquerda() {
		Posicao posicaoFrente = subject.getPosicaoEsquerda(posicao);
		assertEquals(1, posicaoFrente.getX());
		assertEquals(2, posicaoFrente.getY());
	}
	
	@Test
	public void getPosicaoDireita() {
		Posicao posicaoFrente = subject.getPosicaoDireita(posicao);
		assertEquals(3, posicaoFrente.getX());
		assertEquals(2, posicaoFrente.getY());
	}
	
	@Test
	public void getPosicaoDiagonalDireitaFrente() {
		Posicao posicaoFrente = subject.getPosicaoDiagonalDireitaFrente(posicao);
		assertEquals(3, posicaoFrente.getX());
		assertEquals(3, posicaoFrente.getY());
	}
	
	@Test
	public void getPosicaoDiagonalEsquerdaFrente() {
		Posicao posicaoFrente = subject.getPosicaoDiagonalEsquerdaFrente(posicao);
		assertEquals(1, posicaoFrente.getX());
		assertEquals(3, posicaoFrente.getY());
	}
	
	@Test
	public void getPosicaoDiagonalDireitaTraz() {
		Posicao posicaoFrente = subject.getPosicaoDiagonalDireitaTraz(posicao);
		assertEquals(3, posicaoFrente.getX());
		assertEquals(1, posicaoFrente.getY());
	}
	
	@Test
	public void getPosicaoDiagonalEsquerdaTraz() {
		Posicao posicaoFrente = subject.getPosicaoDiagonalEsquerdaTraz(posicao);
		assertEquals(1, posicaoFrente.getX());
		assertEquals(1, posicaoFrente.getY());
	}
}