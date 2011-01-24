package model;

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
			return peca;
		} else {
			throw new IllegalArgumentException("Impossível capturar!");
		}
	}

	@Override
	public boolean isCheckOponente(Peca[][] pecas) {
		Peca peca = null;
		if(cor == CorPeca.Branca){
			peca = pecas[x-1][y-1];
			if(peca!= null && peca.getClass() == Rei.class && peca.getCor() == CorPeca.Preta){
				return true;
			}
			peca = pecas[x-1][y+1];
			if(peca!= null && peca.getClass() == Rei.class && peca.getCor() == CorPeca.Preta){
				return true;
			}
		}else{
			peca = pecas[x+1][y-1];
			if(peca!= null && peca.getClass() == Rei.class && peca.getCor() == CorPeca.Branca){
				return true;
			}
			peca = pecas[x+1][y+1];
			if(peca!= null && peca.getClass() == Rei.class && peca.getCor() == CorPeca.Branca){
				return true;
			}
		}
		return false;
	}


}
