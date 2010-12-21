package model;

import javax.swing.ImageIcon;

public class Bispo extends Peca implements AcaoPecaInterface {

	public Bispo(int x, int y, CorPeca cor, ListenerPeca listener) {
		super(x, y, cor, listener);
		this.imagem = new ImageIcon("Bispo"+this.cor.toString()+".jpg");
	}

	@Override
	public void movimentar(int xDest, int yDest) {
		if (verificaDest(xDest, yDest)) {
			this.linha = xDest;
			this.coluna = yDest;
			System.out.println("movimentou");
			// this.listener.alterouPosicao(this);
		} else
			System.out.println("não movimentou");
	}

	@Override
	public boolean verificaDest(int xDest, int yDest) {
		int testeX = xDest - linha; // modulo
		int testeY = yDest - coluna; // modulo
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
