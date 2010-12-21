package model;

import javax.swing.ImageIcon;

public class Peao extends Peca implements AcaoPecaInterface{

	private boolean movimentado = false;
	public Peao(int linha,int coluna,CorPeca cor,ListenerPeca listener) {
		super(linha, coluna,cor,listener);
		this.imagem = new ImageIcon("Peao"+this.cor.toString()+".jpg");
	}
	
	
	@Override
	public void movimentar(int linhaDest, int colunaDest) {
		// TODO Auto-generated method stub
		
			this.xOld = linha;
			this.yOld = coluna;
			this.linha = linhaDest;
			this.coluna = colunaDest;
			movimentado = true;
			this.listener.alterouPosicao(this);
	}

	@Override
	public boolean verificaDest(int linhaDest, int colunaDest) {
		// TODO Auto-generated method stub
		System.out.println(linha+" "+coluna);
		int xDif = linhaDest - linha;
		int yDif = colunaDest - coluna;
		if(xDif<0)
			xDif = xDif *(-1);
		if(yDif<0)
			yDif = yDif *(-1);
		if(yDif > 0)
			return false;
		
		if((!movimentado && xDif > 2)||(movimentado && xDif > 1))
			return false;
		return true;
	}


	@Override
	public Peca capturar(Peca peca) {
		return peca;
	//	if(this.cor.equals(peca.getCor()))
			
	}
	
}
