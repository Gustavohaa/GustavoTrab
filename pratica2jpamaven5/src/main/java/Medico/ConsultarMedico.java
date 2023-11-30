package Medico;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultarMedico {
	public static void consultarMedicoPorId() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o código do médico: ");
		Long codMedico = sc.nextLong();
		Medico medico = em.find(Medico.class, codMedico);

		if (medico != null) {
			System.out.println("Médico encontrado:");
			System.out.println("Nome: " + medico.getNome());
			System.out.println("Especialidade: " + medico.getEspecialidade());
		} else
			System.out.println("Médico não encontrado.");
		System.out.println(" ");
	}
}
