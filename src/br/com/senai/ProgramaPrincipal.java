package br.com.senai;

	import java.util.ArrayList;
	import java.util.List;
	import br.com.senai.Aluno.Aluno;
	import br.com.senai.Aluno.AlunoController;
	import br.com.senai.Curso.Curso;
	import br.com.senai.Curso.CursoController;

	public class ProgramaPrincipal {
		public static void main(String[] args) {

			List<Aluno> alunos = new ArrayList<Aluno>();
			List<Curso> cursos = new ArrayList<Curso>();
			
			AlunoController alunoController = new AlunoController();
			CursoController cursoController = new CursoController();

			boolean sair = false;
			
		do {
			System.out.println("\n--------- MENU ---------");
			System.out.println("1) Registro dos Alunos");
			System.out.println("2) Registro dos Cursos");
			System.out.println("3) Sair do Sistema");
			System.out.println("------------------------");
			int opcao = alunoController.leopcao();
		switch (opcao) {
		case 1:
			alunos.add(alunoController.cadastrarAluno());
			break;
		case 2:
			cursos.add(cursoController.cadastrarCurso());
			break;
		case 3:
			sair = true;
			break;
			
		default:
			System.out.println("Opção Inválida!");
			break;
		}
		} while(!sair);
		System.out.println("Sistema encerrado!");
	}
	}

