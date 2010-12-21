package model;

import javax.swing.ImageIcon;

public class Torre extends Peca implements AcaoPecaInterface {

	private boolean movimentado = false;

	public Torre(int x, int y, CorPeca cor, ListenerPeca listener) {
		super(x, y, cor, listener);
		this.imagem = new ImageIcon("Torre" + this.cor.toString() + ".jpg");
	}

	@Override
	public void movimentar(int xDest, int yDest) {
		this.xOld = linha;
		this.yOld = coluna;
		this.linha = xDest;
		this.coluna = yDest;
		movimentado = true;
		this.listener.alterouPosicao(this);
	}

	@Override
	public boolean verificaDest(int xDest, int yDest) {
		// TODO Auto-generated method stub
		// 0- verifique se (posX != oldX) e (posY != oldY) // evita de mover
		// para casa atual;
		// 1- verifique se posX e posY estao dentro do limite do tabuleiro
		// 2- declare duas variaveis auxiliares X e Y

		// 5- se (((X==0) e (Y!= 0 )) ou ((X!=0) e (Y==0))) // movimento valido
		int xDif = xDest - linha;
		int yDif = yDest - coluna;
		if (xDif < 0)
			xDif = xDif * (-1);
		if (yDif < 0)
			yDif = yDif * (-1);
		if (((xDif == 0) && (yDif != 0)) || ((xDif != 0) && (yDif == 0)))
			return true;
		return false;
	}
	
	@Override
	public Peca capturar(Peca peca) {
		
		return peca;		
	}
}



