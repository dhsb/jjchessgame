package model;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.IPeaceAction;
import model.interfaces.ListenerPeca;

public class Rei extends Peca implements IPeaceAction {

	private Boolean movimentado = false;

	public Rei(int x, int y, CorPeca cor, List<ListenerPeca> listeners) {
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

	@Override
	public void capturar(Peca peca) {
		super.capturar(peca);
	}

	public Boolean getMovimentado() {
		return movimentado;
	}

	@Override
	public boolean isCheckOponente(Peca[][] pecas) {
		return false;
	}

	@Override
	public ArrayList<Posicao> getPosicoesAtacadas(Peca[][] pecas) {
		int xAux = x;
		int yAux = y;
		Peca peca = null;
		ArrayList<Posicao> lista = new ArrayList<Posicao>();
		// Verifica para baixo
		if (xAux + 1 < 8) {
			peca = pecas[xAux + 1][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux + 1, yAux));
			}
		}
		// Verifica para cima
		if (xAux - 1 >= 0) {
			peca = pecas[xAux - 1][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux - 1, yAux));
			}
		}
		// Verifica para direita
		if (yAux + 1 < 8) {
			peca = pecas[xAux][yAux + 1];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux + 1));
			}
		}
		// Verifica para esquerda
		if (yAux - 1 >= 0) {
			peca = pecas[xAux][yAux - 1];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux - 1));
			}
		}
		// Verifica canto inferior direito
		if (xAux + 1 < 8 && yAux + 1 < 8) {
			peca = pecas[xAux + 1][yAux + 1];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux + 1, yAux + 1));
			}
		}
		// Verifica canto superior direito
		if (xAux - 1 >= 0 && yAux + 1 < 8) {
			peca = pecas[xAux - 1][yAux + 1];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux - 1, yAux + 1));
			}
		}
		// Verifica canto inferior esquerdo
		if (xAux + 1 < 8 && yAux - 1 >= 0) {
			peca = pecas[xAux + 1][yAux - 1];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux + 1, yAux - 1));
			}
		}
		// Verifica canto superior esquerdo
		if (xAux - 1 >= 0 && yAux - 1 < 8) {
			peca = pecas[xAux - 1][yAux - 1];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux - 1, yAux - 1));
			}
		}

		return lista;
	}

	@Override
	public ArrayList<Posicao> getPosicoesDefendidas(Peca[][] pecas) {
		int xAux = x + 1;
		int yAux = y;
		Peca peca = null;
		ArrayList<Posicao> lista = new ArrayList<Posicao>();
		// Verifica para baixo
		if (xAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		// Verifica para cima
		xAux = x - 1;
		if (xAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		// Verifica para direita
		yAux = y + 1;
		xAux = x;
		if (yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		// Verifica para esquerda
		yAux = y - 1;
		if (yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		// Verifica canto inferior direito
		xAux = x + 1;
		yAux = y + 1;
		if (xAux < 8 && yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		// Verifica canto superior direito
		xAux = x - 1;
		yAux = y + 1;
		if (xAux >= 0 && yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		// Verifica canto inferior esquerdo
		xAux = x + 1;
		yAux = y - 1;
		if (xAux < 8 && yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		// Verifica canto superior esquerdo
		xAux = x - 1;
		yAux = y - 1;
		if (xAux >= 0 && yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		return lista;
	}
}
