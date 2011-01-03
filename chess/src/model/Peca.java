package model;

import javax.swing.ImageIcon;

import model.interfaces.AcaoPecaInterface;
import model.interfaces.ListenerPeca;

public abstract class Peca implements AcaoPecaInterface{

	protected int x;
	protected int y;
	protected int xOld;
	protected int yOld;
	protected CorPeca cor;
	protected ListenerPeca listener;
	protected ImageIcon imagem = null;

	public Peca(int x, int y, CorPeca cor, ListenerPeca listener) {
		this.x = x;
		this.y = y;
		this.cor = cor;
		this.listener = listener;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public CorPeca getCor() {
		return cor;
	}

	public int getxOld() {
		return xOld;
	}

	public void setxOld(int xOld) {
		this.xOld = xOld;
	}

	public int getyOld() {
		return yOld;
	}

	public void setyOld(int yOld) {
		this.yOld = yOld;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setCor(CorPeca cor) {
		this.cor = cor;
	}

	public ImageIcon getImagem() {
		return imagem;
	}
	
	public Peca capturar(Peca peca) throws IllegalArgumentException{
		listener.foiCapturada(peca);
		movimentar(peca.getX(), peca.getY());
		return peca;
	}
	
}
