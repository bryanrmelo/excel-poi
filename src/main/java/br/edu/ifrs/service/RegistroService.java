package br.edu.ifrs.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import br.edu.ifrs.model.Aluno;
import br.edu.ifrs.model.Turma;
import br.edu.ifrs.utils.ExcelUtils;

public class RegistroService {

	private static final Scanner sc = new Scanner(System.in);

	private List<Aluno> alunos = carregarAlunos();

	private List<Turma> turmas = carregarTurmas();

	public void criarAluno() {
		Aluno aluno = new Aluno();

		System.out.println("ID do aluno");
		aluno.setId(sc.nextInt());

		System.out.println("Nome do aluno");
		aluno.setNome(sc.next());

		System.out.println("N1 do aluno");
		aluno.setNotaPrimeiroTrimestre(sc.nextDouble());

		System.out.println("N2 do aluno");
		aluno.setNotaSegundoTrimestre(sc.nextDouble());

		System.out.println("N3 do aluno");
		aluno.setNotaTerceiroTrimestre(sc.nextDouble());

		if ((aluno.getNotaPrimeiroTrimestre() + aluno.getNotaSegundoTrimestre() + aluno.getNotaTerceiroTrimestre()) / 3 < 7) {
			System.out.println("Exame do aluno");
			aluno.setNotaExame(sc.nextDouble());
		}

		alunos.add(aluno);

	}

	private List<Turma> carregarTurmas() {
		return ExcelUtils.lerExcel();
	}

	private List<Aluno> carregarAlunos() {
		List<Aluno> alunosJuntos = new ArrayList<>();

		List<Turma> turmas = ExcelUtils.lerExcel();
		for (Turma turma : turmas) {
			for (Aluno aluno : turma.getAlunos()) {
				alunosJuntos.add(aluno);
			}
		}
		return alunosJuntos;
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

	public void salvarPlanilha() {
		try {
			File file = new File("planilha.xlsx");
			file.delete();
			ExcelUtils.escreverExcel(new XSSFWorkbook(), turmas);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
