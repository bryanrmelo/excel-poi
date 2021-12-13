package br.edu.ifrs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import br.edu.ifrs.model.Aluno;
import br.edu.ifrs.model.Turma;

public class ExcelUtils {

	public static List<Turma> lerExcel() {

		List<Turma> turmas = new ArrayList<>();

		try {
			FileInputStream file = new FileInputStream(new File("planilha.xlsx"));

			XSSFWorkbook workbook = new XSSFWorkbook(file);

			int numeroPagina = 0;

			while (workbook.getNumberOfSheets() > numeroPagina) {

				List<Aluno> alunos = new ArrayList<>();

				XSSFSheet sheet = workbook.getSheetAt(numeroPagina);

				Iterator<Row> rowIterator = sheet.iterator();
				rowIterator.next();
				while (rowIterator.hasNext()) {

					Aluno aluno = new Aluno();

					Row row = rowIterator.next();
					aluno.setId((long) row.getCell(0).getNumericCellValue());
					aluno.setNome(row.getCell(1).getStringCellValue());
					aluno.setNotaPrimeiroTrimestre(row.getCell(2).getNumericCellValue());
					aluno.setNotaSegundoTrimestre(row.getCell(3).getNumericCellValue());
					aluno.setNotaTerceiroTrimestre(row.getCell(4).getNumericCellValue());

					alunos.add(aluno);

				}

				Turma turma = new Turma();

				turma.setNome(sheet.getSheetName());
				turma.setAlunos(alunos);

				turmas.add(turma);

				numeroPagina++;
			}
			return turmas;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void escreverExcel(XSSFWorkbook workbook, List<Turma> turmas) {

		try {
			for (Turma turma : turmas) {

				XSSFSheet sheet = workbook.createSheet(turma.getNome());

				int rowNum = 0;

				if (rowNum == 0) {
					criarCabecalho(sheet);
					rowNum++;

					for (Aluno aluno : turma.getAlunos()) {
						criarCelula(rowNum, aluno, sheet);
						rowNum++;
					}
				}
			}
			FileOutputStream fos = new FileOutputStream(new File("planilha.xlsx"));
			workbook.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void criarCelula(int rowNum, Aluno aluno, XSSFSheet sheet) {

		int cellNum = 0;

		Row row = sheet.createRow(rowNum);

		Cell cellId = row.createCell(cellNum);
		cellId.setCellValue(aluno.getId());

		Cell cellNome = row.createCell(1);
		cellNome.setCellValue(aluno.getNome());

		Cell cellNota1 = row.createCell(2);
		cellNota1.setCellValue(aluno.getNotaPrimeiroTrimestre());

		Cell cellNota2 = row.createCell(3);
		cellNota2.setCellValue(aluno.getNotaSegundoTrimestre());

		Cell cellNota3 = row.createCell(4);
		cellNota3.setCellValue(aluno.getNotaTerceiroTrimestre());

		Cell cellNotaExame = row.createCell(5);
		cellNotaExame.setCellValue(aluno.getNotaExame());

		Cell cellMedia = row.createCell(6);
		double media = (aluno.getNotaPrimeiroTrimestre() + aluno.getNotaSegundoTrimestre() + aluno.getNotaTerceiroTrimestre()) / 3;
		cellMedia.setCellValue(media);

	}

	private static void criarCabecalho(XSSFSheet sheet) {
		Row row = sheet.createRow(0);

		Cell cellId = row.createCell(0);
		cellId.setCellValue("ID");

		Cell cellNome = row.createCell(1);
		cellNome.setCellValue("Nome");

		Cell cellNota1 = row.createCell(2);
		cellNota1.setCellValue("Nota 1");

		Cell cellNota2 = row.createCell(3);
		cellNota2.setCellValue("Nota 2");

		Cell cellNota3 = row.createCell(4);
		cellNota3.setCellValue("Nota 3");

		Cell cellNotaExame = row.createCell(5);
		cellNotaExame.setCellValue("Nota Exame");

		Cell cellMedia = row.createCell(6);
		cellMedia.setCellValue("Nota Média");
	}

}
