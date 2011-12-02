package view;

import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Tabuleiro;
import view.renders.ItemRendererRemovidas;
import control.Controle;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new Tela().setVisible(true);
			}
		});
	}

	// /////////////////////////////////////////////////
	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JTable jTable2;
	private javax.swing.JLabel lbEstruturaPeaoBranco;
	private javax.swing.JLabel lbEstruturaPeaoPreto;
	private javax.swing.JLabel lbJogadorVez;
	private javax.swing.JLabel lbScoreAtaqueBranco;
	private javax.swing.JLabel lbScoreAtaquePreto;
	private javax.swing.JLabel lbScoreBranco;
	private javax.swing.JLabel lbScoreCentroBranco;
	private javax.swing.JLabel lbScoreCentroPreto;
	private javax.swing.JLabel lbScoreDefesaBranco;
	private javax.swing.JLabel lbScoreDefesaPreto;
	private javax.swing.JLabel lbScoreMaterialBranco;
	private javax.swing.JLabel lbScoreMaterialPreto;
	private javax.swing.JLabel lbScorePreto;
	private javax.swing.JLabel pcSelecionada;
	private javax.swing.JTable tabelaCapturadas1;
	// /////////////////////////////////////////////////////////////////

	public static String TITLE = "JJChessGame";

	private DecimalFormat df = new DecimalFormat("0.00");

	public Tela() {
		this.setTitle(TITLE);

		initComponents();
		init();
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		setExtendedState(MAXIMIZED_BOTH);
	}

	private void init() {
		setMenuBar(getBarraMenu());
		lbJogadorVez.setText("Brancas Devem Jogar!");
		pcSelecionada.setText("Nenhuma");
		tabelaCapturadas1.setModel(PecasCapturadasTableModel.getInstance1());
		tabelaCapturadas1.setRowHeight(55);
		tabelaCapturadas1.getColumnModel().getColumn(0).setMaxWidth(60);
		tabelaCapturadas1.getColumnModel().getColumn(1).setMaxWidth(60);

		tabelaCapturadas1.setDefaultRenderer(Object.class,
				new ItemRendererRemovidas(PecasCapturadasTableModel
						.getInstance1()));
		tabelaCapturadas1.setMaximumSize(new Dimension(120, 500));
		TabuleiroView tabuleiro1 = new TabuleiroView(Tabuleiro.getInstance1());
		tabuleiro1.setBorder(BorderFactory.createTitledBorder("Mesa"));
		tabuleiro1.setSize(600, 550);

		jScrollPane1.add(tabuleiro1);

		Controle controle = new Controle(tabuleiro1.getTabuleiro());
		controle.setTela(this);
		tabuleiro1.setControle(controle);
		tabuleiro1.setEnabled(false);
		controle.atualizaScore();
	}

	private void initComponents() {

		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		lbScoreBranco = new javax.swing.JLabel();
		lbScorePreto = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jSeparator2 = new javax.swing.JSeparator();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		lbScoreMaterialBranco = new javax.swing.JLabel();
		lbScoreAtaqueBranco = new javax.swing.JLabel();
		lbScoreDefesaBranco = new javax.swing.JLabel();
		lbScoreMaterialPreto = new javax.swing.JLabel();
		lbScoreAtaquePreto = new javax.swing.JLabel();
		lbScoreDefesaPreto = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		lbScoreCentroBranco = new javax.swing.JLabel();
		lbScoreCentroPreto = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		lbEstruturaPeaoBranco = new javax.swing.JLabel();
		lbEstruturaPeaoPreto = new javax.swing.JLabel();
		lbJogadorVez = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		tabelaCapturadas1 = new javax.swing.JTable();
		jScrollPane1 = new javax.swing.JScrollPane();
		pcSelecionada = new javax.swing.JLabel();

		jTable2.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jScrollPane2.setViewportView(jTable2);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1
				.setBorder(javax.swing.BorderFactory
						.createTitledBorder("Score"));

		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel1.setText("Brancas:");

		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel2.setText("Pretas:");

		lbScoreBranco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lbScoreBranco.setText("0");

		lbScorePreto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lbScorePreto.setText("0");

		jLabel5.setText("Material:");

		jLabel6.setText("Ataque:");

		jLabel7.setText("Defesa:");

		jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel8.setText("Score Brancas");

		jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel9.setText("Score Pretas");

		jLabel10.setText("Material:");

		jLabel11.setText("Ataque:");

		jLabel12.setText("Defesa:");

		jLabel3.setText("Controle Centro:");

		jLabel4.setText("Controle Centro:");

		jLabel14.setText("Estrutura Peão:");

		jLabel15.setText("Estrutura Peão:");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jSeparator1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												226, Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(
								jPanel1Layout.createSequentialGroup().addGap(
										67, 67, 67).addComponent(jLabel8,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										101,
										javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(78, Short.MAX_VALUE))
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																jLabel1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(jLabel2))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																lbScorePreto,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																56,
																Short.MAX_VALUE)
														.addComponent(
																lbScoreBranco,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																56,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(132, 132, 132))
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jSeparator2,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												226, Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(20, 20, 20)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel14)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				lbEstruturaPeaoBranco,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				54,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel3)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				lbScoreCentroBranco,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				41,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				87,
																				87,
																				87)
																		.addComponent(
																				jLabel13))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel7)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				lbScoreDefesaBranco,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				51,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel6)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				lbScoreAtaqueBranco,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				51,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel5)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				lbScoreMaterialBranco,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				51,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(90, Short.MAX_VALUE))
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(20, 20, 20)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel15)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				lbEstruturaPeaoPreto,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				55,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel4)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				lbScoreCentroPreto,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				41,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				48,
																				48,
																				48)
																		.addComponent(
																				jLabel9,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				101,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel12)
																						.addComponent(
																								jLabel11)
																						.addComponent(
																								jLabel10))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								lbScoreDefesaPreto,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								51,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGap(
																												1,
																												1,
																												1)
																										.addComponent(
																												lbScoreAtaquePreto,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												51,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								lbScoreMaterialPreto,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								51,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(77, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(6, 6, 6)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(
																lbScoreBranco,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																14,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																lbScorePreto,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																14,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jSeparator1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												10,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel8)
										.addGap(7, 7, 7)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel5)
														.addComponent(
																lbScoreMaterialBranco,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																14,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel6)
														.addComponent(
																lbScoreAtaqueBranco,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																14,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel7)
														.addComponent(
																lbScoreDefesaBranco,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																14,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabel3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																14,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel13)
														.addComponent(
																lbScoreCentroBranco,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																16,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel14)
														.addComponent(
																lbEstruturaPeaoBranco,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																16,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(20, 20, 20)
										.addComponent(
												jSeparator2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												12,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel9)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																lbScoreMaterialPreto,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jLabel10,
																javax.swing.GroupLayout.Alignment.TRAILING))
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel11)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel12))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				lbScoreAtaquePreto,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				14,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				lbScoreDefesaPreto,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				14,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel4)
														.addComponent(
																lbScoreCentroPreto,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																16,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel15)
														.addComponent(
																lbEstruturaPeaoPreto,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																14,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(224, Short.MAX_VALUE)));

		lbJogadorVez.setFont(new java.awt.Font("Tahoma", 1, 11));
		lbJogadorVez.setText("Brancas Jogam");

		jScrollPane3.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Peças Capturadas"));

		tabelaCapturadas1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jScrollPane3.setViewportView(tabelaCapturadas1);

		jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 500));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																		.addGroup(
																				layout
																						.createSequentialGroup()
																						.addContainerGap()
																						.addComponent(
																								lbJogadorVez,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								153,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(
																								182,
																								182,
																								182))
																		.addGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				layout
																						.createSequentialGroup()
																						.addContainerGap()
																						.addComponent(
																								jScrollPane1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								523,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																								6,
																								Short.MAX_VALUE)))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				68,
																				68,
																				68)
																		.addComponent(
																				pcSelecionada,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				362,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
										.addComponent(
												jScrollPane3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												179,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jPanel1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																		.addGroup(
																				layout
																						.createSequentialGroup()
																						.addGap(
																								8,
																								8,
																								8)
																						.addComponent(
																								jScrollPane1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								479,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(
																								30,
																								30,
																								30)
																						.addComponent(
																								lbJogadorVez,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								20,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(
																								18,
																								18,
																								18)
																						.addComponent(
																								pcSelecionada,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								19,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addComponent(
																				jScrollPane3,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				597,
																				Short.MAX_VALUE)))
										.addContainerGap()));

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
		// menuArquivo.add(itemLoad);
		// menuArquivo.add(itemSalvar);
		menuArquivo.add(itemExit);
		menuArquivo.add(itemAbout);
		return barraMenu;
	}

	private void about() {
		JOptionPane equipe = new JOptionPane("About JJChessGame");
		equipe
				.showMessageDialog(
						this,
						"JJChessGame\n\nDeselvolvido por:\n\t\t Jean Victor Zunino\n\t\tMayara Barbieri Silva"
								+ "Links:\n\n\t\t"
								+ "'O XADREZ É O MAIS FORMIDÁVEL JOGO DE PURA HABILIDADE MENTAL JÁ INVENTADO PELA MENTE HUMANA'",
						"JJChessGame", JOptionPane.INFORMATION_MESSAGE);
	}

	public void setTotalScoreBranco(double score) {
		lbScoreBranco.setText(df.format(score));
	}

	public void setTotalScorePreto(double score) {
		lbScorePreto.setText(df.format(score));
	}

	public void setScoreMaterialBranco(double score) {
		lbScoreMaterialBranco.setText(df.format(score));
	}

	public void setScoreMaterialPreto(double score) {
		lbScoreMaterialPreto.setText(df.format(score));
	}

	public void setScoreAtaqueBranco(double score) {
		lbScoreAtaqueBranco.setText(df.format(score));
	}

	public void setScoreAtaquePreto(double score) {
		lbScoreAtaquePreto.setText(df.format(score));
	}

	public void setScoreControleCentroPreto(double score) {
		lbScoreCentroPreto.setText(df.format(score));
	}

	public void setScoreControleCentroBranco(double score) {
		lbScoreCentroBranco.setText(df.format(score));
	}

	public void setScoreDefesaPreto(double score) {
		lbScoreDefesaPreto.setText(df.format(score));
	}

	public void setScoreDefesaBranco(double score) {
		lbScoreDefesaBranco.setText(df.format(score));
	}
	
	public void setScoreEstruturaPeaoBranco(double score) {
		lbEstruturaPeaoBranco.setText(df.format(score));
	}

	public void setScoreEstruturaPeaoPreto(double score) {
		lbEstruturaPeaoPreto.setText(df.format(score));
	}

	public void setJogadorVez(String msg) {
		lbJogadorVez.setText(msg + "s Devem Jogar!");
	}

	public void setPecaSelecionada(String msg) {
		pcSelecionada.setText(msg);
	}

}
