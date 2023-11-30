package Application;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Arrays;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Consulta.AtualizarConsulta;
import Consulta.Consulta;
import Consulta.ConsultarConsulta;
import Consulta.DeletarConsulta;
import Consulta.InserirConsulta;
import Medico.AtualizarMedico;
import Medico.ConsultarMedico;
import Medico.InserirMedico;
import Medico.Medico;
import Medico.RemoverMedico;
import Paciente.AtualizarPaciente;
import Paciente.ConsultaPaciente;
import Paciente.DeletarPaciente;
import Paciente.InserirPaciente;
import Paciente.Paciente;

public class Application {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int escolha;

		do {
			System.out.println("Escolha a funcionalidade:");
			System.out.println("1. Tabela dos médicos");
			System.out.println("2. Tabela de consultas");
			System.out.println("3. Tabela de pacientes");
			System.out.println("0. Sair");

			escolha = sc.nextInt();
			sc.nextLine();

			switch (escolha) {
			case 1:
				menuMedicos();
				break;
			case 2:
				menuConsultas();
				break;
			case 3:
				menuPaciente();
				break;
			case 0:
				System.out.println("Saindo do programa. Até mais!");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}

		} while (escolha != 0);
	}

	private static void menuMedicos() {
		Scanner sc = new Scanner(System.in);
		int escolha;

		do {
			System.out.println("Tabela dos Médicos:");
			System.out.println("1. Inserir Médico");
			System.out.println("2. Consultar Médico ");
			System.out.println("3. Atualizar Médico");
			System.out.println("4. Remover Médico");
			System.out.println("0. Voltar");

			escolha = sc.nextInt();
			sc.nextLine();

			switch (escolha) {
			case 1:
				InserirMedico.inserirMedicos();
				break;
			case 2:
				ConsultarMedico.consultarMedicoPorId();
				break;
			case 3:
				AtualizarMedico.atualizarMedico();
				break;
			case 4:
				RemoverMedico.deletarMedico();
				break;
			case 0:
				System.out.println("Voltando ao menu principal.");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}

		} while (escolha != 0);
	}

	private static void menuConsultas() {
		Scanner sc = new Scanner(System.in);
		int escolha;

		do {
			System.out.println("Tabela de Consultas:");
			System.out.println("1. Inserir Consulta");
			System.out.println("2. Consultar Consulta");
			System.out.println("3. Atualizar Consulta");
			System.out.println("4. Deletar Consulta");
			System.out.println("0. Voltar");

			escolha = sc.nextInt();
			sc.nextLine();

			switch (escolha) {
			case 1:
				InserirConsulta.inserirConsultas();
				break;
			case 2:
				ConsultarConsulta.consultarConsultaPorId();
				break;
			case 3:
				AtualizarConsulta.atualizarConsulta();
				break;
			case 4:
				DeletarConsulta.deletarConsulta();
				break;
			case 0:
				System.out.println("Voltando ao menu principal.");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}

		} while (escolha != 0);
	}

	private static void menuPaciente() {
		Scanner sc = new Scanner(System.in);
		int escolha;

		do {
			System.out.println("Tabela de Pacientes:");
			System.out.println("1. Inserir paciente");
			System.out.println("2. Consultar paciente");
			System.out.println("3. Atualizar Paciente");
			System.out.println("4. Remover Paciente");
			System.out.println("0. Voltar");

			escolha = sc.nextInt();
			sc.nextLine();

			switch (escolha) {
			case 1:
				InserirPaciente.inserirPaciente();
				break;
			case 2:
				ConsultaPaciente.consultarPacientePorCpf();
				break;
			case 3:
				AtualizarPaciente.atualizarPaciente();
				break;
			case 4:
				DeletarPaciente.deletarPaciente();
				break;
			case 0:
				System.out.println("Voltando ao menu principal.");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}

		} while (escolha != 0);
	}
}