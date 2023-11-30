package Consulta;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultarConsulta {
	public static void consultarConsultaPorId() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o código da consulta: ");
		Integer codConsulta = sc.nextInt();
		Consulta consulta = em.find(Consulta.class, codConsulta);

		if (consulta != null) {
			System.out.println("Consulta encontrada:");
			System.out.println("Data: " + consulta.getData());
			System.out.println("Hora: " + consulta.getHora());

			System.out.println("Paciente:");
			System.out.println("  - CPF: " + consulta.getPaciente().getCpfPaciente());
			System.out.println("  - Nome: " + consulta.getPaciente().getNome());

			System.out.println("Médico:");
			System.out.println("  - Nome: " + consulta.getMedico().getNome());
			System.out.println("    Especialidade: " + consulta.getMedico().getEspecialidade());
		} else {
			System.out.println("Consulta não encontrada.");
			System.out.println(" ");
		}
	}
}
