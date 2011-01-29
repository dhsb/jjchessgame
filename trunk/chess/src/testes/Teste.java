package testes;

import java.util.ArrayList;

import model.Peca;
import model.Posicao;
import model.Tabuleiro;
import view.TabuleiroView;

public class Teste {
	private TabuleiroView tabuleiro = new TabuleiroView(Tabuleiro.getInstance1());
	private Peca p = null;

	public static void main(String[] args) {
		Teste t = new Teste();
		t.testeCasasAtaquesRei();
		t.testeCasasAtaquesDama();
		t.testeCasasAtaquesBispo();
		t.testeCasasAtaquesCavalo();
		t.testeCasasAtaquesTorre();
	}

	public void testeCasasAtaquesRei() {
		p = (Peca) tabuleiro.getTabuleiro().getPeca(0, 4);
		p.movimentar(5, 4);
		ArrayList<Posicao> ps = p.getPosicoesAtacadas(Tabuleiro.getInstance1()
				.getPecas());
		System.out.println("REI X=" + p.getX() + "Y=" + p.getY());
		if (ps == null)
			System.out.println("NULL");
		else {
			for (Posicao pos : ps) {
				System.out.println(pos);
			}
		}
		p.movimentar(0, 4);
	}

	public void testeCasasAtaquesDama() {

	}

	public void testeCasasAtaquesBispo() {
		p = (Peca) tabuleiro.getTabuleiro().getPeca(0, 2);
		p.movimentar(2, 4);
		ArrayList<Posicao> ps = p.getPosicoesAtacadas(Tabuleiro.getInstance1()
				.getPecas());
		System.out.println("Bispo X=" + p.getX() + "Y=" + p.getY());
		if (ps == null)
			System.out.println("NULL");
		else {
			for (Posicao pos : ps) {
				System.out.println(pos);
			}
		}
		p.movimentar(0, 2);
	}

	public void testeCasasAtaquesCavalo() {
		p = (Peca) tabuleiro.getTabuleiro().getPeca(0, 1);
		p.movimentar(2, 2);
		ArrayList<Posicao> ps = p.getPosicoesAtacadas(Tabuleiro.getInstance1()
				.getPecas());
		System.out.println("Cavalo X=" + p.getX() + "Y=" + p.getY());
		if (ps == null)
			System.out.println("NULL");
		else {
			for (Posicao pos : ps) {
				System.out.println(pos);
			}
		}
		p.movimentar(2, 2);
	}

	public void testeCasasAtaquesTorre() {
		p = tabuleiro.getTabuleiro().getPeca(7, 0);
		p.movimentar(2, 4);
		ArrayList<Posicao> ps = p.getPosicoesAtacadas(Tabuleiro.getInstance1()
				.getPecas());
		System.out.println("Torre X=" + p.getX() + "Y=" + p.getY());
		if (ps == null)
			System.out.println("NULL2");
		else {
			for (Posicao pos : ps) {
				System.out.println(pos);
			}
		}
		p.movimentar(7, 0);
	}

	public void testeCasasAtaquesPeao() {

	}

}
