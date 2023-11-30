package Medico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Consulta.Consulta;

import java.util.List;
import java.util.Scanner;

public class RemoverMedico {

	public static void deletarMedico() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);

		em.getTransaction().begin();

		System.out.print("Digite o código do médico que deseja deletar: ");
		Long codMedico = sc.nextLong();

		Medico medico = em.find(Medico.class, codMedico);

		if (medico != null) {
			
			TypedQuery<Consulta> consultaQuery = em.createQuery("SELECT c FROM Consulta c WHERE c.medico = :medico",
					Consulta.class);
			consultaQuery.setParameter("medico", medico);
			List<Consulta> consultas = consultaQuery.getResultList();

			if (consultas.isEmpty()) {
				
				em.remove(medico);
				em.getTransaction().commit();
				System.out.println("Médico removido com sucesso!");
			} else {
				// Há consultas associadas, exibir uma mensagem
				System.out.println("Não é possível remover o médico. Consultas associadas encontradas.");
				em.getTransaction().rollback();
			}
		} else {
			System.out.println("Médico não encontrado.");
		}

		em.close();
		emf.close();
	}
}
