package br.edu.ifrs.utils;

import java.util.Scanner;
import br.edu.ifrs.service.RegistroService;

public class MenuUtil {

	private static final Scanner sc = new Scanner(System.in);

	private RegistroService registroService = new RegistroService();

	public void desenharMenu() {
		while (true) {
			System.out.println("REGISTRO");
			System.out.println("(1) - Criar aluno");
			System.out.println("(2) - Criar turma");
			System.out.println("(3) - Adicionar aluno na turma");
			System.out.println("(4) - Remover aluno da turma");
			System.out.println("(5) - Mostrar alunos");
			System.out.println("(6) - Mostrar turmas");
			System.out.println("(7) - Mostrar aluno por turma");
			System.out.println("(8) - Salvar planilha");
			System.out.println("(0) - Sair");

			int op = sc.nextInt();

			if (op == 1) {
				registroService.criarAluno();
			} else
				if (op == 2) {
					registroService.criarTurma();
				} else
					if (op == 3) {
						registroService.adicionarAlunoTurma();
					} else
						if (op == 4) {
							registroService.removerAlunoTurma();
						} else
							if (op == 5) {
								registroService.mostrarTodosAlunos();
							} else
								if (op == 6) {
									registroService.mostrarTodasTurmas();
								} else
									if (op == 7) {
										registroService.mostrarAlunosPorTurma();
									} else
										if (op == 8) {
											registroService.salvarPlanilha();
										} else
											if (op == 0) {
												break;
											}
		}

	}
}
