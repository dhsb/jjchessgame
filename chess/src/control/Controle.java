package control;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import model.Peca;
import model.Posicao;
import model.Tabuleiro;

public class Controle {

	/*
	 * Quando uma peï¿½a Branca Joga:Verificar se o Rei branco nï¿½o estï¿½ check( Se
	 * tiver Volta jogada e da mensagem )Verificar se o Rei Preto estï¿½ em check(
	 * Da mensagem Check ).
	 */
	private Peca pecaSelecionada1 = null;
	private Peca pecaSelecionada2 = null;
	private Tabuleiro tabuleiro = null;

	public Controle(Tabuleiro tabuleiro1, Tabuleiro tabuleiro2) {
		// this.tabuleiro1 = tabuleiro1;
		// this.tabuleiro2 = tabuleiro2;
		// TODO Auto-generated constructor stub
	}

	public void subJogar(MouseEvent evento, int selectedRow, int selectedColumn) {
		try {
			jogar(evento, selectedRow, selectedColumn);
		} catch (Exception e) {
			System.out.println("e "+e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage());
			pecaSelecionada1 = null;
			pecaSelecionada2 = null;
		}
	}

	private boolean jogar(MouseEvent e, int linha, int coluna) throws Exception {
		try {
			JTable tabela = (JTable) e.getSource();
			tabuleiro = (Tabuleiro) tabela.getModel();
			if (pecaSelecionada1 == null && pecaSelecionada2 == null) {
				// Coloca a peï¿½a selecionada em pecaSelecionada1
				pecaSelecionada1 = tabuleiro.getPeca(linha, coluna);
				if (pecaSelecionada1 != null)
					// Verifica se a peï¿½a selecionada ï¿½ diferente da peï¿½a da vez
					if (!pecaSelecionada1.getCor().equals(
							tabuleiro.getJogadorVez())) {
						throw new IllegalArgumentException("Nï¿½o ï¿½ sua vez");
					}
			} else {
				pecaSelecionada2 = tabuleiro.getPeca(linha, coluna);
				if (pecaSelecionada2 != null) {
					if (pecaSelecionada2.getCor().equals(
							pecaSelecionada1.getCor())) {
						if (pecaSelecionada1 != pecaSelecionada2) {
							// JOptionPane.showMessageDialog(null,"Vocï¿½ deve jogar com a peï¿½a que tocou primeiro!");
						}
						pecaSelecionada2 = null;
						return false;
					} else {
						try {
							Peca pecaCapturada = pecaSelecionada1
									.capturar(pecaSelecionada2);
							if (pecaCapturada == null) {
								throw new IllegalArgumentException(
										"Impossï¿½vel Capturar - Movimento invï¿½lido!");
							}

						} catch (Exception e2) {
							System.out.println("e2 "+e2.getMessage());
							throw new IllegalArgumentException(e2.getMessage());
						}
					}
				} else {
					if (pecaSelecionada1.verificaDest(linha, coluna)) {
						pecaSelecionada1.movimentar(linha, coluna);
					} else {
						throw new IllegalArgumentException("Movimento invï¿½lido");
					}
				}
				tabuleiro.atualizar();
				Peca[][] pecas = Tabuleiro.getInstance().getPecas();
				System.out.println("Verificando Check...");
				ArrayList<Posicao> pos = new ArrayList<Posicao>();
				int x = 0;
				int y = 0;
				Peca peca = null;
				for (x = 0; x < 8; x++) {
					for (y = 0; y < 8; y++) {
						peca = pecas[x][y];
						//Testa se colocou seu próprio rei em check deve voltar ao estado anterior
						if (peca != null
								&& tabuleiro.getJogadorVez() != peca.getCor()
								&& peca.isCheckOponente(pecas)) {
							JOptionPane.showMessageDialog(null, "Se Colocou em Check","",1);
						}
						//Testa se colocou o rei do adversário em check
						if (peca != null
								&& tabuleiro.getJogadorVez() == peca.getCor()
								&& peca.isCheckOponente(pecas)) {
							JOptionPane.showMessageDialog(null, "Check");
						}
						

					}
				}
				tabuleiro.passaVez();
				pecaSelecionada1 = null;
				pecaSelecionada2 = null;
				return true;
			}
			return false;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new IllegalArgumentException(ex.getMessage());
		}
	}

}
