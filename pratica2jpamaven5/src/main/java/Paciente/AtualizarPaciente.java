package Paciente;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AtualizarPaciente {
	public static void atualizarPaciente() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
	    EntityManager em = emf.createEntityManager();
	    Scanner sc = new Scanner(System.in);

	    em.getTransaction().begin();

	    System.out.print("Digite o CPF do paciente que deseja atualizar: ");
	    String cpfPaciente = sc.next();

	    Paciente paciente = em.find(Paciente.class, cpfPaciente);

	    if (paciente != null) {
	        System.out.println("Paciente encontrado:");
	        System.out.println("CPF: " + paciente.getCpfPaciente());
	        System.out.println("Nome: " + paciente.getNome());
	        System.out.println("Número do Convênio: " + paciente.getNumConvenio());

	        System.out.println("Digite os novos dados do paciente:");

	      
	        sc.nextLine();

	        System.out.print("Novo nome: ");
	        String novoNome = sc.nextLine();
	        paciente.setNome(novoNome);

	        System.out.print("Novo número do convênio: ");
	        Integer novoNumConvenio = sc.nextInt();
	        paciente.setNumConvenio(novoNumConvenio);

	       
	        em.merge(paciente);

	        em.getTransaction().commit();
	        System.out.println("Paciente atualizado com sucesso!");
	    } else {
	        System.out.println("Paciente não encontrado.");
	    }

	    em.close();
	    emf.close();
	}
}
