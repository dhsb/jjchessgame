package model;

import javax.swing.ImageIcon;

import model.interfaces.AcaoPecaInterface;
import model.interfaces.ListenerPeca;

public class Rei extends Peca implements AcaoPecaInterface {

	public Rei(int x, int y, CorPeca cor, ListenerPeca listener) {
		super(x, y, cor, listener);
		this.imagem = new ImageIcon("Peao" + this.cor.toString() + ".jpg");
	}

	@Override
	public void movimentar(int xDest, int yDest) {
		if (verificaDest(xDest, yDest)) {
			this.x = xDest;
			this.y = yDest;
			this.listener.alterouPosicao(this);
		}
	}

	@Override
	public boolean verificaDest(int xDest, int yDest) {
		int xDif = xDest - x;
		int yDif = yDest - y;
		if (xDif < 0)
			xDif = xDif * (-1);
		if (yDif < 0)
			yDif = yDif * (-1);
		System.out.println(xDest);
		if (xDif == 1 && yDif == 1)// moveu rei uma casa para diagonal
			return true;
		else if (xDif == 1 && yDif == 0) // 
			return true;
		return false;
	}

	@Override
	public Peca capturar(Peca peca) {
		return peca;
		// TODO Auto-generated method stub

	}
}
