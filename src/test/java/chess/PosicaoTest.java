package chess;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PosicaoTest {

	@Rule public ExpectedException exception = ExpectedException.none(); 

	private Posicao subject;
	
	@Test
	public void compareTo() {
		final Posicao posicao = new Posicao(0, 0);
		final Posicao posicao2 = new Posicao(1, 0);
		final Posicao posicao3 = new Posicao(0, 1);
		final Posicao posicao4 = new Posicao(1, 1);
		final Posicao posicao5 = new Posicao(0, 2);
		final Posicao posicao6 = new Posicao(1, 2);
		final Posicao posicao7 = new Posicao(2, 2);
		final Posicao posicao8 = new Posicao(2, 1);
		
		@SuppressWarnings("serial")
		List<Posicao> list = new ArrayList<Posicao>(){{
			add(posicao);
			add(posicao2);
			add(posicao3);
			add(posicao4);
			add(posicao5);
			add(posicao6);
			add(posicao7);
			add(posicao8);
		}};
		
		Collections.sort(list);
		
		assertArrayEquals(new Posicao[] {posicao, posicao3, posicao5, posicao2, posicao4, posicao6, posicao8, posicao7}, list.toArray());
	}
	
	@Test
	public void posicaoInvalida_eixoX_negativo() {
		exception.expect(PosicaoInvalidaException.class);
		
		new Posicao(-1, 0);
	}
	
	@Test
	public void posicaoInvalida_eixoY_negativo() {
		exception.expect(PosicaoInvalidaException.class);
		
		new Posicao(0, -1);
	}
	
	@Test
	public void posicaoInvalida_eixoX_maiorSete() {
		exception.expect(PosicaoInvalidaException.class);
		
		new Posicao(8, 0);
	}
	
	@Test
	public void posicaoInvalida_eixoY_maiorSete() {
		exception.expect(PosicaoInvalidaException.class);
		
		new Posicao(0, 8);
	}
	
	@Test
	public void getPosicaoFrente() {
		subject = new Posicao(2, 2);
		
		Posicao posicaoFrente = subject.getPosicaoFrente();
		assertEquals(2, posicaoFrente.getX());
		assertEquals(3, posicaoFrente.getY());
	}
	
	@Test
	public void getPosicaoTraz() {
		subject = new Posicao(2, 2);
		
		Posicao posicaoFrente = subject.getPosicaoTraz();
		assertEquals(2, posicaoFrente.getX());
		assertEquals(1, posicaoFrente.getY());
	}
	
	@Test
	public void getPosicaoEsquerda() {
		subject = new Posicao(2, 2);
		
		Posicao posicaoFrente = subject.getPosicaoEsquerda();
		assertEquals(1, posicaoFrente.getX());
		assertEquals(2, posicaoFrente.getY());
	}
	
	@Test
	public void getPosicaoDireita() {
		subject = new Posicao(2, 2);
		
		Posicao posicaoFrente = subject.getPosicaoDireita();
		assertEquals(3, posicaoFrente.getX());
		assertEquals(2, posicaoFrente.getY());
	}
	
	@Test
	public void getPosicaoDiagonalDireitaFrente() {
		subject = new Posicao(2, 2);
		
		Posicao posicaoFrente = subject.getPosicaoDiagonalDireitaFrente();
		assertEquals(3, posicaoFrente.getX());
		assertEquals(3, posicaoFrente.getY());
	}
	
	@Test
	public void getPosicaoDiagonalEsquerdaFrente() {
		subject = new Posicao(2, 2);
		
		Posicao posicaoFrente = subject.getPosicaoDiagonalEsquerdaFrente();
		assertEquals(1, posicaoFrente.getX());
		assertEquals(3, posicaoFrente.getY());
	}
	
	@Test
	public void getPosicaoDiagonalDireitaTraz() {
		subject = new Posicao(2, 2);
		
		Posicao posicaoFrente = subject.getPosicaoDiagonalDireitaTraz();
		assertEquals(3, posicaoFrente.getX());
		assertEquals(1, posicaoFrente.getY());
	}
	
	@Test
	public void getPosicaoDiagonalEsquerdaTraz() {
		subject = new Posicao(2, 2);
		
		Posicao posicaoFrente = subject.getPosicaoDiagonalEsquerdaTraz();
		assertEquals(1, posicaoFrente.getX());
		assertEquals(1, posicaoFrente.getY());
	}
}
