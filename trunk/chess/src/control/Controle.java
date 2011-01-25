package control;

import java.awt.event.MouseEvent;
import java.beans.Beans;
import java.util.ArrayList;

import javax.naming.spi.ObjectFactory;
import javax.rmi.CORBA.Util;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.omg.CORBA.Object;

import view.PecasCapturadasTableModel;

import model.EstadoJogo;
import model.Peca;
import model.Posicao;
import model.Tabuleiro;

public class Controle {

	/*
	 * Quando uma pe�a Branca Joga:Verificar se o Rei branco n�o est� check( Se
	 * tiver Volta jogada e da mensagem )Verificar se o Rei Preto est� em check(
	 * Da mensagem Check ).
	 */
	private Peca pecaSelecionada1 = null;
	private Peca pecaSelecionada2 = null;
	private Tabuleiro tabuleiro = null;
	private ControleEstadoJogo controleEstadosJogo;

	public Controle(Tabuleiro tabuleiro1, Tabuleiro tabuleiro2) {
		controleEstadosJogo = new ControleEstadoJogo();
		// this.tabuleiro1 = tabuleiro1;
		// this.tabuleiro2 = tabuleiro2;
		// TODO Auto-generated constructor stub
	}

	public void subJogar(MouseEvent evento, int selectedRow, int selectedColumn) {
		try {
			jogar(evento, selectedRow, selectedColumn);
		} catch (Exception e) {
			System.out.println("e " + e.getMessage());
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
				// Coloca a pe�a selecionada em pecaSelecionada1
				pecaSelecionada1 = tabuleiro.getPeca(linha, coluna);
				if (pecaSelecionada1 != null)
					// Verifica se a pe�a selecionada � diferente da pe�a da vez
					if (!pecaSelecionada1.getCor().equals(
							tabuleiro.getJogadorVez())) {
						throw new IllegalArgumentException("N�o � sua vez");
					}
			} else {
				pecaSelecionada2 = tabuleiro.getPeca(linha, coluna);
				if (pecaSelecionada2 != null) {
					if (pecaSelecionada2.getCor().equals(
							pecaSelecionada1.getCor())) {
						if (pecaSelecionada1 != pecaSelecionada2) {
							// JOptionPane.showMessageDialog(null,"Voc� deve jogar com a pe�a que tocou primeiro!");
						}
						pecaSelecionada2 = null;
						return false;
					} else {
						try {
							Peca pecaCapturada = pecaSelecionada1
									.capturar(pecaSelecionada2);
							if (pecaCapturada == null) {
								throw new IllegalArgumentException(
										"Imposs�vel Capturar - Movimento inv�lido!");
							}

						} catch (Exception e2) {
							System.out.println("e2 " + e2.getMessage());
							throw new IllegalArgumentException(e2.getMessage());
						}
					}
				} else {
					if (pecaSelecionada1.verificaDest(linha, coluna)) {
						pecaSelecionada1.movimentar(linha, coluna);
					} else {
						throw new IllegalArgumentException("Movimento inv�lido");
					}
				}
				tabuleiro.atualizar();
				Peca[][] pecas = Tabuleiro.getInstance().getPecas();
				System.out.println("Verificando Check...");
				int x = 0;
				int y = 0;
				Peca peca = null;
				for (x = 0; x < 8; x++) {
					for (y = 0; y < 8; y++) {
						peca = pecas[x][y];
						// Testa se colocou seu pr�prio rei em check deve voltar
						// ao estado anterior
						if (peca != null
								&& tabuleiro.getJogadorVez() != peca.getCor()
								&& peca.isCheckOponente(pecas)) {
							JOptionPane.showMessageDialog(null,
									"Se Colocou em Check", "", 1);
							EstadoJogo estadoAnterior = controleEstadosJogo
									.voltarEstado();
							Tabuleiro.getInstance().setPecas(estadoAnterior.getTabuleiro().getPecas());
							Tabuleiro.getInstance().setJogadorVez(estadoAnterior.getTabuleiro().getJogadorVez());
							PecasCapturadasTableModel
									.getInstance().setPecasBrancasCapturadas(estadoAnterior.getPecasCapturas().getPecasBrancasCapturadas(), estadoAnterior.getPecasCapturas().getPecasPretasCapturadas());
						}

						// Testa se colocou o rei do advers�rio em check
						if (peca != null
								&& tabuleiro.getJogadorVez() == peca.getCor()
								&& peca.isCheckOponente(pecas)) {
							JOptionPane.showMessageDialog(null, "Check");
						}
					}
				}
				tabuleiro.passaVez();
				Tabuleiro t = (Tabuleiro) tabuleiro.copiar();
				controleEstadosJogo.addEstado(new EstadoJogo(t,PecasCapturadasTableModel.getInstance()));
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
