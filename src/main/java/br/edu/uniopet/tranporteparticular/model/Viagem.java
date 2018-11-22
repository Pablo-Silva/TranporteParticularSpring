package br.edu.uniopet.tranporteparticular.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "VIAGEM_TABLE")
public class Viagem {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VIAGEM")
    @Id
    private Long idViagem;

    @ManyToOne
    @JoinColumn(name = "ID_MOTORISTA")
    @JsonIgnore
    private Motorista motorista;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    @JsonIgnore
    private Cliente cliente;

    @Column(name = "ENDERECO_SAIDA")
    private String enderecoSaida;

    @Column(name = "ENDERECO_CHEGADA")
    private String enderecoChegada;

    @Column(name = "DATA_FIM")
    private Date dataFim;

    @Column(name = "DATA_INICIO")
    private Date dataInicio;

    public Viagem() {
    }

    public Viagem( Motorista motorista, Cliente cliente, String enderecoSaida, String enderecoChegada, Date dataFim, Date dataInicio) {
        this.motorista = motorista;
        this.cliente = cliente;
        this.enderecoSaida = enderecoSaida;
        this.enderecoChegada = enderecoChegada;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
    }

    public Long getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(Long idViagem) {
        this.idViagem = idViagem;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEnderecoSaida() {
        return enderecoSaida;
    }

    public void setEnderecoSaida(String enderecoSaida) {
        this.enderecoSaida = enderecoSaida;
    }

    public String getEnderecoChegada() {
        return enderecoChegada;
    }

    public void setEnderecoChegada(String enderecoChegada) {
        this.enderecoChegada = enderecoChegada;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Viagem viagem = (Viagem) o;
        return Objects.equals(idViagem, viagem.idViagem) &&
                Objects.equals(motorista, viagem.motorista) &&
                Objects.equals(cliente, viagem.cliente) &&
                Objects.equals(enderecoSaida, viagem.enderecoSaida) &&
                Objects.equals(enderecoChegada, viagem.enderecoChegada) &&
                Objects.equals(dataFim, viagem.dataFim) &&
                Objects.equals(dataInicio, viagem.dataInicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idViagem, motorista, cliente, enderecoSaida, enderecoChegada, dataFim, dataInicio);
    }

    @Override
    public String toString() {
        return "Viagem{" +
                "idViagem=" + idViagem +
                ", motorista=" + motorista +
                ", cliente=" + cliente +
                ", enderecoSaida='" + enderecoSaida + '\'' +
                ", enderecoChegada='" + enderecoChegada + '\'' +
                ", dataFim=" + dataFim +
                ", dataInicio=" + dataInicio +
                '}';
    }
}
