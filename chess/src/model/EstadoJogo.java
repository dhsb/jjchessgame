package model;

import java.util.ArrayList;

import view.PecasCapturadasTableModel;

public class EstadoJogo {
	/*private Peca[][] pecas;
	private ArrayList<Peca> pecasBrancasCapturadas;
	private ArrayList<Peca> pecasPretasCapturadas;

	public EstadoJogo(Peca[][] pecas, ArrayList<Peca> pecasBrancasCapturadas,
			ArrayList<Peca> pecasPretasCapturadas) {
		this.pecas = pecas;
		this.pecasBrancasCapturadas = pecasBrancasCapturadas;
		this.pecasPretasCapturadas = pecasPretasCapturadas;
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
	*/
	
	private Tabuleiro tabuleiro;
	private PecasCapturadasTableModel pecasCapturas;
	
	public EstadoJogo(Tabuleiro tabuleiro,
			PecasCapturadasTableModel pecasCapturas) {
		this.tabuleiro = tabuleiro;
		this.pecasCapturas = pecasCapturas;
	}

	public PecasCapturadasTableModel getPecasCapturas() {
		return pecasCapturas;
	}
	
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
}
