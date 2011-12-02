package model.interfaces;

import model.Peca;

public interface IPeaceAction {

	public void movimentar(int xDest, int yDest);

	public void capturar(Peca alvo);
}
