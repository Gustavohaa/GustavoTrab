package Paciente;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InserirPaciente {
	public static void inserirPaciente() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
	    EntityManager em = emf.createEntityManager();

	    Scanner sc = new Scanner(System.in);
	    em.getTransaction().begin();

	    System.out.print("Digite o CPF do paciente: ");
	    String cpfPaciente = sc.next();

	    // Consumir o caractere de nova linha pendente
	    sc.nextLine();

	    System.out.print("Digite o nome do paciente: ");
	    String nomePaciente = sc.nextLine();

	    System.out.print("Digite o número do convênio do paciente: ");
	    Integer numConvenio = sc.nextInt();

	    Paciente paciente = new Paciente(cpfPaciente, nomePaciente, numConvenio);
	    em.persist(paciente);

	    em.getTransaction().commit();
	    System.out.println("Paciente inserido com sucesso!");
	    System.out.println(" ");
	}
}
