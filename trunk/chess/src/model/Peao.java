package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import model.interfaces.AcaoPecaInterface;
import model.interfaces.ListenerPeca;

public class Peao extends Peca implements AcaoPecaInterface {

	private boolean movimentado = false;

	public Peao(int x, int y, CorPeca cor, List<ListenerPeca> listeners) {
		super(x, y, cor, listeners);
	}

	@Override
	public void movimentar(int xDest, int yDest) {
		// TODO Auto-generated method stub

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
	public boolean verificaDest(int xDest, int yDest) {
		if (!voltando(xDest, yDest))
			return false;
		int xDif = xDest - x;
		int yDif = yDest - y;
		if (xDif < 0)
			xDif = xDif * (-1);
		if (yDif < 0)
			yDif = yDif * (-1);
		if (yDif > 0)
			return false;

		if ((!movimentado && xDif > 2) || (movimentado && xDif > 1))
			return false;
		return true;
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
	public Peca capturar(Peca peca) {
		// Verifica se pe�o est� voltando
		if (!voltando(peca.getX(), peca.getY()))
			new IllegalArgumentException("Pe�o n�o pode voltar!");
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
			return peca;
		} else {
			throw new IllegalArgumentException("Imposs�vel capturar!");
		}
	}

	@Override
	public boolean isCheckOponente(Peca[][] pecas) {

		return super.isCheckOponente(pecas);
	}

	@Override
	public ArrayList<Posicao> getPosicoesAtacadas(Peca[][] pecas) {
		Peca peca = null;
		ArrayList<Posicao> lista = new ArrayList<Posicao>();
		// Pretas
		int xAux = x + 1;
		if (cor == CorPeca.Branca)
			xAux = x - 1;
		
		int yAux = x - 1;
		if (xAux < 8 && yAux >=0) {
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
		if (xAux < 8 && yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
		}
		return lista;
	}

}
