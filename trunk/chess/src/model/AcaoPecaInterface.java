package model;

public interface AcaoPecaInterface {

	public boolean verificaDest(int xDest, int yDest);

	public void movimentar(int xDest, int yDest);
	
	public Peca capturar(Peca peca);
}