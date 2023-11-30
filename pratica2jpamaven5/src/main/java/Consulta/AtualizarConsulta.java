package Consulta;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AtualizarConsulta {
	public static void atualizarConsulta() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);

		em.getTransaction().begin();

		System.out.print("Digite o código da consulta que deseja atualizar: ");
		Integer codConsulta = sc.nextInt();
		Consulta consulta = em.find(Consulta.class, codConsulta);

		if (consulta != null) {
			System.out.println("Consulta encontrada:");
			System.out.println("Data atual: " + consulta.getData());
			System.out.print("Digite a nova data da consulta: ");
			sc.nextLine(); 
			String novaData = sc.nextLine();
			consulta.setData(novaData);

			System.out.println("Hora atual: " + consulta.getHora());
			System.out.print("Digite a nova hora da consulta: ");
			String novaHora = sc.nextLine();
			consulta.setHora(novaHora);

			
			em.merge(consulta);

			em.getTransaction().commit();
			System.out.println("Consulta atualizada com sucesso!");
		} else {
			System.out.println("Consulta não encontrada.");
			em.getTransaction().rollback();
		}

		em.close();
		emf.close();
	}
}
