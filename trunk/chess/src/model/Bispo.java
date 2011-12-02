package model;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.IPeaceAction;
import model.interfaces.ListenerPeca;

public class Bispo extends Peca implements IPeaceAction {

	public Bispo(int x, int y, CorPeca cor, List<ListenerPeca> listeners) {
		super(x, y, cor, listeners);
	}

	@Override
	public void movimentar(int xDest, int yDest) {
		this.xOld = x;
		this.yOld = y;
		this.x = xDest;
		this.y = yDest;
		System.out.println("movimentou");
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
		int xAux = x + 1;
		int yAux = y + 1;
		Peca peca = null;
		ArrayList<Posicao> lista = new ArrayList<Posicao>();
		while (xAux < 8 && yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				yAux = 8;
			else {
				yAux++;
				xAux++;
			}
		}

		xAux = x - 1;
		yAux = y + 1;
		while (xAux >= 0 && yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				yAux = 8;
			else {
				xAux--;
				yAux++;
			}
		}
		xAux = x - 1;
		yAux = y - 1;
		while (xAux >= 0 && yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				yAux = -1;
			else {
				xAux--;
				yAux--;
			}
		}
		xAux = x + 1;
		yAux = y - 1;
		while (xAux < 8 && yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				yAux = -1;
			else {
				xAux++;
				yAux--;
			}
		}
		return lista;
	}

	@Override
	public ArrayList<Posicao> getPosicoesDefendidas(Peca[][] pecas) {
		int xAux = x + 1;
		int yAux = y + 1;
		Peca peca = null;
		ArrayList<Posicao> lista = new ArrayList<Posicao>();
		while (xAux < 8 && yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				yAux = 8;
			else {
				yAux++;
				xAux++;
			}
		}

		xAux = x - 1;
		yAux = y + 1;
		while (xAux >= 0 && yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				yAux = 8;
			else {
				xAux--;
				yAux++;
			}
		}
		xAux = x - 1;
		yAux = y - 1;
		while (xAux >= 0 && yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				yAux = -1;
			else {
				xAux--;
				yAux--;
			}
		}
		xAux = x + 1;
		yAux = y - 1;
		while (xAux < 8 && yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				yAux = -1;
			else {
				xAux++;
				yAux--;
			}
		}
		System.out.println("Lista getPosicoesAlcance " + lista.size());
		return lista;
	}
}
