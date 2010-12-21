package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.ScrollPane;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Tabuleiro;
import control.Controle;



public class Tela extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private ScrollPane scrollFundo;
	

	public Tela() {
		this.setTitle("Chess - Jean Victor Zunino");
		this.setBounds(1024, 768, 800, 500);
		this.setSize(1024, 768);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);

	}

	public static void main(String[] args) throws IOException,
			InterruptedException {
		Tela tela = new Tela();
		Container c = tela.getContentPane();
		c.setLayout(new BorderLayout());
		

		tela.panel = new JPanel(new GridBagLayout());
		tela.panel.setSize(1100, 768);
		TabuleiroView tabuleiro1 = new TabuleiroView(new Tabuleiro(8, 8));
		tabuleiro1.setSize(600, 550);
		TabuleiroView tabuleiro2 = new TabuleiroView(new Tabuleiro(8, 8));
		tela.panel.add(tabuleiro1);
		//tela.panel.add(tabuleiro2);
		
		Controle controle = new Controle(tabuleiro1.getTabuleiro(),tabuleiro2.getTabuleiro());
		tabuleiro1.setControle(controle);
		tabuleiro2.setControle(controle);
		tela.scrollFundo = new ScrollPane();
		tela.scrollFundo.add(tela.panel);
		c.add(tela.scrollFundo);
		tela.setVisible(true);
	}


}
