package Consulta;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeletarConsulta {
	public static void deletarConsulta() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);

		em.getTransaction().begin();

		System.out.print("Digite o código da consulta que deseja deletar: ");
		Integer codConsulta = sc.nextInt();
		Consulta consulta = em.find(Consulta.class, codConsulta);

		if (consulta != null) {
			System.out.println("Consulta encontrada:");
			System.out.println("Código: " + consulta.getCodConsulta());
			System.out.println("Data: " + consulta.getData());
			System.out.println("Hora: " + consulta.getHora());
			System.out.println("Médico: " + consulta.getMedico().getNome());
			System.out.println("Paciente: " + consulta.getPaciente().getNome());

			System.out.print("Deseja realmente remover esta consulta? (S/N): ");
			String confirmacao = sc.next().toUpperCase();

			if (confirmacao.equals("S")) {
				em.remove(consulta);
				em.getTransaction().commit();
				System.out.println("Consulta removida com sucesso!");
			} else {
				System.out.println("Remoção cancelada pelo usuário.");
				em.getTransaction().rollback();
			}
		} else {
			System.out.println("Consulta não encontrada.");
			em.getTransaction().rollback();
		}

		em.close();
		emf.close();
	}
}
