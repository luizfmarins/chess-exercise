package chess;

interface Movimentacao {

	Posicao getPosicaoFrente(Posicao posicao);

	Posicao getPosicaoTraz(Posicao posicao);

	Posicao getPosicaoEsquerda(Posicao posicao);

	Posicao getPosicaoDireita(Posicao posicao);

	Posicao getPosicaoDiagonalDireitaFrente(Posicao posicao);

	Posicao getPosicaoDiagonalEsquerdaFrente(Posicao posicao);

	Posicao getPosicaoDiagonalDireitaTraz(Posicao posicao);

	Posicao getPosicaoDiagonalEsquerdaTraz(Posicao posicao);
}