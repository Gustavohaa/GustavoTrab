package Consulta;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Medico.Medico;
import Paciente.Paciente;

public class InserirConsulta {
	public static void inserirConsultas() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
	    EntityManager em = emf.createEntityManager();
	    Scanner sc = new Scanner(System.in);

	    em.getTransaction().begin();

	    System.out.print("Digite a data da consulta: ");
	    String data = sc.next();

	    System.out.print("Digite a hora da consulta: ");
	    String hora = sc.next();

	    sc.nextLine();

	    System.out.print("Digite o nome do paciente: ");
	    String nomePaciente = sc.nextLine();

	    List<Medico> medicos = em.createQuery("SELECT m FROM Medico m", Medico.class).getResultList();
	    System.out.println("Médicos disponíveis:");
	    for (Medico medico : medicos) {
	        System.out.println(medico.getCodMedico() + ". " + medico.getNome());
	    }

	    System.out.print("Escolha o médico (pelo código): ");
	    Long codMedico = sc.nextLong();

	    Medico medicoEscolhido = em.find(Medico.class, codMedico);

	    if (medicoEscolhido == null) {
	        System.out.println("Médico não encontrado. Certifique-se de que o código foi digitado corretamente.");
	        em.getTransaction().rollback();
	        return;
	    }

	    TypedQuery<Paciente> query = em.createQuery("SELECT p FROM Paciente p WHERE p.nome = :nome", Paciente.class);
	    query.setParameter("nome", nomePaciente);
	    List<Paciente> pacientes = query.getResultList();

	    Paciente paciente;
	    if (!pacientes.isEmpty()) {
	        paciente = pacientes.get(0);
	    } else {
	        System.out.println("Paciente não encontrado. Certifique-se de que o nome foi digitado corretamente.");
	        em.getTransaction().rollback();
	        return;
	    }

	    Consulta consulta = new Consulta(data, hora, medicoEscolhido, paciente);
	    em.persist(consulta);

	    em.getTransaction().commit();
	    System.out.println("Consulta inserida com sucesso!");
	    System.out.println(" ");
	}
}