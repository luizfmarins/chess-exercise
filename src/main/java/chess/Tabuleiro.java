package chess;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {

	private final List<Peca> pecas = new ArrayList<Peca>();
	private final Peca reiVermelho;
	
	public Tabuleiro(Peca reiVermelho) {
		this.reiVermelho = reiVermelho;
	}
	
	public boolean isChequeReiVermelho() {
		for (Peca peca : pecas)
			for(Posicao posicao : peca.getPossiveisPosicoes())
				if (posicao.equals(reiVermelho.getPosicaoAtual()))
					return true;
		
		return false;
	}

	public void addPeca(Peca peca) {
		pecas.add(peca);
	}
}