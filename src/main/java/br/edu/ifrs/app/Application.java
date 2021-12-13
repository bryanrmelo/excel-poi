package br.edu.ifrs.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import br.edu.ifrs.model.Aluno;
import br.edu.ifrs.model.Turma;
import br.edu.ifrs.utils.ExcelUtils;

public class Application {

	public static void main(String[] args) {

		Aluno aluno = new Aluno();
		aluno.setId(1);
		aluno.setNome("a");

		List<Aluno> alunos = new ArrayList<>();

		alunos.add(new Aluno(1, "a", 3.0, 7.0, 10.0, 0.0));
		alunos.add(new Aluno(2, "b"));
		alunos.add(new Aluno(3, "c"));

		Turma turma = new Turma("inf");
		turma.setAlunos(alunos);

		Turma turma2 = new Turma("adm");
		turma2.setAlunos(alunos);

		List<Turma> turmas = new ArrayList<>();
		turmas.add(turma);
		turmas.add(turma2);

		ExcelUtils.escreverExcel(new XSSFWorkbook(), turmas);
	}

}
