package Paciente;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultaPaciente {
		public static void consultarPacientePorCpf() {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
			EntityManager em = emf.createEntityManager();
		    Scanner sc = new Scanner(System.in);

		    System.out.print("Digite o CPF do paciente: ");
		    String cpfPaciente = sc.next();

		    Paciente paciente = em.find(Paciente.class, cpfPaciente);

		    if (paciente != null) {
		        System.out.println("Paciente encontrado:");
		        System.out.println("CPF: " + paciente.getCpfPaciente());
		        System.out.println("Nome: " + paciente.getNome());
		        System.out.println("Número do Convênio: " + paciente.getNumConvenio());
		    } else {
		        System.out.println("Paciente não encontrado.");
		    }

		    System.out.println(" ");
		}
}

