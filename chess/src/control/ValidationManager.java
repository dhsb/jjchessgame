package control;

import java.util.List;

import model.Peca;
import model.Posicao;
import model.Tabuleiro;
import exception.IsNotYourTurnException;

public class ValidationManager {

	/**
	 * Valida se é a vez do jogador
	 * 
	 * @throws IsNotYourTurnException
	 *             Caso não for a vez
	 */
	public Peca validTurn(Tabuleiro tabuleiro, int linha, int coluna)
			throws IsNotYourTurnException {
		Peca peca = tabuleiro.getPeca(linha, coluna);
		if (peca != null && !peca.getCor().equals(tabuleiro.getJogadorVez())) {
			throw new IsNotYourTurnException();
		}
		return peca;
	}

	/**
	 * Valida a captura<br>
	 * Caso a posição destino tiver uma peça que for a mesma cor da peça
	 * selecionada, considera-se que se está selecionando outra peça
	 * 
	 * @param tabuleiro
	 * @param pecaSelecionada
	 * @param alvo
	 * @return true caso a peça foi capturada, false caso foi selecionada outra
	 *         peça
	 * @throws Exception caso o lance foi impossível
	 */
	public boolean validCapture(Tabuleiro tabuleiro, Peca pecaSelecionada,
			Peca alvo) throws Exception {
		if (alvo.getCor() == pecaSelecionada.getCor()) {
			if (pecaSelecionada != alvo) {
				// JOptionPane.showMessageDialog(null,"Vocï¿½ deve jogar com a peï¿½a que tocou primeiro!");
			}
			return false;
		} else {
			List<Posicao> lista = pecaSelecionada.getPosicoesAtacadas(tabuleiro
					.getPecas());
			for (Posicao p : lista) {
				if (p.getX() == alvo.getX() && p.getY() == alvo.getY()) {
					pecaSelecionada.capturar(alvo);
					return true;
				}
			}
			throw new IllegalArgumentException(
					"Lance Impossível - Você Tentou capturar uma peça\n "
							+ "que está fora do alcance de "
							+ pecaSelecionada.toString());
		}
	}

	public boolean validMovement(Tabuleiro tabuleiro, Peca pecaSelecionada,
			int linha, int coluna) {
		List<Posicao> lista = pecaSelecionada.getPosicoesAtacadas(tabuleiro
				.getPecas());
		for (Posicao p : lista) {
			if (p.getX() == linha && p.getY() == coluna) {
				pecaSelecionada.movimentar(linha, coluna);
				return true;
			}
		}
		throw new IllegalArgumentException("Lance Impossível!");
	}
}
