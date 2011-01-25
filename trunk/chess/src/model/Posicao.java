package model;

public class Posicao {

	private int x;
	private int y;

	public Posicao(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		Posicao p = (Posicao)obj;
		return (p.getX() == x && p.getY()==y);
	}
	
	@Override
	public String toString() {
		return "Linha: "+x+" Coluna: "+y;
	}
}
