package control;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Peca;
import model.Tabuleiro;

public class Controle {
	private Peca pecaSelecionada1 = null;
	private Peca pecaSelecionada2 = null;
	private Tabuleiro tabuleiro = null;

	public Controle(Tabuleiro tabuleiro1, Tabuleiro tabuleiro2) {
		//this.tabuleiro1 = tabuleiro1;
		//this.tabuleiro2 = tabuleiro2;
		// TODO Auto-generated constructor stub
	}

	public void subJogar(MouseEvent evento, int selectedRow, int selectedColumn) {
		try {
			jogar(evento, selectedRow, selectedColumn);
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
			pecaSelecionada1 = null;
			pecaSelecionada2 = null;
		}

	}

	private boolean jogar(MouseEvent e, int linha, int coluna) throws Exception {
		try {
			JTable tabela = (JTable) e.getSource();
			tabuleiro = (Tabuleiro) tabela.getModel();
			if (pecaSelecionada1 == null && pecaSelecionada2 == null) {
				pecaSelecionada1 = tabuleiro.getPeca(linha, coluna);
				if (pecaSelecionada1 != null)
					if (!pecaSelecionada1.getCor().equals(tabuleiro.getJogadorVez())) {
						throw new IllegalArgumentException("Não é sua vez");
					}
			} else {
				pecaSelecionada2 = tabuleiro.getPeca(linha, coluna);
				if (pecaSelecionada2 != null)
					if (pecaSelecionada2.getCor().equals(
							pecaSelecionada1.getCor())) {
						pecaSelecionada1 = pecaSelecionada2;
						pecaSelecionada2 = null;
						return false;
					}
				if (pecaSelecionada1.verificaDest(linha, coluna)) {
					if (pecaSelecionada2 == null)
						pecaSelecionada1.movimentar(linha, coluna);
					else
						pecaSelecionada1.capturar(pecaSelecionada2);
					tabuleiro.passaVez();
					pecaSelecionada1 = null;
					pecaSelecionada2 = null;
					return true;
				} else {
					throw new IllegalArgumentException("Movimento inválido");
				}
			}
			return false;
		} catch (Exception ex) {
			throw new IllegalArgumentException(ex.getMessage());
		}
	}

	

}
