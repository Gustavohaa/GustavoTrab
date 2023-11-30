package Paciente;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Consulta.Consulta;

public class DeletarPaciente {
    public static void deletarPaciente() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);

        em.getTransaction().begin();

        System.out.print("Digite o CPF do paciente que deseja deletar: ");
        String cpfPaciente = sc.next();

        Paciente paciente = em.find(Paciente.class, cpfPaciente);

        if (paciente != null) {
            
            TypedQuery<Consulta> consultaQuery = em.createQuery(
                    "SELECT c FROM Consulta c WHERE c.paciente = :paciente", Consulta.class);
            consultaQuery.setParameter("paciente", paciente);
            List<Consulta> consultas = consultaQuery.getResultList();

            if (consultas.isEmpty()) {
                
                em.remove(paciente);
                em.getTransaction().commit();
                System.out.println("Paciente removido com sucesso!");
            } else {
               
                System.out.println("Não é possível remover o paciente. Consultas associadas encontradas.");
                em.getTransaction().rollback();
            }
        } else {
            System.out.println("Paciente não encontrado.");
        }

        em.close();
        emf.close();
    }
}