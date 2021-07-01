package br.com.senai.Aluno;

import java.util.List;
import java.util.Scanner;

public class AlunoController {
	private Scanner tec;

	public AlunoController() {
		tec = new Scanner(System.in);
	}

	public int leopcao() {
		System.out.print("> ");
		return tec.nextInt();
	}

	public Aluno cadastrarAluno() {
		Aluno aluno = new Aluno();

		System.out.println("--- CADASTRAR ALUNO ---");
		System.out.print("Informe o nome do Aluno: ");
		tec.nextLine();
		aluno.setNomeAluno(tec.nextLine());
		return aluno;
	}

	public List<Aluno> listarAluno(List<Aluno> alunos) {
		if (alunos.isEmpty()) {
			System.out.println("Não possui Alunos cadastrados.");
			return null;
		}
		System.out.println("--- ALUNOS CADASTRADAS ---");
		System.out.printf("| %20s , NomeAluno");
		for (int i = 0; i < alunos.size(); i++) {
			System.out.printf("| %20s |\n", i + 1, alunos.get(i).getNomeAluno());
		}
		return alunos;
	}

	public List<Aluno> editarNomeAluno(List<Aluno> alunos) {
		Aluno aluno = new Aluno();
		listarAluno(alunos);
		if (alunos.isEmpty()) {
			return null;
		}
		System.out.print("Informe o id do aluno para editar: ");
		int idAluno = tec.nextInt() - 1;
		System.out.println("1) Nome do Aluno");
		System.out.println("2) Ano de Nascimento");
		System.out.println("3) Endereço");
		System.out.print("Informe o campo que deseja alterar: ");
		int opcao = tec.nextInt();
		switch (opcao) {

		case 1:
			System.out.println("--- EDITAR O NOME ---");
			System.out.print("Informe o novo nome: ");
			aluno.setNomeAluno(tec.next());

			aluno.setAnoDeNascimento(alunos.get(idAluno).getAnoDeNascimento());
			aluno.setPais(alunos.get(idAluno).getPais());
			aluno.setEstado(alunos.get(idAluno).getEstado());
			aluno.setCidade(alunos.get(idAluno).getCidade());
			aluno.setCurso(alunos.get(idAluno).getCurso());

			alunos.set(idAluno, aluno);
			break;
		case 2:
			System.out.println("--- EDITAR O ANO DE NASCIMENTO ---");
			System.out.print("Informe a nova data de nascimento: ");
			aluno.setAnoDeNascimento(tec.nextInt());

			aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
			aluno.setPais(alunos.get(idAluno).getPais());
			aluno.setEstado(alunos.get(idAluno).getEstado());
			aluno.setCidade(alunos.get(idAluno).getCidade());
			aluno.setCurso(alunos.get(idAluno).getCurso());
			;

			alunos.set(idAluno, aluno);
			break;

		case 3:
			System.out.println("--- EDITAR O Endereço ---");
			System.out.print("Informe o novo Endereço: ");
			aluno.setEndereço(tec.next());

			aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
			aluno.setPais(alunos.get(idAluno).getPais());
			aluno.setEstado(alunos.get(idAluno).getEstado());
			aluno.setCidade(alunos.get(idAluno).getCidade());
			aluno.setCurso(alunos.get(idAluno).getCurso());
			;

			alunos.set(idAluno, aluno);
			break;
		}
		return alunos;
	}

	public void excluirAluno(List<Aluno> alunos) {
		listarAluno(alunos);
		if (alunos.isEmpty()) {
			return ;
		}

		System.out.println("--- EXCLUIR ALUNO ---");
		System.out.println("Informe a matrcula do aluno para exluir: ");
		int idAluno = tec.nextInt() - 1;

		if (alunos.size() <= idAluno) {
			System.out.println("Aluno não cadastrado.");
			return ;
		}
		alunos.remove(idAluno);

		boolean sair = false;
		do {
			System.out.println("\n------ MENU ------");
			System.out.println("1) Cadastrar Aluno");
			System.out.println("2) Listar Aluno");
			System.out.println("3) Editar Aluno");
			System.out.println("4) Excluir Aluno");
			System.out.println("0) Sair do Sistema");
			System.out.println("--------------------");
			int opcao = leopcao();
			switch (opcao) {
			case 1:
				alunos.add(cadastrarAluno());
				break;
			case 2:
				listarAluno(alunos);
				break;
			case 3:
				editarNomeAluno(alunos);
				break;
			case 4:
				excluirAluno(alunos);
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
