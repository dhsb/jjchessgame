package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.CorPeca;
import model.Peca;
import model.interfaces.ListenerPeca;

public class PecasCapturadasTableModel extends AbstractTableModel implements
		ListenerPeca {

	private ArrayList<Peca> pecasBrancasCapturadas;
	private ArrayList<Peca> pecasPretasCapturadas;
	private static Integer COLUNA_BRANCA = 0;
	private static Integer COLUNA_PRETA = 1;
	private static PecasCapturadasTableModel pcCapTableModel;

	public PecasCapturadasTableModel() {
		super();
		pecasBrancasCapturadas = new ArrayList<Peca>();
		pecasPretasCapturadas = new ArrayList<Peca>();
	}

	public static PecasCapturadasTableModel getInstance() {
		if (pcCapTableModel == null) {
			pcCapTableModel = new PecasCapturadasTableModel();
		}
		return pcCapTableModel;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return 16;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Brancas";
		case 1:
			return "Pretas";
		default:
			return "";
		}
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		if (coluna == COLUNA_BRANCA) {
			if (pecasBrancasCapturadas.size() > linha)
				return pecasBrancasCapturadas.get(linha);
			else
				return null;
		} else {
			if (pecasPretasCapturadas.size() > linha)
				return pecasPretasCapturadas.get(linha);
			else
				return null;
		}
	}

	@Override
	public void alterouPosicao(Peca peca) {

	}

	@Override
	public void foiCapturada(Peca peca) {
		if (peca.getCor().equals(CorPeca.Branca)) {
			pecasBrancasCapturadas.add(peca);
		} else {
			pecasPretasCapturadas.add(peca);
		}
		fireTableDataChanged();
	}
	
	
}
