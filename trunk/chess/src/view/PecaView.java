package view;

import javax.swing.JPanel;

import model.Peca;

public class PecaView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Peca peca;

	
	public PecaView(Peca peca) {
		this.peca = peca;
	}
	
	public Peca getPeca() {
		return peca;
	}
}
