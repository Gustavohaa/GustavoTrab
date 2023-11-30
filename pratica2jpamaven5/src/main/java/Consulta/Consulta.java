package Consulta;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import Medico.Medico;
import Paciente.Paciente;

import java.util.Arrays;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codConsulta;
    
    @Column
    private String data;

    @Column
    private String hora;

    @ManyToOne
    @JoinColumn(name = "codMedico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "cpfPaciente")
    private Paciente paciente;
    
    public Consulta(String data, String hora, Medico medicoEscolhido, Paciente paciente) {
        this.data = data;
        this.hora = hora;
        this.medico = medicoEscolhido;
        this.paciente = paciente;
    }

	public Consulta() {

	}

	public Integer getCodConsulta() {
		return codConsulta;
	}

	public void setCodConsulta(Integer codConsulta) {
		this.codConsulta = codConsulta;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Medico getMedico() {
	    return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	

}