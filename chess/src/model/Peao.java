package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.interfaces.IPeaceAction;
import model.interfaces.ListenerPeca;

public class Peao extends Peca implements IPeaceAction {

	private boolean movimentado = false;

	public Peao(int x, int y, CorPeca cor, List<ListenerPeca> listeners) {
		super(x, y, cor, listeners);
	}

	@Override
	public void movimentar(int xDest, int yDest) {
		this.xOld = x;
		this.yOld = y;
		this.x = xDest;
		this.y = yDest;
		movimentado = true;
		for (ListenerPeca listener : listeners) {
			listener.alterouPosicao(this);
		}
	}

	public boolean voltando(int xDest, int yDest) {
		if (cor == CorPeca.Branca) {
			if (xDest > x)
				return false;
		} else {
			if (xDest < x)
				return false;
		}
		return true;

	}

	@Override
	public void capturar(Peca peca) {
		// Verifica se peï¿½o estï¿½ voltando
		if (!voltando(peca.getX(), peca.getY()))
			new IllegalArgumentException("Peão não pode voltar!");
		int xDif = peca.getX() - x;
		int yDif = peca.getY() - y;
		if (xDif < 0)
			xDif = xDif * (-1);
		if (yDif < 0)
			yDif = yDif * (-1);
		if (xDif == 1 && yDif == 1) {
			for (ListenerPeca listener : listeners) {
				listener.foiCapturada(peca);
			}
			movimentar(peca.getX(), peca.getY());
		} else {
			throw new IllegalArgumentException("Impossível capturar!");
		}
	}

	@Override
	public boolean isCheckOponente(Peca[][] pecas) {

		return super.isCheckOponente(pecas);
	}

	private void checkDiagonalForAtaque(int linha, int coluna, Peca[][] pecas,
			List<Posicao> lista) {
		if (linha < 0 || coluna < 0 || linha > 7 || coluna > 7)
			return;
		Peca peca = pecas[linha][coluna];
		if (peca != null && peca.getCor() != cor) {
			lista.add(new Posicao(linha, coluna));
		}
	}

	private void checkFrenteForAtaque(int linha, int coluna, Peca[][] pecas,
			List<Posicao> lista) {
		if (linha < 0 || coluna < 0 || linha > 7 || coluna > 7)
			return;
		Peca peca = pecas[linha][coluna];
		if (peca == null || peca.getCor() == cor) {
			lista.add(new Posicao(linha, coluna));
		}
	}

	/**
	 * Retorna as posições atacas por um peão Branco
	 * 
	 * @param pecas
	 * @return
	 */
	private ArrayList<Posicao> getPosicoesAtacadasBranca(Peca[][] pecas) {
		ArrayList<Posicao> lista = new ArrayList<Posicao>();
		// Diagonal esquerda
		int xAux = x - 1;
		int yAux = y - 1;
		checkDiagonalForAtaque(xAux, yAux, pecas, lista);
		// Diagonal Direita
		yAux = y + 1;
		checkDiagonalForAtaque(xAux, yAux, pecas, lista);

		// Frente
		yAux = y;
		checkFrenteForAtaque(xAux, yAux, pecas, lista);

		if (!movimentado) {
			xAux = x - 2;
			checkFrenteForAtaque(xAux, yAux, pecas, lista);
		}
		return lista;
	}

	private ArrayList<Posicao> getPosicoesAtacadasPreta(Peca[][] pecas) {
		ArrayList<Posicao> lista = new ArrayList<Posicao>();
		// Diagonal esquerda - somente se tiver peça adversária
		int xAux = x + 1;
		int yAux = y - 1;
		checkDiagonalForAtaque(xAux, yAux, pecas, lista);
		// Diagonal direita - somente se tiver peça adversária
		yAux = y + 1;
		checkDiagonalForAtaque(xAux, yAux, pecas, lista);

		// Frente
		yAux = y;
		checkFrenteForAtaque(xAux, yAux, pecas, lista);

		if (!movimentado) {
			xAux = x + 2;
			checkFrenteForAtaque(xAux, yAux, pecas, lista);
		}
		return lista;
	}

	private ArrayList<Posicao> getPosicoesAtacadasByCor(Peca[][] pecas) {
		if (cor == CorPeca.Branca)
			return getPosicoesAtacadasBranca(pecas);
		else
			return getPosicoesAtacadasPreta(pecas);
	}

	/**
	 * As posições atacadas pelo peão podem retornar 1,2,3 ou 4 casas.<br>
	 * As posições atacadas do peão funciona da seguinte forma:<br>
	 * É considerado as posições para onde ele pode se mover; <br>
	 * Caso ainda não tenha se movimentado, são consideradas uma ou duas linhas
	 * para frente na mesma coluna.<br>
	 * Caso tenha um inimigo na primeira posição em sua diagonal para frente,
	 * esta posição é considerada;
	 * 
	 * 
	 */
	@Override
	public ArrayList<Posicao> getPosicoesAtacadas(Peca[][] pecas) {
		return getPosicoesAtacadasByCor(pecas);
	}

	@Override
	public ArrayList<Posicao> getPosicoesDefendidas(Peca[][] pecas) {
		ArrayList<Posicao> lista = getPosicoesAtacadas(pecas);
		Iterator<Posicao> it = lista.iterator();
		Posicao p = null;
		while (it.hasNext()) {
			p = it.next();
			if (p.getY() == y) {
				it.remove();
			}
		}
		return lista;
	}
}
