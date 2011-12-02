package control;

import java.util.ArrayList;
import java.util.List;

import model.Bispo;
import model.Cavalo;
import model.CorPeca;
import model.Dama;
import model.Peao;
import model.Peca;
import model.Posicao;
import model.Rei;
import model.Tabuleiro;
import model.Torre;

public class Heuristica {

	public static final int CAVALO_BISPO_VALUE = 3;
	public static final int TORRE_VALUE = 5;
	public static final int PEAO_VALUE = 1;
	/**
	 * Para simplicação foi atribuído 1 para o valor do rei, mas seria infinito
	 */
	public static final int REI_VALUE = 1;
	public static final int DAMA_VALUE = 9;

	// Quantidade máximas de casas que uma peça pode estar atacando
	public static final int MAX_ATTACK_BISPO = 13;
	public static final int MAX_ATTACK_DAMA = 13;
	public static final int MAX_ATTACK_CAVALO = 13;
	public static final int MAX_ATTACK_TORRE = 13;

	private Tabuleiro tabuleiro;

	public Heuristica(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public int getValue(Peca p) {
		if (p instanceof Peao) {
			return PEAO_VALUE;
		} else if (p instanceof Bispo || p instanceof Cavalo) {
			return CAVALO_BISPO_VALUE;
		} else if (p instanceof Dama) {
			return DAMA_VALUE;
		}
		else if (p instanceof Torre) {
			return TORRE_VALUE;
		}
		return 0;
	}

	public double getPeso(Peca p, Peca[][] pecas) {
		if (p instanceof Peao) {
			return calcPesoPeao(p);
		} else if (p instanceof Bispo) {
			return calcPesoBispo(p, pecas);
		} else if (p instanceof Cavalo) {
			return calcPesoCavalo(pecas, p);
		} else if (p instanceof Dama) {
			return 1;
		} else if (p instanceof Rei) {
			return 1;
		} else if (p instanceof Torre) {
			return 1;
		}
		return 1;
	}

	private double calcPesoCavalo(Peca[][] pecas, Peca c) {
		if (stayCenter(c) && qtdPecas(pecas) > 26) {
			return 1.5;
		}
		return 1;
	}

	/**
	 * retorna se a peçaestá no centro
	 * 
	 * @param p
	 * @return true se estiver no centro
	 */
	private boolean stayCenter(Peca p) {
		if ((p.getX() == 3 || p.getX() == 4)
				&& (p.getY() == 3 || p.getY() == 4)) {
			return true;
		}
		return false;
	}

	private int qtdPecas(Peca[][] pecas) {
		Peca p = null;
		int qtd = 0;
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				p = pecas[x][y];
				if (p != null) {
					qtd++;
				}
			}
		}
		return qtd;
	}

	private double calcPesoBispo(Peca bispo, Peca[][] pecas) {
		if (tabuleiro.getQtdBispoBranco() == 2 && qtdPecas(pecas) <= 24) { // O
			// jogo
			// já
			// está
			// mais
			// desenvolvido
			return 1.2 + (bispo.getPosicoesAtacadas(pecas).size() / MAX_ATTACK_BISPO);// Ajustar
		} else {
			return 1 + (bispo.getPosicoesAtacadas(pecas).size() / MAX_ATTACK_BISPO);
		}
	}

	private double calcPesoPeao(Peca p) {
		if (p.getY() == 3 || p.getY() == 4) {
			if (p.getX() == 4 && p.getCor() == CorPeca.Branca) {
				return 1.2;
			} else if (p.getX() == 3 && p.getCor() == CorPeca.Preta) {
				return 1.2;
			}
		}
		return 1;
	}

	public double calcScoreAtaque(CorPeca cor) {
		double score = 0;
		Peca p = null;
		int tamanhoX = tabuleiro.getTamanhoX();
		int tamanhoY = tabuleiro.getTamanhoY();
		Peca[][] pecas = tabuleiro.getPecas();
		for (int x = 0; x < tamanhoX; x++) {
			for (int y = 0; y < tamanhoY; y++) {
				p = pecas[x][y];
				if (p != null && p.getCor() == cor) {
					score += p.getPosicoesAtacadas(pecas).size();
				}
			}
		}
		return score;
	}

	public double calcScoreDefesa(CorPeca cor) {
		double score = 0;
		Peca p = null;
		int tamanhoX = tabuleiro.getTamanhoX();
		int tamanhoY = tabuleiro.getTamanhoY();
		Peca[][] pecas = tabuleiro.getPecas();
		for (int x = 0; x < tamanhoX; x++) {
			for (int y = 0; y < tamanhoY; y++) {
				p = pecas[x][y];
				if (p != null && p.getCor() == cor) {
					List<Posicao> list = p.getPosicoesDefendidas(pecas);
					System.out.println(p + " Defesa " + list.size());
					score += list.size();
				}
			}
		}
		return score;
	}

	public double calcScoreCentro(CorPeca cor) {
		double score = 0;
		Peca p = null;
		int tamanhoX = tabuleiro.getTamanhoX();
		int tamanhoY = tabuleiro.getTamanhoY();
		tabuleiro.atualizaQtdBispo();
		Peca[][] pecas = tabuleiro.getPecas();
		for (int x = 0; x < tamanhoX; x++) {
			for (int y = 0; y < tamanhoY; y++) {
				p = pecas[x][y];
				if (p != null && p.getCor() == cor && stayCenter(p)) {
					score += getValue(p) * (getPeso(p, pecas));
				}
			}
		}
		return score;
	}

	public double calcScoreMaterialxPeso(CorPeca cor) {
		double score = 0;
		Peca p = null;
		int tamanhoX = tabuleiro.getTamanhoX();
		int tamanhoY = tabuleiro.getTamanhoY();
		tabuleiro.atualizaQtdBispo();
		Peca[][] pecas = tabuleiro.getPecas();
		for (int x = 0; x < tamanhoX; x++) {
			for (int y = 0; y < tamanhoY; y++) {
				p = pecas[x][y];
				if (p != null && p.getCor() == cor) {
					score += getValue(p) * getPeso(p, pecas);
				}
			}
		}
		return score;
	}

	/**
	 * 
	 * @param cor
	 * @return Valor entre 0 e 0.8 - 0.1 para cada peão que não está dobrado
	 */
	public double calcScoreEstruturaPeao(CorPeca cor) {
		double score = 0;
		Peca p = null;
		int tamanhoX = tabuleiro.getTamanhoX();
		int tamanhoY = tabuleiro.getTamanhoY();
		tabuleiro.atualizaQtdBispo();
		Peca[][] pecas = tabuleiro.getPecas();
		List<Integer> colunas = new ArrayList<Integer>();
		for (int x = 0; x < tamanhoX; x++) {
			for (int y = 0; y < tamanhoY; y++) {
				p = pecas[x][y];
				if (p != null && p.getCor() == cor && p instanceof Peao) {
					if (!colunas.contains(y)) {
						colunas.add(y);
						score += 1;
					}
				}
			}
		}
		System.out.println("Estrutura de peão:" + cor.toString());
		return score;
	}

	/**
	 * Ataque 20 %<br>
	 * Defesa 20 %<br>
	 * Estrutura Peão 10 %<br>
	 * Centro 10 %<br>
	 * Material x Peso 50 %
	 * 
	 * @param cor
	 * @return
	 */
	public double calcTotalScore(CorPeca cor) {
		double total = calcScoreAtaque(cor) * 0.15;
		total += calcScoreCentro(cor) * 0.05;
		total += calcScoreDefesa(cor) * 0.2;
		total += calcScoreMaterialxPeso(cor) * 0.5;
		total += calcScoreEstruturaPeao(cor) * 0.1;
		return total;
	}
}
