package model;

import java.util.ArrayList;
import java.util.Arrays;

import view.PecasCapturadasTableModel;

public class EstadoJogo {
	private Peca[][] pecas;
	private ArrayList<Peca> pecasBrancasCapturadas;
	private ArrayList<Peca> pecasPretasCapturadas;

	public EstadoJogo(Peca[][] pcs, ArrayList<Peca> pecasBrancasCapturadas,
			ArrayList<Peca> pecasPretasCapturadas) {
		
		this.pecas = new Peca[8][8];
		int x = 0;
		int y = 0;
		for(x=0;x<8;x++){
			for(y=0;y<8;y++){
				pecas[x][y] = pcs[x][y];
			}
		}
		this.pecasBrancasCapturadas = new ArrayList<Peca>();
		this.pecasBrancasCapturadas.addAll(pecasBrancasCapturadas);
		
		this.pecasPretasCapturadas = new ArrayList<Peca>();
		this.pecasPretasCapturadas.addAll(pecasPretasCapturadas);
	}

	public ArrayList<Peca> getPecasBrancasCapturadas() {
		return pecasBrancasCapturadas;
	}

	public ArrayList<Peca> getPecasPretasCapturadas() {
		return pecasPretasCapturadas;
	}

	public Peca[][] getPecas() {
		return pecas;
	}

	/*
	 * private Tabuleiro tabuleiro; private PecasCapturadasTableModel
	 * pecasCapturas;
	 * 
	 * public EstadoJogo(Tabuleiro tabuleiro, PecasCapturadasTableModel
	 * pecasCapturas) { this.tabuleiro = tabuleiro; this.pecasCapturas =
	 * pecasCapturas; }
	 * 
	 * public PecasCapturadasTableModel getPecasCapturas() { return
	 * pecasCapturas; }
	 * 
	 * public Tabuleiro getTabuleiro() { return tabuleiro; }
	 */
}
