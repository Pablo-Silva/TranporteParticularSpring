package br.edu.uniopet.tranporteparticular.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DINHEIRO_TABLE")
public class Dinheiro {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DINHEIRO")
    @Id
    private Long idDinheiro;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @Column(name = "TIPO_DINHEIRO")
    private String tipoDinheiro;

    public Dinheiro() {
    }

    public Dinheiro(Cliente cliente, String tipoDinheiro) {
        this.cliente = cliente;
        this.tipoDinheiro = tipoDinheiro;
    }

    public Long getIdDinheiro() {
        return idDinheiro;
    }

    public void setIdDinheiro(Long idDinheiro) {
        this.idDinheiro = idDinheiro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipoDinheiro() {
        return tipoDinheiro;
    }

    public void setTipoDinheiro(String tipoDinheiro) {
        this.tipoDinheiro = tipoDinheiro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dinheiro dinheiro = (Dinheiro) o;
        return Objects.equals(idDinheiro, dinheiro.idDinheiro) &&
                Objects.equals(cliente, dinheiro.cliente) &&
                Objects.equals(tipoDinheiro, dinheiro.tipoDinheiro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDinheiro, cliente, tipoDinheiro);
    }

    @Override
    public String toString() {
        return "Dinheiro{" +
                "idDinheiro=" + idDinheiro +
                ", cliente=" + cliente +
                ", tipoDinheiro='" + tipoDinheiro + '\'' +
                '}';
    }
}
