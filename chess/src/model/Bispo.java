package model;

import java.util.List;

import javax.swing.ImageIcon;

import model.interfaces.AcaoPecaInterface;
import model.interfaces.ListenerPeca;

public class Bispo extends Peca implements AcaoPecaInterface {

	public Bispo(int x, int y, CorPeca cor,  List<ListenerPeca> listeners) {
		super(x, y, cor, listeners);
	}

	@Override
	public void movimentar(int xDest, int yDest) {
		this.xOld = x;
		this.yOld = y;
		this.x = xDest;
		this.y = yDest;
		System.out.println("movimentou");
		for(ListenerPeca listener:listeners){
			listener.alterouPosicao(this);
		}
	}

	@Override
	public boolean verificaDest(int xDest, int yDest) {
		int testeX = xDest - x; // modulo
		if (testeX < 0)
			testeX = testeX * (-1);
		int testeY = yDest - y; // modulo
		if (testeY < 0)
			testeY = testeY * (-1);
		if (testeX == testeY) {// movimento valido
			return true;
		}

		return false;
	}

	@Override
	public Peca capturar(Peca peca) {
		return super.capturar(peca);
	}

	@Override
	public boolean isCheckOponente(Peca[][] pecas) {
		Peca peca =null;
		if(cor == CorPeca.Branca){
			peca = pecas[x-1][y-1];
			if(peca != null && peca.getClass() == Rei.class && peca.getCor() != CorPeca.Preta){
				return true;
			}
			peca = pecas[x-1][y+1];
			if(peca != null && peca.getClass() == Rei.class && peca.getCor() != CorPeca.Preta){
				return true;
			}
		}else{
			peca = pecas[x+1][y-1];
			if(peca != null && peca.getClass() == Rei.class && peca.getCor() != CorPeca.Branca){
				return true;
			}
			peca = pecas[x+1][y+1];
			if(peca != null && peca.getClass() == Rei.class && peca.getCor() != CorPeca.Branca){
				return true;
			}
		}
		return false;
	}
}
