package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.ScrollPaneLayout;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.text.LayoutQueue;

import view.renders.ItemRendererRemovidas;
import view.renders.ItemRendererTabuleiro;

import model.Tabuleiro;
import control.Controle;

public class Tela extends Frame {

	private static final long serialVersionUID = 1L;
	private JPanel panelFundo;
	private JPanel panelMesas;
	private JPanel panelPropriedades;
	private JScrollPane scrollFundoMesas;
	private JScrollPane scrollFundoPropriedades;
	private JScrollPane scrollFundo;
	private JTable tabelaCapturadas1;
	private JTable tabelaCapturadas2;
	public static String TITLE = "JJChessGame";
	public static String TITLE_TABLE_PCS_FORA1 = "Peças Fora - Mesa 1";
	public static String TITLE_TABLE_PCS_FORA2 = "Peças Fora - Mesa 2";
	public static String TITLE_MESA1 = "Mesa 1";
	public static String TITLE_MESA2 = "Mesa 2";
	public Tela() {
		this.setTitle(TITLE);
		// this.setBounds(1024, 768, 800, 500);

		init();
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		setExtendedState(MAXIMIZED_BOTH);
	}

	private void init() {
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				
			}
		});
		this.setLayout(new FlowLayout());
		setMenuBar(getBarraMenu());
		panelMesas = new JPanel(new GridBagLayout());
		
		
		tabelaCapturadas1 = new JTable(PecasCapturadasTableModel.getInstance1());
		tabelaCapturadas1.setRowHeight(55);
		tabelaCapturadas1.getColumnModel().getColumn(0).setMaxWidth(60);
		tabelaCapturadas1.getColumnModel().getColumn(1).setMaxWidth(60);

		tabelaCapturadas1.setDefaultRenderer(Object.class, new ItemRendererRemovidas(
				PecasCapturadasTableModel.getInstance1()));
		tabelaCapturadas1.setMaximumSize(new Dimension(120, 500));

		
		
		
		JScrollPane scrollPecasCapturadas1 = new JScrollPane(tabelaCapturadas1);
		scrollPecasCapturadas1.setBorder(BorderFactory.createTitledBorder(TITLE_TABLE_PCS_FORA1));
		scrollPecasCapturadas1.setPreferredSize(new Dimension(140, 500));
		scrollPecasCapturadas1
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelMesas.add(scrollPecasCapturadas1);
		
		// panel.setSize(1100, 600);
		TabuleiroView tabuleiro1 = new TabuleiroView(Tabuleiro.getInstance1());
		TabuleiroView tabuleiro2 = new TabuleiroView(Tabuleiro.getInstance2());
		tabuleiro1.setBorder(BorderFactory.createTitledBorder(TITLE_MESA1));
		tabuleiro2.setBorder(BorderFactory.createTitledBorder(TITLE_MESA2));
		tabuleiro1.setSize(600, 550);
		panelMesas.add(tabuleiro1);
		panelMesas.add(tabuleiro2);

		Controle controle = new Controle(tabuleiro1.getTabuleiro(), null);
		tabuleiro1.setControle(controle);

		

		tabelaCapturadas2 = new JTable(PecasCapturadasTableModel.getInstance2());
		tabelaCapturadas2.setRowHeight(55);
		tabelaCapturadas2.getColumnModel().getColumn(0).setMaxWidth(60);
		tabelaCapturadas2.getColumnModel().getColumn(1).setMaxWidth(60);

		tabelaCapturadas2.setDefaultRenderer(Object.class, new ItemRendererRemovidas(
				PecasCapturadasTableModel.getInstance1()));
		tabelaCapturadas2.setMaximumSize(new Dimension(120, 500));
		
		JScrollPane scrollPecasCapturadas2 = new JScrollPane(tabelaCapturadas2);
		scrollPecasCapturadas2.setBorder(BorderFactory.createTitledBorder(TITLE_TABLE_PCS_FORA2));
		scrollPecasCapturadas2.setPreferredSize(new Dimension(140, 500));
		scrollPecasCapturadas2
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelMesas.add(scrollPecasCapturadas2);
		
		scrollFundoMesas = new JScrollPane(panelMesas);
		//scrollFundoMesas.setViewportView(panelMesas);
		
		panelPropriedades = new JPanel();
		scrollFundoPropriedades = new JScrollPane(panelPropriedades);
		
		panelFundo = new JPanel(new GridLayout(2, 1));
		panelFundo.add(scrollFundoMesas);
		panelFundo.add(scrollFundoPropriedades);
		
		scrollFundo = new JScrollPane(panelFundo);
		add(scrollFundo);
		pack();
	}

	public MenuBar getBarraMenu() {
		MenuBar barraMenu = new MenuBar();
		Menu menuArquivo = new Menu("File");
		MenuItem itemSave = new MenuItem("Save");

		MenuItem itemLoad = new MenuItem("Open");
		
		MenuItem itemExit = new MenuItem("Exit");

		MenuItem itemAbout = new MenuItem("about");
		itemLoad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				about();
			}
		});

		itemSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// diretorioSalvar();
			}
		});

		itemAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				about();
			}
		});
		
		itemExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		barraMenu.add(menuArquivo);
		//menuArquivo.add(itemLoad);
		//menuArquivo.add(itemSalvar);
		menuArquivo.add(itemExit);
		menuArquivo.add(itemAbout);
		return barraMenu;
		
	}

	public static void main(String[] args) throws IOException,
			InterruptedException {
		Tela tela = new Tela();
		tela.setVisible(true);
	}

	private void about() {
		JOptionPane equipe = new JOptionPane("About JJChessGame");
		equipe.showMessageDialog(this,
				"JJChessGame\n\nDeselvolvido por Jean Victor Zunino\n"
						+ "Protï¿½tipo de jogo de xadrez.", "Equipe",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
