package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import model.interfaces.AcaoPecaInterface;
import model.interfaces.ListenerPeca;

public class Dama extends Peca implements AcaoPecaInterface{

	public Dama(int x, int y,CorPeca cor, List<ListenerPeca> listeners) {
		super(x, y,cor,listeners);
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
		int xDif = xDest - x;
		int yDif = yDest - y;
		if (xDif < 0)
			xDif = xDif * (-1);
		if (yDif < 0)
			yDif = yDif * (-1);
		if (((xDif == 0) && (yDif != 0)) || ((xDif != 0) && (yDif == 0)))
			return true;
		if (xDif == yDif) {// movimento valido
			return true;
		}
		return false;
	}
	@Override
	public Peca capturar(Peca peca) {
		if(verificaDest(peca.getX(), peca.getY()))
			return super.capturar(peca);
		return null;
	}

	@Override
	public ArrayList<Posicao> getPosicoesAtacadas(Peca[][] pecas) {
		int xAux = x+1;
		int yAux = y+1;
		Peca peca = null;
		ArrayList<Posicao> lista = new ArrayList<Posicao>();
		//Movimento na Diagonal
		while (xAux < 8 && yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				yAux = 8;
			else {
				yAux++;
				xAux++;
			}
		}
		
		xAux = x-1;
		yAux = y+1;
		while (xAux >= 0 && yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				yAux = 8;
			else {
				xAux--;
				yAux++;
			}
		}
		xAux = x-1;
		yAux = y-1;
		while (xAux >= 0 && yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				yAux = -1;
			else {
				xAux--;
				yAux--;
			}
		}
		xAux = x+1;
		yAux = y-1;
		while (xAux < 8 && yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				yAux = -1;
			else {
				xAux++;
				yAux--;
			}
		}
		
		//Movimento Horizontal e Vertical
		xAux = x;
		yAux = y+1;
		//Verifica para direita
		while (yAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				yAux = 8;
			else {
				yAux++;
			}
		}
		yAux = y-1;
		//Verifica para esquerda
		while (yAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				yAux = -1;
			else {
				yAux--;
			}
		}
		yAux = y;
		xAux = x +1;
		//Verifica para baixo
		while (xAux < 8) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				xAux = 8;
			else {
				xAux++;
			}
		}
		xAux = x-1;
		//Verifica para cima
		while (xAux >= 0) {
			peca = pecas[xAux][yAux];
			if (peca == null || peca.getCor() != cor) {
				lista.add(new Posicao(xAux, yAux));
			}
			if (peca != null)
				xAux = -1;
			else {
				xAux--;
			}
		}
		return lista;
	}

}
