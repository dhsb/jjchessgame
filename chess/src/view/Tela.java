package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import view.renders.ItemRendererRemovidas;
import view.renders.ItemRendererTabuleiro;

import model.Tabuleiro;
import control.Controle;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private ScrollPane scrollFundo;
	private JTable tabela;

	public Tela() {
		this.setTitle("JJChessGame -By Jean Victor Zunino");
		//this.setBounds(1024, 768, 800, 500);
		
		init();
		setSize(1024, 750);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		
	}

	private void init() {
		Container c = getContentPane();
		

		panel = new JPanel(new GridLayout(1,2,20,20));
		//panel.setSize(1100, 600);
		TabuleiroView tabuleiro1 = new TabuleiroView(new Tabuleiro(8, 8));
		tabuleiro1.setSize(600, 550);
		panel.add(tabuleiro1);

		Controle controle = new Controle(tabuleiro1.getTabuleiro(), null);
		tabuleiro1.setControle(controle);
		
		tabela = new JTable(PecasCapturadasTableModel.getInstance());
		tabela.setRowHeight(55);
		tabela.getColumnModel().getColumn(0).setMaxWidth(50);
		tabela.getColumnModel().getColumn(1).setMaxWidth(50);
		
		tabela.setDefaultRenderer(Object.class, new ItemRendererRemovidas(PecasCapturadasTableModel.getInstance()));
		tabela.setMaximumSize(new Dimension(60, 500));
		
		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setBorder(BorderFactory.createTitledBorder("Peças Capturadas"));
		scroll.setPreferredSize(new Dimension(60, 500));
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scroll);
		
		scrollFundo = new ScrollPane();
		scrollFundo.add(panel);
		scrollFundo.setPreferredSize(new Dimension(1000, 600));
		c.add(scrollFundo);
		pack();
	}

	public static void main(String[] args) throws IOException,
			InterruptedException {
		Tela tela = new Tela();
		tela.setVisible(true);
	}

}
