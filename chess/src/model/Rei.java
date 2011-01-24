package model;

import java.util.List;

import javax.swing.ImageIcon;

import model.interfaces.AcaoPecaInterface;
import model.interfaces.ListenerPeca;

public class Rei extends Peca implements AcaoPecaInterface {

	private Boolean movimentado = false;

	public Rei(int x, int y, CorPeca cor,  List<ListenerPeca> listeners) {
		super(x, y, cor, listeners);
	}

	@Override
	public void movimentar(int xDest, int yDest) {
		this.xOld = x;
		this.yOld = y;
		this.x = xDest;
		this.y = yDest;
		movimentado = true;
		for(ListenerPeca listener:listeners){
			listener.alterouPosicao(this);
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
		else if (xDif == 0 && yDif == 1) // 
			return true;
		return false;
	}

	@Override
	public Peca capturar(Peca peca) {
		return super.capturar(peca);
	}

	public Boolean getMovimentado() {
		return movimentado;
	}

	@Override
	public boolean isCheckOponente(Peca[][] pecas) {
		return false;
	}

}
