package control;

import java.util.ArrayList;

import model.EstadoJogo;

public class ControleEstadoJogo {
	private ArrayList<EstadoJogo> listaEstados;

	private int jogadaAtual;

	public ControleEstadoJogo() {
		iniciar();
	}

	public ControleEstadoJogo(ArrayList<EstadoJogo> lista, int lance) {
		listaEstados = lista;
		jogadaAtual = lance;
	}

	public void iniciar() {
		listaEstados = new ArrayList<EstadoJogo>();
		jogadaAtual = 0;
	}

	public void addEstado(EstadoJogo estado) {
		jogadaAtual++;
		listaEstados.add(estado);
	}

	public EstadoJogo voltarEstado() {
		jogadaAtual--;
		return listaEstados.remove(jogadaAtual);
	}

	public EstadoJogo avancarEstado() {
		if (jogadaAtual + 1 < listaEstados.size())
			jogadaAtual++;
		return listaEstados.get(jogadaAtual);
	}

}
