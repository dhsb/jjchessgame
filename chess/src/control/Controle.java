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
	 * Quando uma peï¿½a Branca Joga:Verificar se o Rei branco nï¿½o estï¿½
	 * check( Se tiver Volta jogada e da mensagem )Verificar se o Rei Preto
	 * estï¿½ em check( Da mensagem Check ).
	 */
	private Peca pecaSelecionada1 = null;
	private Peca pecaSelecionada2 = null;
	private Tabuleiro tabuleiro = null;
	private ControleEstadoJogo controleEstadosJogo;
	private static String MOVIMENTO_INVALIDO_MESSAGE = "Movimento Inválido!";
	private static String CHECK_MESSAGE = "Check!";
	private static String VEZ_OPONENTE_MESSAGE = "Não é sua Vez!";
	private static String IMP_CAP_MOV_INV_MESSAGE = "Impossível Capturar - Movimento Inválido!";
	private static String TITULO_ERRO_ALERT_MESSAGE = "JJChessGame - Erro";
	private boolean check = false;

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
				// Coloca a peï¿½a selecionada em pecaSelecionada1
				pecaSelecionada1 = tabuleiro.getPeca(linha, coluna);
				if (pecaSelecionada1 != null)
					// Verifica se a peï¿½a selecionada ï¿½ diferente da peï¿½a
					// da vez
					if (!pecaSelecionada1.getCor().equals(
							tabuleiro.getJogadorVez())) {
						throw new IllegalArgumentException(VEZ_OPONENTE_MESSAGE);
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
										IMP_CAP_MOV_INV_MESSAGE);
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
						throw new IllegalArgumentException(
								MOVIMENTO_INVALIDO_MESSAGE);
					}
				}
				tabuleiro.atualizar();
				Peca[][] pecas = Tabuleiro.getInstance().getPecas();
				int x = 0;
				int y = 0;
				Peca peca = null;
				for (x = 0; x < 8; x++) {
					for (y = 0; y < 8; y++) {
						peca = pecas[x][y];
						// Testa se colocou seu prï¿½prio rei em check deve
						// voltar
						// ao estado anterior
						if (peca != null
								&& tabuleiro.getJogadorVez() != peca.getCor()
								&& peca.isCheckOponente(pecas)) {
							if (check)
								JOptionPane.showMessageDialog(null,
										"Você deve se defender do check!",
										TITULO_ERRO_ALERT_MESSAGE, 0);
							else
								JOptionPane.showMessageDialog(null,
										"Você não pode se colocar em check!",
										TITULO_ERRO_ALERT_MESSAGE, 0);

							EstadoJogo estadoAnterior = controleEstadosJogo
									.voltarEstado();
							Tabuleiro.getInstance().setPecas(
									estadoAnterior.getPecas());
							PecasCapturadasTableModel
									.getInstance()
									.setPecasBrancasCapturadas(
											estadoAnterior
													.getPecasBrancasCapturadas(),
											estadoAnterior
													.getPecasPretasCapturadas());
							Tabuleiro.getInstance().fireTableDataChanged();
							PecasCapturadasTableModel.getInstance()
									.fireTableDataChanged();
							pecaSelecionada1 = null;
							pecaSelecionada2 = null;
							return false;
						}

						// Testa se colocou o rei do adversï¿½rio em check
						if (peca != null
								&& tabuleiro.getJogadorVez() == peca.getCor()
								&& peca.isCheckOponente(pecas)) {
							check = true;
							JOptionPane.showMessageDialog(null, CHECK_MESSAGE);
						} else
							check = false;
					}
				}
				tabuleiro.passaVez();
				Tabuleiro t = (Tabuleiro) tabuleiro.copiar();
				controleEstadosJogo.addEstado(new EstadoJogo(pecas,
						PecasCapturadasTableModel.getInstance()
								.getPecasBrancasCapturadas(),
						PecasCapturadasTableModel.getInstance()
								.getPecasPretasCapturadas()));
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
