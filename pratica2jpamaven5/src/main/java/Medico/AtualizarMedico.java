package Medico;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AtualizarMedico {
    public static void atualizarMedico() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);

        em.getTransaction().begin();

        System.out.print("Digite o código do médico que deseja atualizar: ");
        Long codMedico = sc.nextLong();
        sc.nextLine(); 

        Medico medico = em.find(Medico.class, codMedico);

        if (medico != null) {
            System.out.println("Médico encontrado:");
            System.out.println("Nome atual: " + medico.getNome());
            System.out.print("Digite o novo nome do médico: ");
            String novoNome = sc.nextLine();
            medico.setNome(novoNome);

            System.out.println("Especialidade atual: " + medico.getEspecialidade());
            System.out.print("Digite a nova especialidade do médico: ");
            String novaEspecialidade = sc.nextLine();
            medico.setEspecialidade(novaEspecialidade);
            
            
            em.merge(medico);
            
            em.getTransaction().commit();
            System.out.println("Médico atualizado com sucesso!");
        } else {
            System.out.println("Médico não encontrado.");
            em.getTransaction().rollback();
        }

        em.close();
        emf.close();
    }
}