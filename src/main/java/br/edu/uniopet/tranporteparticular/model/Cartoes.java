package br.edu.uniopet.tranporteparticular.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CARTOES_TABLE")
public class Cartoes {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARTOES")
    @Id
    private Long idCartoes;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    @JsonIgnore
    private Cliente cliente;

    @Column(name = "TIPO_CARTAO")
    private String tipoCartao;

    @Column(name = "BANDEIRA_CARTAO")
    private String bandeiraCartao;

    @Column(name = "NUMERO_CARTAO")
    private Integer numeroCartao;

    public Cartoes() {
    }

    public Cartoes(Long idCartoes, Cliente cliente, String tipoCartao, String bandeiraCartao, Integer numeroCartao) {
        this.idCartoes = idCartoes;
        this.cliente = cliente;
        this.tipoCartao = tipoCartao;
        this.bandeiraCartao = bandeiraCartao;
        this.numeroCartao = numeroCartao;
    }

    public Long getIdCartoes() {
        return idCartoes;
    }

    public void setIdCartoes(Long idCartoes) {
        this.idCartoes = idCartoes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public String getBandeiraCartao() {
        return bandeiraCartao;
    }

    public void setBandeiraCartao(String bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }

    public Integer getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(Integer numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cartoes cartoes = (Cartoes) o;
        return Objects.equals(idCartoes, cartoes.idCartoes) &&
                Objects.equals(cliente, cartoes.cliente) &&
                Objects.equals(tipoCartao, cartoes.tipoCartao) &&
                Objects.equals(bandeiraCartao, cartoes.bandeiraCartao) &&
                Objects.equals(numeroCartao, cartoes.numeroCartao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCartoes, cliente, tipoCartao, bandeiraCartao, numeroCartao);
    }

    @Override
    public String toString() {
        return "Cartoes{" +
                "idCartoes=" + idCartoes +
                ", cliente=" + cliente +
                ", tipoCartao='" + tipoCartao + '\'' +
                ", bandeiraCartao='" + bandeiraCartao + '\'' +
                ", numeroCartao=" + numeroCartao +
                '}';
    }
}
