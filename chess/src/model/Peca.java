package model;

import javax.swing.ImageIcon;

public abstract class Peca implements AcaoPecaInterface{

	protected int linha;
	protected int coluna;
	protected int xOld;
	protected int yOld;
	protected CorPeca cor;
	protected ListenerPeca listener;
	protected ImageIcon imagem = null;

	public Peca(int linha, int coluna, CorPeca cor, ListenerPeca listener) {
		this.linha = linha;
		this.coluna = coluna;
		this.cor = cor;
		this.listener = listener;
	}

	public int getLinha() {
		return linha;
	}

	public int getY() {
		return coluna;
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
		this.linha = x;
	}

	public void setY(int y) {
		this.coluna = y;
	}

	public void setCor(CorPeca cor) {
		this.cor = cor;
	}

	public ImageIcon getImagem() {
		return imagem;
	}
}
