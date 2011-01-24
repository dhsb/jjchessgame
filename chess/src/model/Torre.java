package model;

import java.util.List;

import javax.swing.ImageIcon;

import model.interfaces.AcaoPecaInterface;
import model.interfaces.ListenerPeca;

public class Torre extends Peca implements AcaoPecaInterface {

	//private boolean movimentado = false;

	public Torre(int x, int y, CorPeca cor,  List<ListenerPeca> listeners) {
		super(x, y, cor, listeners);
	}

	@Override
	public void movimentar(int xDest, int yDest) {
		this.xOld = x;
		this.yOld = y;
		this.x = xDest;
		this.y = yDest;
		//movimentado = true;
		for(ListenerPeca listener:listeners){
			listener.alterouPosicao(this);
		}
	}

	@Override
	public boolean verificaDest(int xDest, int yDest) {
		// TODO Auto-generated method stub
		// 0- verifique se (posX != oldX) e (posY != oldY) // evita de mover
		// para casa atual;
		// 1- verifique se posX e posY estao dentro do limite do tabuleiro
		// 2- declare duas variaveis auxiliares X e Y

		// 5- se (((X==0) e (Y!= 0 )) ou ((X!=0) e (Y==0))) // movimento valido
		int xDif = xDest - x;
		int yDif = yDest - y;
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
		return super.capturar(peca);
	}

	@Override
	public boolean isCheckOponente(Peca[][] pecas) {
		return false;
	}


}



