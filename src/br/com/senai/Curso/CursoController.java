package br.com.senai.Curso;

import java.util.List;
import java.util.Scanner;

import br.com.senai.Aluno.AlunoController;

public class CursoController extends AlunoController {
	private Scanner tec;

	public CursoController() {
		tec = new Scanner(System.in);
	}

	public int leopcao() {
		System.out.print("> ");
		return tec.nextInt();
	}

	public Curso cadastrarCurso() {
		Curso curso = new Curso();

		System.out.println("--- CADASTRAR CURSO ---");
		System.out.print("Informe o nome do curso: ");
		tec.nextLine();
		curso.setNomeCurso(tec.nextLine());
		return curso;
	}

	public List<Curso> listarCursos(List<Curso> cursos) {
		if (cursos.isEmpty()) {
			System.out.println("Não possui cursos cadastrados.");
			return null;
		}
		System.out.println("--- CURSOS CADASTRADAS ---");
		System.out.printf("| %20s , Nome");
		for (int i = 0; i < cursos.size(); i++) {
			System.out.printf("| %20s |\n", i + 1, cursos.get(i).getNomeCurso());
		}
		return cursos;
	}

	public List<Curso> editarCurso(List<Curso> cursos) {
		Curso curso = new Curso();
		listarCursos(cursos);
		if (cursos.isEmpty()) {
			return cursos;
		}
		System.out.print("Informe o Id do curso para editar: ");
		int idCurso = tec.nextInt() - 1;
		return cursos;
	}

	public void excluirCurso(List<Curso> cursos) {

		listarCursos(cursos);
		if (cursos.isEmpty()) {
			return;
		}
		System.out.println("--- EXCLUIR CURSO ---");

		System.out.println("Informe o Id do curso para exluir: ");
		int idCurso = tec.nextInt() - 1;

		if (cursos.size() <= idCurso) {
			System.out.println("Curso não cadastrado.");
			return;
		}
		cursos.remove(idCurso);

		boolean sair = false;
		do {
			System.out.println("\n------ MENU ------");
			System.out.println("1) Cadastrar Curso");
			System.out.println("2) Listar Curso");
			System.out.println("3) Editar Curso");
			System.out.println("4) Excluir Curso");
			System.out.println("0) Sair do Sistema");
			System.out.println("--------------------");
			int opcao = leopcao();
			switch (opcao) {
			case 1:
				cursos.add(cadastrarCurso());
				break;
			case 2:
				listarCursos(cursos);
				break;
			case 3:
				editarCurso(cursos);
				break;
			case 4:
				excluirCurso(cursos);
				break;

			case 0:
				sair = true;
				break;

			default:
				System.out.println("Opçăo Inválida!");
				break;
			}
		} while (!sair);
	}
}
