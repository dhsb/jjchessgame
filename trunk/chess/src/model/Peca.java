package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import model.interfaces.IPeaceAction;
import model.interfaces.ListenerPeca;

public abstract class Peca implements IPeaceAction, Cloneable {

	protected int x;
	protected int y;
	protected int xOld;
	protected int yOld;
	protected CorPeca cor;
	protected List<ListenerPeca> listeners;
	protected ImageIcon imagem = null;

	public Peca(int x, int y, CorPeca cor, List<ListenerPeca> listeners) {
		this.x = x;
		this.y = y;
		this.cor = cor;
		this.listeners = listeners;
		this.imagem = new ImageIcon(getClass().getResource(
				"/images/" + this.getClass().getSimpleName()
						+ this.cor.toString() + ".jpg"));
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

	public void capturar(Peca peca) throws IllegalArgumentException {

		for (ListenerPeca listener : listeners) {
			listener.foiCapturada(peca);
		}
		movimentar(peca.getX(), peca.getY());
	}

	public boolean isCheckOponente(Peca[][] pecas) {
		System.out.println("Verificando check"
				+ this.getClass().getSimpleName() + x + y);
		ArrayList<Posicao> posicoes = getPosicoesAtacadas(pecas);
		Peca peca = null;
		if (posicoes == null)
			return false;
		for (Posicao p : posicoes) {
			peca = pecas[p.getX()][p.getY()];
			if (peca != null && peca.getClass() == Rei.class
					&& cor != peca.getCor())
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() +" Cor "+ CorPeca.getDescription(cor) + " Linha:" + x + " Coluna:" + y;
	}

	/**
	 * Retorna as posições atacadas. Todas as Posições que estão vazias ou
	 * ocupadas por uma peça inimiga
	 * 
	 * @param pecas
	 *            o Tabuleiro
	 * @return As posições atacadas
	 */
	public abstract ArrayList<Posicao> getPosicoesAtacadas(Peca[][] pecas);

	/**
	 * Retorna as posições Defendidas. Todas as Posições que estão ocupadas por
	 * uma peça da mesma cor
	 * 
	 * @param pecas
	 *            o Tabuleiro
	 * @return As posições atacadas
	 */
	public abstract ArrayList<Posicao> getPosicoesDefendidas(Peca[][] pecas);
}
