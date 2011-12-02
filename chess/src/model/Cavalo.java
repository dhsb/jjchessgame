package model;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.IPeaceAction;
import model.interfaces.ListenerPeca;

public class Cavalo extends Peca implements IPeaceAction {

	public Cavalo(int x, int y, CorPeca cor, List<ListenerPeca> listeners) {
		super(x, y, cor, listeners);
	}

	@Override
	public void movimentar(int xDest, int yDest) {
		this.xOld = x;
		this.yOld = y;
		this.x = xDest;
		this.y = yDest;
		// movimentado = true;
		for (ListenerPeca listener : listeners) {
			listener.alterouPosicao(this);
		}
	}

	@Override
	public void capturar(Peca peca) {
		super.capturar(peca);
	}

	@Override
	public ArrayList<Posicao> getPosicoesAtacadas(Peca[][] pecas) {

		Peca peca = null;
		ArrayList<Posicao> lista = new ArrayList<Posicao>();
		int xAux = x + 2;
		int yAux = y + 1;
		if (xAux < 8 && yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		xAux = x + 2;
		yAux = y - 1;
		if (xAux < 8 && yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		xAux = x - 2;
		yAux = y + 1;
		if (xAux >= 0 && yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		xAux = x - 2;
		yAux = y - 1;
		if (xAux >= 0 && yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		// //
		xAux = x + 1;
		yAux = y + 2;
		if (xAux < 8 && yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		xAux = x + 1;
		yAux = y - 2;
		if (xAux < 8 && yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		xAux = x - 1;
		yAux = y + 2;
		if (xAux >= 0 && yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}

		xAux = x - 1;
		yAux = y - 2;
		if (xAux >= 0 && yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		return lista;
	}

	@Override
	public ArrayList<Posicao> getPosicoesDefendidas(Peca[][] pecas) {
		Peca peca = null;
		ArrayList<Posicao> lista = new ArrayList<Posicao>();
		int xAux = x + 2;
		int yAux = y + 1;
		if (xAux < 8 && yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		xAux = x + 2;
		yAux = y - 1;
		if (xAux < 8 && yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		xAux = x - 2;
		yAux = y + 1;
		if (xAux >= 0 && yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		xAux = x - 2;
		yAux = y - 1;
		if (xAux >= 0 && yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		// //
		xAux = x + 1;
		yAux = y + 2;
		if (xAux < 8 && yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		xAux = x + 1;
		yAux = y - 2;
		if (xAux < 8 && yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		xAux = x - 1;
		yAux = y + 2;
		if (xAux >= 0 && yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}

		xAux = x - 1;
		yAux = y - 2;
		if (xAux >= 0 && yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		return lista;
	}
}
