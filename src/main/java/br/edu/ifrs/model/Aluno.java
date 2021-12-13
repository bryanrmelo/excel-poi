package br.edu.ifrs.model;

public class Aluno {

	private long id;

	private String nome;

	private Double nota_primeiro_trimestre;

	private Double nota_segundo_trimestre;

	private Double nota_terceiro_trimestre;

	private Double nota_exame;

	public Aluno() {
	}

	public Aluno(long id, String nome, Double nota_primeiro_trimestre, Double nota_segundo_trimestre, Double nota_terceiro_trimestre,
					Double nota_exame) {
		this.id = id;
		this.nome = nome;
		this.nota_primeiro_trimestre = nota_primeiro_trimestre;
		this.nota_segundo_trimestre = nota_segundo_trimestre;
		this.nota_terceiro_trimestre = nota_terceiro_trimestre;
		this.nota_exame = nota_exame;
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

	public Double getNotaPrimeiroTrimestre() {
		return nota_primeiro_trimestre;
	}

	public void setNotaPrimeiroTrimestre(Double nota_primeiro_trimestre) {
		this.nota_primeiro_trimestre = nota_primeiro_trimestre;
	}

	public Double getNotaSegundoTrimestre() {
		return nota_segundo_trimestre;
	}

	public void setNotaSegundoTrimestre(Double nota_segundo_trimestre) {
		this.nota_segundo_trimestre = nota_segundo_trimestre;
	}

	public Double getNotaTerceiroTrimestre() {
		return nota_terceiro_trimestre;
	}

	public void setNota_terceiro_trimestre(Double nota_terceiro_trimestre) {
		this.nota_terceiro_trimestre = nota_terceiro_trimestre;
	}

	public Double getNota_exame() {
		return nota_exame;
	}

	public void setNota_exame(Double nota_exame) {
		this.nota_exame = nota_exame;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + "]";
	}

}
