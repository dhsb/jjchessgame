/*
 * PecaRenderer.java
 *
 * Created on 9 de Outubro de 2008, 02:19
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package view.renders;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import view.PecasCapturadasTableModel;

import model.Peca;
import model.Tabuleiro;

/**
 * 
 * @author Jean Victor Zunino
 */
@SuppressWarnings("serial")
public class ItemRendererRemovidas extends DefaultTableCellRenderer {
	private PecasCapturadasTableModel modelo;
	public ItemRendererRemovidas(PecasCapturadasTableModel modelo) {
		this.modelo = modelo;
	}

	public Component getTableCellRendererComponent(JTable tabela, Object value,
			boolean isSelected, boolean hasFocus, int linha, int coluna) {

		Peca p =(Peca)modelo.getValueAt(linha, coluna);
		if (p != null) {
			this.setIcon(p.getImagem());

		} else {
			this.setIcon(null);
		}
		Component cell = super.getTableCellRendererComponent(tabela, value,
				isSelected, hasFocus, linha, coluna);
		if (value instanceof Integer) {
			Integer amount = (Integer) value;
			if (amount.intValue() < 0) {
				cell.setBackground(Color.red);
				// You can also customize the Font and Foreground this way
				// cell.setForeground();
				// cell.setFont();
			} else {
				cell.setBackground(Color.white);
			}
		}
		return this;

	}

}
