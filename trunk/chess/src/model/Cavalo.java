package model;

import javax.swing.ImageIcon;

public class Cavalo extends Peca implements AcaoPecaInterface{

	public Cavalo(int x, int y,CorPeca cor,ListenerPeca listener) {
		super(x, y,cor,listener);
		this.imagem = new ImageIcon("Cavalo"+this.cor.toString()+".jpg");
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
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Peca capturar(Peca peca) {
		return peca;
		// TODO Auto-generated method stub
		
	}
}
