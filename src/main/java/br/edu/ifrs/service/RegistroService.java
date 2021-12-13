package br.edu.ifrs.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import br.edu.ifrs.model.Aluno;
import br.edu.ifrs.model.Turma;

public class RegistroService {

	private static final Scanner sc = new Scanner(System.in);

	private List<Aluno> alunos = new ArrayList<>();

	private Set<Turma> turmas = new HashSet<>();

	public void criarAluno() {
		Aluno aluno = new Aluno();

		System.out.println("ID do aluno");
		aluno.setId(sc.nextInt());

		System.out.println("Nome do aluno");
		aluno.setNome(sc.next());

		System.out.println("N1 do aluno");
		aluno.setNotaPrimeiroTrimestre(sc.nextDouble());

		System.out.println("N2 do aluno");
		aluno.setNotaPrimeiroTrimestre(sc.nextDouble());

		System.out.println("N3 do aluno");
		aluno.setNotaSegundoTrimestre(sc.nextDouble());

		System.out.println("Exame do aluno");
		aluno.setNotaTerceiroTrimestre(sc.nextDouble());

		alunos.add(aluno);

	}

	public void mostrarTodosAlunos() {
		System.out.println(alunos);

	}

	public void criarTurma() {
		Turma turma = new Turma();

		System.out.println("ID da turma");
		turma.setId(sc.nextInt());

		System.out.println("Nome da turma");
		turma.setNome(sc.next());

		turmas.add(turma);

	}

	public void adicionarAlunoTurma() {
		System.out.println("ID do Aluno");
		int idAluno = sc.nextInt();

		System.out.println("ID da Turma");
		int idTurma = sc.nextInt();

		Aluno aluno = null;
		Turma turma = null;

		for (Aluno a : alunos) {
			if (a.getId() == idAluno) {
				aluno = a;
			}
		}

		for (Turma t : turmas) {
			if (t.getId() == idTurma) {
				turma = t;
			}
		}

		if (turma.getAlunos() == null) {
			List<Aluno> listaAlunos = new ArrayList<>();
			listaAlunos.add(aluno);
			turma.setAlunos(listaAlunos);
		} else {
			List<Aluno> listaAlunos = turma.getAlunos();
			listaAlunos.add(aluno);
			turma.setAlunos(listaAlunos);
		}

	}

	public void removerAlunoTurma() {
		System.out.println("ID do Aluno");
		int idAluno = sc.nextInt();

		System.out.println("ID da Turma");
		int idTurma = sc.nextInt();

		Aluno aluno = null;
		Turma turma = null;

		for (Aluno a : alunos) {
			if (a.getId() == idAluno) {
				aluno = a;
			}
		}

		for (Turma t : turmas) {
			if (t.getId() == idTurma) {
				turma = t;
			}
		}

		if (turma.getAlunos() == null) {
			List<Aluno> listaAlunos = new ArrayList<>();
			listaAlunos.remove(aluno);
			turma.setAlunos(listaAlunos);
		} else {
			List<Aluno> listaAlunos = turma.getAlunos();
			listaAlunos.remove(aluno);
			turma.setAlunos(listaAlunos);
		}

	}

	public void mostrarTodasTurmas() {
		System.out.println(turmas);

	}

	public void mostrarAlunosPorTurma() {
		for (Turma turma : turmas) {
			System.out.println(turma.getNome() + " " + turma.getAlunos());
		}

	}

}
