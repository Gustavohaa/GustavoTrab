package Paciente;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToMany;


import Consulta.Consulta;


@Entity
public class Paciente {
    @Id
    private String cpfPaciente;
    @Column
    private String nome;
    @Column
    private Integer numConvenio;


     @OneToMany(mappedBy = "paciente")
     private List<Consulta> consultas;

    public Paciente() {

    }

    public Paciente(String cpfPaciente, String nome, Integer numConvenio) {
        super();
        this.cpfPaciente = cpfPaciente;
        this.nome = nome;
        this.numConvenio = numConvenio;
    }
    public String getCpfPaciente() {
        return cpfPaciente;
    }
    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getNumConvenio() {
        return numConvenio;
    }
    public void setNumConvenio(Integer numConvenio) {
        this.numConvenio = numConvenio;
    }

}