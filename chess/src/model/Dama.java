package model;

import javax.swing.ImageIcon;

import model.interfaces.AcaoPecaInterface;
import model.interfaces.ListenerPeca;

public class Dama extends Peca implements AcaoPecaInterface{

	public Dama(int x, int y,CorPeca cor,ListenerPeca listener) {
		super(x, y,cor,listener);
		this.imagem = new ImageIcon("Dama"+this.cor.toString()+".jpg");
	}

	@Override
	public void movimentar(int xDest, int yDest) {
		this.xOld = x;
		this.yOld = y;
		this.x = xDest;
		this.y = yDest;
		//movimentado = true;
		this.listener.alterouPosicao(this);
	}

	@Override
	public boolean verificaDest(int xDest, int yDest) {
		int xDif = xDest - x;
		int yDif = yDest - y;
		if (xDif < 0)
			xDif = xDif * (-1);
		if (yDif < 0)
			yDif = yDif * (-1);
		if (((xDif == 0) && (yDif != 0)) || ((xDif != 0) && (yDif == 0)))
			return true;
		if (xDif == yDif) {// movimento valido
			return true;
		}
		return false;
	}
	@Override
	public Peca capturar(Peca peca) {
		return super.capturar(peca);
	}
}
