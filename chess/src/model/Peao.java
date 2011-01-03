package model;

import javax.swing.ImageIcon;

import model.interfaces.AcaoPecaInterface;
import model.interfaces.ListenerPeca;

public class Peao extends Peca implements AcaoPecaInterface {

	private boolean movimentado = false;

	public Peao(int x, int y, CorPeca cor, ListenerPeca listener) {
		super(x, y, cor, listener);
		this.imagem = new ImageIcon("Peao" + this.cor.toString() + ".jpg");
	}

	@Override
	public void movimentar(int xDest, int yDest) {
		// TODO Auto-generated method stub

		this.xOld = x;
		this.yOld = y;
		this.x = xDest;
		this.y = yDest;
		movimentado = true;
		this.listener.alterouPosicao(this);
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
		//Verifica se peão está voltando
		if(!voltando(peca.getX(), peca.getY()))
			new IllegalArgumentException("Peão não pode voltar!");
		int xDif = peca.getX() - x;
		int yDif = peca.getY() - y;
		if (xDif < 0)
			xDif = xDif * (-1);
		if (yDif < 0)
			yDif = yDif * (-1);
		if (xDif == 1 && yDif == 1) {
			listener.foiCapturada(peca);
			movimentar(peca.getX(), peca.getY());
			return peca;
		} else {
			throw new IllegalArgumentException("Impossível capturar!");
		}
	}

}
