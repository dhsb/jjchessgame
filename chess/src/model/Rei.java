package model;

public class Rei extends Peca implements AcaoPecaInterface{

	public Rei(int x, int y,CorPeca cor,ListenerPeca listener) {
		super(x, y,cor,listener);
		// TODO Auto-generated constructor stub
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
