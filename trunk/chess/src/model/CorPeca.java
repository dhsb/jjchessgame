package model;

public enum CorPeca {
	Branca() {
		public String toString() {
			return "CorBranca";
		}
	},
	Preta() {
		public String toString() {
			return "CorPreta";
		}
	};

	public static String getDescription(CorPeca cor) {
		if (cor == CorPeca.Branca)
			return "Branca";
		else
			return "Preta";
	}

	public static CorPeca getOther(CorPeca cor) {
		if (cor == CorPeca.Branca)
			return CorPeca.Preta;
		else
			return CorPeca.Preta;
	}
}
