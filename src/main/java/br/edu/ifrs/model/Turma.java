package br.edu.ifrs.model;

import java.util.List;

public class Turma {

	private long id;

	private String nome;

	private List<Aluno> alunos;

	public Turma() {

	}

	public Turma(String nome) {
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", nome=" + nome + ", alunos=" + alunos + "]";
	}

}
