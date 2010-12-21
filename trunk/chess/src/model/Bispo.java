package model;

import javax.swing.ImageIcon;

import model.interfaces.AcaoPecaInterface;
import model.interfaces.ListenerPeca;

public class Bispo extends Peca implements AcaoPecaInterface {

	public Bispo(int x, int y, CorPeca cor, ListenerPeca listener) {
		super(x, y, cor, listener);
		this.imagem = new ImageIcon("Bispo" + this.cor.toString() + ".jpg");
	}

	@Override
	public void movimentar(int xDest, int yDest) {
		this.xOld = x;
		this.yOld = y;
		this.x = xDest;
		this.y = yDest;
		System.out.println("movimentou");
		this.listener.alterouPosicao(this);
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

	public static void main(String[] args) {
		Bispo b = new Bispo(5, 3, CorPeca.Branca, null);
		b.movimentar(2, 0);
	}

	@Override
	public Peca capturar(Peca peca) {
		return peca;
		// TODO Auto-generated method stub

	}

}
