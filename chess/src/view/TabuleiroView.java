package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import view.renders.ItemRendererTabuleiro;

import model.Bispo;
import model.Cavalo;
import model.CorPeca;
import model.Dama;
import model.Peao;
import model.Peca;
import model.Rei;
import model.Tabuleiro;
import model.Torre;
import model.interfaces.ListenerPeca;
import control.Controle;

public class TabuleiroView extends JPanel implements ListenerPeca {

	private static final long serialVersionUID = 1L;
	private JTable tabelaTabuleiro = null;
	private Tabuleiro tabuleiro = null;
	private Controle controle;
	private static int larguraCasa = 55;
	private static int alturaCasa = 55;

	public TabuleiroView(Tabuleiro tabuleiro) {
		super();

		this.tabuleiro = tabuleiro;
		this.tabelaTabuleiro = new JTable(tabuleiro) {
			public Component prepareRenderer(TableCellRenderer renderer,
					int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}

			public void paint(Graphics g) {
				System.out.println(getClass().getResource(
						"/images/Tabuleiro.JPG"));
				ImageIcon image = new ImageIcon(getClass().getResource(
						"/images/Tabuleiro.JPG"));
				Dimension d = getSize();
				for (int x = 0; x < d.width; x += image.getIconWidth()) {
					for (int y = 0; y < d.height; y += image.getIconHeight()) {
						g.drawImage(image.getImage(), x, y, null, null);
						System.out.println("ff");
					}
				}
				super.paint(g);
			}
		};
		tabelaTabuleiro.setOpaque(false);
		tabelaTabuleiro.setDefaultRenderer(Object.class,
				new ItemRendererTabuleiro(tabuleiro));
		tabuleiro.fireTableDataChanged();
		this.tabelaTabuleiro.setRowHeight(alturaCasa);
		tabelaTabuleiro.getColumnModel().getColumn(0).setMinWidth(larguraCasa);
		tabelaTabuleiro.getColumnModel().getColumn(1).setPreferredWidth(
				larguraCasa);
		tabelaTabuleiro.getColumnModel().getColumn(2).setPreferredWidth(
				larguraCasa);
		tabelaTabuleiro.getColumnModel().getColumn(3).setPreferredWidth(
				larguraCasa);
		tabelaTabuleiro.getColumnModel().getColumn(4).setPreferredWidth(
				larguraCasa);
		tabelaTabuleiro.getColumnModel().getColumn(5).setPreferredWidth(
				larguraCasa);
		tabelaTabuleiro.getColumnModel().getColumn(6).setPreferredWidth(
				larguraCasa);
		tabelaTabuleiro.getColumnModel().getColumn(7).setPreferredWidth(
				larguraCasa);
		iniciar();
	}

	public void iniciar() {
		ArrayList<ListenerPeca> listenerPecas = new ArrayList<ListenerPeca>();
		listenerPecas.add(this);
		listenerPecas.add(PecasCapturadasTableModel.getInstance());
		// Adiciona peças brancas
		this.addPeca(new Peao(6, 0, CorPeca.Branca, listenerPecas));
		this.addPeca(new Peao(6, 1, CorPeca.Branca, listenerPecas));
		this.addPeca(new Peao(6, 2, CorPeca.Branca, listenerPecas));
		this.addPeca(new Peao(6, 3, CorPeca.Branca, listenerPecas));
		this.addPeca(new Peao(6, 4, CorPeca.Branca, listenerPecas));
		this.addPeca(new Peao(6, 5, CorPeca.Branca, listenerPecas));
		this.addPeca(new Peao(6, 6, CorPeca.Branca, listenerPecas));
		this.addPeca(new Peao(6, 7, CorPeca.Branca, listenerPecas));
		this.addPeca(new Torre(7, 0, CorPeca.Branca, listenerPecas));
		this.addPeca(new Torre(7, 7, CorPeca.Branca, listenerPecas));
		this.addPeca(new Cavalo(7, 1, CorPeca.Branca, listenerPecas));
		this.addPeca(new Cavalo(7, 6, CorPeca.Branca, listenerPecas));
		this.addPeca(new Bispo(7, 2, CorPeca.Branca, listenerPecas));
		this.addPeca(new Bispo(7, 5, CorPeca.Branca, listenerPecas));
		this.addPeca(new Dama(7, 3, CorPeca.Branca, listenerPecas));
		this.addPeca(new Rei(7, 4, CorPeca.Branca, listenerPecas));

		// Adiciona peï¿½as pretas
		this.addPeca(new Peao(1, 0, CorPeca.Preta, listenerPecas));
		this.addPeca(new Peao(1, 1, CorPeca.Preta, listenerPecas));
		this.addPeca(new Peao(1, 2, CorPeca.Preta, listenerPecas));
		this.addPeca(new Peao(1, 3, CorPeca.Preta, listenerPecas));
		this.addPeca(new Peao(1, 4, CorPeca.Preta, listenerPecas));
		this.addPeca(new Peao(1, 5, CorPeca.Preta, listenerPecas));
		this.addPeca(new Peao(1, 6, CorPeca.Preta, listenerPecas));
		this.addPeca(new Peao(1, 7, CorPeca.Preta, listenerPecas));
		this.addPeca(new Torre(0, 0, CorPeca.Preta, listenerPecas));
		this.addPeca(new Torre(0, 7, CorPeca.Preta, listenerPecas));
		this.addPeca(new Cavalo(0, 1, CorPeca.Preta, listenerPecas));
		this.addPeca(new Cavalo(0, 6, CorPeca.Preta, listenerPecas));
		this.addPeca(new Bispo(0, 2, CorPeca.Preta, listenerPecas));
		this.addPeca(new Bispo(0, 5, CorPeca.Preta, listenerPecas));
		this.addPeca(new Dama(0, 3, CorPeca.Preta, listenerPecas));
		this.addPeca(new Rei(0, 4, CorPeca.Preta, listenerPecas));

		tabelaTabuleiro.setCellSelectionEnabled(true);
		tabelaTabuleiro.setRowSelectionAllowed(false);
		tabelaTabuleiro.setColumnSelectionAllowed(false);
		tabelaTabuleiro.getColumnModel().getColumn(0).setPreferredWidth(45);
		tabelaTabuleiro.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					try {

						controle.subJogar(e, tabelaTabuleiro.getSelectedRow(),
								tabelaTabuleiro.getSelectedColumn());

					} catch (Exception ex) {
						atualizarDados();
						JOptionPane.showMessageDialog(null,
								"Lance Impossivel - Verifique a mensagem!");
					}

				} else {
					// JOptionPane.showMessageDialog(null,"Mouse clicked !=1");
				}
			}

			private void atualizarDados() {
				// TODO Auto-generated method stub

			}
		});

		tabelaTabuleiro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.add(tabelaTabuleiro);

	}

	@Override
	public void alterouPosicao(Peca peca) {
		this.tabelaTabuleiro.setValueAt(null, peca.getxOld(), peca.getyOld());
		this.tabelaTabuleiro.setValueAt(peca, peca.getX(), peca.getY());
	}

	@Override
	public void foiCapturada(Peca peca) {
		this.tabelaTabuleiro.setValueAt(null, peca.getX(), peca.getY());
	}

	public void addPeca(Peca peca) {
		this.tabuleiro.setValueAt(peca, peca.getX(), peca.getY());
	}

	public void setControle(Controle controle) {
		this.controle = controle;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

}
