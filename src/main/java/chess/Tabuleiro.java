package chess;

import java.util.ArrayList;
import java.util.List;

import chess.peca.Peca;
import chess.posicao.Posicao;

public class Tabuleiro {

	private final List<Peca> pecasAzuis = new ArrayList<Peca>();
	private final List<Peca> pecasVermelhas = new ArrayList<Peca>();
	
	private final Peca reiVermelho;
	private final Peca reiAzul;
	
	public Tabuleiro(Peca reiVermelho, Peca reiAzul) {
		this.reiVermelho = reiVermelho;
		this.reiAzul = reiAzul;
	}
	
	public boolean isChequeReiVermelho() {
		return isReiEmCheque(reiVermelho, pecasAzuis);
	}

	public boolean isChequeReiAzul() {
		return isReiEmCheque(reiAzul, pecasVermelhas);
	}
	
	public void addPecaAzul(Peca peca) {
		pecasAzuis.add(peca);
	}

	public void addPecaVermelha(Peca peca) {
		pecasVermelhas.add(peca);
	}

	private boolean isReiEmCheque(Peca rei, List<Peca> pecasPossivelAtaque) {
		for (Peca peca : pecasPossivelAtaque)
			for(Posicao posicao : peca.getMovimentacoes()) 
				if (posicao.equals(rei.getPosicaoAtual()))
					return true;
		
		return false;
	}
}