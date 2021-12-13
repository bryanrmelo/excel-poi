package br.edu.ifrs.model;

public class Aluno {

	private long id;

	private String nome;

	private double notaPrimeiroTrimestre;

	private double notaSegundoTrimestre;

	private double notaTerceiroTrimestre;

	private double notaExame;

	public Aluno() {
	}

	public Aluno(long id, String nome, double notaPrimeiroTrimestre, double notaSegundoTrimestre, double notaTerceiroTrimestre, double notaExame) {
		this.id = id;
		this.nome = nome;
		this.notaPrimeiroTrimestre = notaPrimeiroTrimestre;
		this.notaSegundoTrimestre = notaSegundoTrimestre;
		this.notaTerceiroTrimestre = notaTerceiroTrimestre;
		this.notaExame = notaExame;
	}

	public Aluno(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNotaPrimeiroTrimestre() {
		return notaPrimeiroTrimestre;
	}

	public void setNotaPrimeiroTrimestre(Double notaPrimeiroTrimestre) {
		this.notaPrimeiroTrimestre = notaPrimeiroTrimestre;
	}

	public double getNotaSegundoTrimestre() {
		return notaSegundoTrimestre;
	}

	public void setNotaSegundoTrimestre(Double notaSegundoTrimestre) {
		this.notaSegundoTrimestre = notaSegundoTrimestre;
	}

	public double getNotaTerceiroTrimestre() {
		return notaTerceiroTrimestre;
	}

	public void setNotaTerceiroTrimestre(Double notaTerceiroTrimestre) {
		this.notaTerceiroTrimestre = notaTerceiroTrimestre;
	}

	public double getNotaExame() {
		return notaExame;
	}

	public void setNotaExame(Double notaExame) {
		this.notaExame = notaExame;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + "]";
	}

}
