package Medico;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InserirMedico {
	public static void inserirMedicos(){
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
	    EntityManager em = emf.createEntityManager();
	    Scanner sc = new Scanner(System.in);

	    em.getTransaction().begin();

	    System.out.print("Digite o nome do médico: ");
	    String nome = sc.nextLine(); 

	    System.out.print("Digite a especialidade do médico: ");
	    String especialidade = sc.next();

	    Medico medico = new Medico(nome, especialidade);
	    em.persist(medico);

	    em.getTransaction().commit();
	    System.out.println("Médico inserido com sucesso!");
	    System.out.println(" ");
	}
}