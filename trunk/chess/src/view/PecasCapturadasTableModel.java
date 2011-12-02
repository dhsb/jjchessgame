package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import model.CorPeca;
import model.Peca;
import model.interfaces.ListenerPeca;

public class PecasCapturadasTableModel extends AbstractTableModel implements
		ListenerPeca, Cloneable {

	private ArrayList<Peca> pecasBrancasCapturadas;
	private ArrayList<Peca> pecasPretasCapturadas;
	private static Integer COLUNA_BRANCA = 0;
	private static Integer COLUNA_PRETA = 1;
	private static PecasCapturadasTableModel pcCapTableModel1;
	private static PecasCapturadasTableModel pcCapTableModel2;

	public PecasCapturadasTableModel() {
		super();
		pecasBrancasCapturadas = new ArrayList<Peca>();
		pecasPretasCapturadas = new ArrayList<Peca>();
	}

	public static PecasCapturadasTableModel getInstance1() {
		if (pcCapTableModel1 == null) {
			pcCapTableModel1 = new PecasCapturadasTableModel();
		}
		return pcCapTableModel1;
	}

	public static PecasCapturadasTableModel getInstance2() {
		if (pcCapTableModel2 == null) {
			pcCapTableModel2 = new PecasCapturadasTableModel();
		}
		return pcCapTableModel2;
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

	public ArrayList<Peca> getPecasBrancasCapturadas() {
		return pecasBrancasCapturadas;
	}

	public ArrayList<Peca> getPecasPretasCapturadas() {
		return pecasPretasCapturadas;
	}

	public void setPecasCapturadas(
			ArrayList<Peca> pecasBrancasCapturadas,
			ArrayList<Peca> pecasPretasCapturadas) {
		this.pecasBrancasCapturadas = pecasBrancasCapturadas;
		this.pecasPretasCapturadas = pecasPretasCapturadas;
		fireTableDataChanged();
	}

}
