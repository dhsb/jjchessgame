package model;

import javax.swing.table.AbstractTableModel;

public class Tabuleiro extends AbstractTableModel {

	// X = linha
	// Y = coluna
	private static final long serialVersionUID = 1L;
	private int tamanhoX, tamanhoY;
	private Peca[][] pecas = null;
	private CorPeca jogadorVez = CorPeca.Branca;

	public Tabuleiro(int tamanhoX, int tamanhoY) {
		super();
		this.tamanhoX = tamanhoX;
		this.tamanhoY = tamanhoY;
		pecas = new Peca[tamanhoX][tamanhoY];
	}

	public void setTamanhoY(int tamanhoY) {
		this.tamanhoY = tamanhoY;
	}

	public int getTamanhoY() {
		return tamanhoY;
	}

	public Peca[][] getPecas() {

		return pecas;
	}

	public int getTamanhoX() {
		return tamanhoX;
	}

	public Peca getPeca(int linha, int coluna) {
		return pecas[linha][coluna];
	}

	@Override
	public int getColumnCount() {
		return tamanhoX;
	}

	@Override
	public String getColumnName(int coluna) {
		switch (coluna) {
		case 0:
			return "a";
		case 1:
			return "b";
		case 2:
			return "c";
		case 3:
			return "d";
		case 4:
			return "e";
		case 5:
			return "f";
		case 6:
			return "g";
		case 7:
			return "h";

		default:
			break;
		}
		return null;
	}

	@Override
	public int getRowCount() {
		return tamanhoY;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		return pecas[linha][coluna];
	}

	@Override
	public void setValueAt(Object peca, int linha, int coluna) {
		pecas[linha][coluna] = (Peca) peca;
		System.out.println(pecas + " " + linha + " " + coluna);
	}

	public CorPeca getJogadorVez() {
		return jogadorVez;
	}

	public void passaVez() {
		if (jogadorVez.equals(CorPeca.Branca))
			jogadorVez = CorPeca.Preta;
		else
			jogadorVez = CorPeca.Branca;
		this.fireTableDataChanged();
	}

	/*
	 * Método chamado para verificar se após o movimento continuará em check
	 */
	public void verificarJogadaInvalidaCheck() throws Exception {
		int x = 0;
		int y = 0;
		Peca p = null;
		for (x = 0; x <= 7; x++) {
			for (y = 0; y <= 7; y++) {
				p = pecas[x][y];
				if (p == null)
					continue;
				if (p.getCor() != jogadorVez) {
					if(p.isCheckOponente(pecas)){
						throw new IllegalArgumentException("Jogada Inválida - Você está em Check!");
					}
				}
			}
		}
	}
}
