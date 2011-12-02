package control;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import model.CorPeca;
import model.EstadoJogo;
import model.Peca;
import model.Tabuleiro;
import view.PecasCapturadasTableModel;
import view.Tela;
import exception.IsNotYourTurnException;

public class Controle {

	/*
	 * Tratar o movimento pulandosobre peças.
	 */
	private Peca pecaSelecionada = null;
	private Peca alvo = null;
	private Tabuleiro tabuleiro = null;
	private Heuristica heuristica = null;
	private ControleEstadoJogo controleEstadosJogo;
	private static String CHECK_MESSAGE = "Check!";
	private static String TITULO_ERRO_ALERT_MESSAGE = "JJChessGame - Erro";
	private boolean check = false;
	private Tela tela;
	private ValidationManager validation;

	public Controle(Tabuleiro tabuleiro1) {
		controleEstadosJogo = new ControleEstadoJogo();
		this.tabuleiro = tabuleiro1;
		heuristica = new Heuristica(tabuleiro);
		validation = new ValidationManager();
	}

	public void subJogar(MouseEvent evento, int selectedRow, int selectedColumn) {
		try {
			JTable tabela = (JTable) evento.getSource();
			tabuleiro = (Tabuleiro) tabela.getModel();
			jogar(selectedRow, selectedColumn);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
			setNenhumaSelecionada();
		}
	}

	private boolean pecaSelecionada() {
		if (pecaSelecionada == null) {
			return false;
		}
		return true;
	}

	public void trySelect(int linha, int coluna) throws IsNotYourTurnException {
		pecaSelecionada = validation.validTurn(tabuleiro, linha, coluna);
	}

	public boolean tryMovement(int linha, int coluna) throws Exception {
		alvo = tabuleiro.getPeca(linha, coluna);
		if (alvo != null) {
			if (validation.validCapture(tabuleiro, pecaSelecionada, alvo)) {
				System.out.println("Selecionado outra Peça");
			} else {
				pecaSelecionada =alvo;
				alvo=null;
				tela.setPecaSelecionada(pecaSelecionada.toString());
				return false;// Selecionou outra peça, apenas
			}
		} else {
			validation.validMovement(tabuleiro, pecaSelecionada, linha, coluna);
		}
		tabuleiro.atualizar();
		Peca[][] pecas = Tabuleiro.getInstance1().getPecas();
		int x = 0;
		int y = 0;
		Peca peca = null;
		for (x = 0; x < 8; x++) {
			for (y = 0; y < 8; y++) {
				peca = pecas[x][y];
				// Testa se colocou seu prï¿½prio rei em check deve
				// voltar
				// ao estado anterior
				if (peca != null && tabuleiro.getJogadorVez() != peca.getCor()
						&& peca.isCheckOponente(pecas)) {
					if (check) {
						JOptionPane.showMessageDialog(null,
								"Você deve se defender do check!",
								TITULO_ERRO_ALERT_MESSAGE, 0);
					} else {
						JOptionPane.showMessageDialog(null,
								"Você não pode se colocar em check!",
								TITULO_ERRO_ALERT_MESSAGE, 0);
					}
					EstadoJogo estadoAnterior = controleEstadosJogo
							.voltarEstado();
					Tabuleiro.getInstance1()
							.setPecas(estadoAnterior.getPecas());
					PecasCapturadasTableModel.getInstance1()
							.setPecasCapturadas(
									estadoAnterior.getPecasBrancasCapturadas(),
									estadoAnterior.getPecasPretasCapturadas());
					Tabuleiro.getInstance1().fireTableDataChanged();
					PecasCapturadasTableModel.getInstance1()
							.fireTableDataChanged();
					setNenhumaSelecionada();
					return false;
				}

				// Testa se colocou o rei do adversï¿½rio em check
				if (peca != null && tabuleiro.getJogadorVez() == peca.getCor()
						&& peca.isCheckOponente(pecas)) {
					check = true;
					JOptionPane.showMessageDialog(null, CHECK_MESSAGE);
				} else
					check = false;
			}
		}
		tabuleiro.passaVez();
		tela.setJogadorVez(CorPeca.getDescription(tabuleiro.getJogadorVez()));
		tela.setTotalScoreBranco(heuristica
				.calcTotalScore(CorPeca.Branca));
		tela.setTotalScorePreto(heuristica
				.calcTotalScore(CorPeca.Preta));
		
		tela.setScoreMaterialBranco(heuristica
				.calcScoreMaterialxPeso(CorPeca.Branca));
		tela.setScoreMaterialPreto(heuristica
				.calcScoreMaterialxPeso(CorPeca.Preta));
		tela.setScoreAtaqueBranco(heuristica.calcScoreAtaque(CorPeca.Branca));
		tela.setScoreAtaquePreto(heuristica.calcScoreAtaque(CorPeca.Preta));
		tela.setScoreDefesaBranco(heuristica.calcScoreDefesa(CorPeca.Branca));
		tela.setScoreDefesaPreto(heuristica.calcScoreDefesa(CorPeca.Preta));
		tela.setScoreControleCentroBranco(heuristica.calcScoreCentro(CorPeca.Branca));
		tela.setScoreControleCentroPreto(heuristica.calcScoreCentro(CorPeca.Preta));
		tela.setScoreEstruturaPeaoBranco(heuristica.calcScoreEstruturaPeao(CorPeca.Branca));
		tela.setScoreEstruturaPeaoPreto(heuristica.calcScoreEstruturaPeao(CorPeca.Preta));
		controleEstadosJogo.addEstado(new EstadoJogo(pecas,
				PecasCapturadasTableModel.getInstance1()
						.getPecasBrancasCapturadas(), PecasCapturadasTableModel
						.getInstance1().getPecasPretasCapturadas()));
		setNenhumaSelecionada();
		return true;
	}

	void setNenhumaSelecionada() {
		pecaSelecionada = null;
		alvo = null;
		tela.setPecaSelecionada("Nenhuma");
	}

	public boolean jogar(int linha, int coluna) throws Exception {
		if (!pecaSelecionada()) {
			trySelect(linha, coluna);
			if (pecaSelecionada()) {
				tela.setPecaSelecionada(pecaSelecionada.toString());
			}
		} else {
			tryMovement(linha, coluna);
			return true;
		}
		return false;
	}

	public void setTela(Tela tela) {
		this.tela = tela;
	}
}
