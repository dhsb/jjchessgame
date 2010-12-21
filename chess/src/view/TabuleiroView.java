package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import model.Bispo;
import model.Cavalo;
import model.CorPeca;
import model.ListenerPeca;
import model.Peao;
import model.Peca;
import model.Tabuleiro;
import model.Torre;
import control.Controle;
import control.ItemRenderer;

public class TabuleiroView extends JPanel implements ListenerPeca{

	private static final long serialVersionUID = 1L;
	private JTable tabelaTabuleiro = null;
	private Tabuleiro tabuleiro= null;
	private Controle controle;
	private static int larguraCasa = 55;
	private static int alturaCasa = 60;
	public TabuleiroView(Tabuleiro tabuleiro) {
		super();
		
		this.tabuleiro = tabuleiro;
		this.tabelaTabuleiro = new JTable(tabuleiro);
		tabelaTabuleiro.setDefaultRenderer(Object.class, new ItemRenderer(tabuleiro));
		
		tabuleiro.fireTableDataChanged();
		this.tabelaTabuleiro.setRowHeight(alturaCasa);
		tabelaTabuleiro.getColumnModel().getColumn(0).setMinWidth(larguraCasa);
		tabelaTabuleiro.getColumnModel().getColumn(1).setPreferredWidth(larguraCasa);
		tabelaTabuleiro.getColumnModel().getColumn(2).setPreferredWidth(larguraCasa);
		tabelaTabuleiro.getColumnModel().getColumn(3).setPreferredWidth(larguraCasa);
		tabelaTabuleiro.getColumnModel().getColumn(4).setPreferredWidth(larguraCasa);
		tabelaTabuleiro.getColumnModel().getColumn(5).setPreferredWidth(larguraCasa);
		tabelaTabuleiro.getColumnModel().getColumn(6).setPreferredWidth(larguraCasa);
		tabelaTabuleiro.getColumnModel().getColumn(7).setPreferredWidth(larguraCasa);
		iniciar();
	}
	
	
	public void iniciar(){
		//Adiciona peças brancas
		this.addPeca(new Peao(6, 0, CorPeca.Branca, this));
		this.addPeca(new Peao(6, 1, CorPeca.Branca, this));
		this.addPeca(new Peao(6, 2, CorPeca.Branca, this));
		this.addPeca(new Peao(6, 3, CorPeca.Branca, this));
		this.addPeca(new Peao(6, 4, CorPeca.Branca, this));
		this.addPeca(new Peao(6, 5, CorPeca.Branca, this));
		this.addPeca(new Peao(6, 6, CorPeca.Branca, this));
		this.addPeca(new Peao(6, 7, CorPeca.Branca, this));
		this.addPeca(new Torre(7, 0, CorPeca.Branca, this));
		this.addPeca(new Torre(7, 7, CorPeca.Branca, this));
		this.addPeca(new Cavalo(7, 1, CorPeca.Branca, this));
		this.addPeca(new Cavalo(7, 6, CorPeca.Branca, this));
		this.addPeca(new Bispo(7, 2, CorPeca.Branca, this));
		this.addPeca(new Bispo(7, 5, CorPeca.Branca, this));
		
		//Adiciona peças pretas
		this.addPeca(new Peao(1, 0, CorPeca.Preta, this));
		this.addPeca(new Peao(1, 1, CorPeca.Preta, this));
		this.addPeca(new Peao(1, 2, CorPeca.Preta, this));
		this.addPeca(new Peao(1, 3, CorPeca.Preta, this));
		this.addPeca(new Peao(1, 4, CorPeca.Preta, this));
		this.addPeca(new Peao(1, 5, CorPeca.Preta, this));
		this.addPeca(new Peao(1, 6, CorPeca.Preta, this));
		this.addPeca(new Peao(1, 7, CorPeca.Preta, this));
		this.addPeca(new Torre(0, 0, CorPeca.Preta, this));
		this.addPeca(new Torre(0, 7, CorPeca.Preta, this));
		this.addPeca(new Cavalo(0, 1, CorPeca.Preta, this));
		this.addPeca(new Cavalo(0, 6, CorPeca.Preta, this));
		this.addPeca(new Bispo(0, 2, CorPeca.Preta, this));
		this.addPeca(new Bispo(0, 5, CorPeca.Preta, this));

		
        tabelaTabuleiro.setCellSelectionEnabled(true);
        tabelaTabuleiro.setRowSelectionAllowed(false);
        tabelaTabuleiro.setColumnSelectionAllowed(false);
        tabelaTabuleiro.getColumnModel().getColumn(0).setPreferredWidth(45); 
        tabelaTabuleiro.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    try {
                    	
                        controle.subJogar(e,tabelaTabuleiro.getSelectedRow(), tabelaTabuleiro.getSelectedColumn());
                        

                    } catch (Exception ex) {
                        atualizarDados();
                        JOptionPane.showMessageDialog(null, "Lance Impossivel - Verifique a mensagem!");
                    }


                } else {
                	JOptionPane.showMessageDialog(null,"Mouse clicked !=1");
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

	public void addPeca(Peca peca){
		this.tabuleiro.setValueAt(peca, peca.getX(), peca.getY());
	}
	public void setControle(Controle controle) {
		this.controle = controle;
	}
	
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
}


