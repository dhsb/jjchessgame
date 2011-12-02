package model;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.IPeaceAction;
import model.interfaces.ListenerPeca;

public class Torre extends Peca implements IPeaceAction {

	// private boolean movimentado = false;

	public Torre(int x, int y, CorPeca cor, List<ListenerPeca> listeners) {
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
		int xAux = x;
		int yAux = y + 1;
		Peca peca = null;
		ArrayList<Posicao> lista = new ArrayList<Posicao>();
		// Verifica para direita
		while (yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				yAux = 8;
			else {
				yAux++;
			}
		}
		yAux = y - 1;
		// Verifica para esquerda
		while (yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				yAux = -1;
			else {
				yAux--;
			}
		}
		yAux = y;
		xAux = x + 1;
		// Verifica para baixo
		while (xAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				xAux = 8;
			else {
				xAux++;
			}
		}
		xAux = x - 1;
		// Verifica para cima
		while (xAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				xAux = -1;
			else {
				xAux--;
			}
		}
		return lista;
	}

	@Override
	public ArrayList<Posicao> getPosicoesDefendidas(Peca[][] pecas) {
		int xAux = x;
		int yAux = y + 1;
		Peca peca = null;
		ArrayList<Posicao> lista = new ArrayList<Posicao>();
		// Verifica para direita
		while (yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				yAux = 8;
			else {
				yAux++;
			}
		}
		yAux = y - 1;
		// Verifica para esquerda
		while (yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				yAux = -1;
			else {
				yAux--;
			}
		}
		yAux = y;
		xAux = x + 1;
		// Verifica para baixo
		while (xAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				xAux = 8;
			else {
				xAux++;
			}
		}
		xAux = x - 1;
		// Verifica para cima
		while (xAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca != null && peca.getCor() == cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				xAux = -1;
			else {
				xAux--;
			}
		}
		return lista;
	}

}
