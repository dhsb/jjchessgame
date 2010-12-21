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
		if(verificaDest(xDest, yDest)){
			this.x = xDest;
			this.y = yDest;
			this.listener.alterouPosicao(this);
		}
	}

	@Override
	public boolean verificaDest(int xDest, int yDest) {
		
		return false;
	}
	@Override
	public Peca capturar(Peca peca) {
		return peca;
		// TODO Auto-generated method stub
		
	}
}
