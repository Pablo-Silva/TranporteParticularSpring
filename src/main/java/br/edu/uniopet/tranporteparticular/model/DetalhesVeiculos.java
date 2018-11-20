package br.edu.uniopet.tranporteparticular.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DETALHES_VEICULOS_TABLE")
public class DetalhesVeiculos {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DETALHES_VEICULOS")
    @Id
    private Long idDetalhesVeiculo;

    @Column(name = "PLACA_VEICULO")
    private String placaVeiculo;

    @Column(name = "COR_VEICULO")
    private String corVeiculo;

    @Column(name = "ACENTOS_VEICULO")
    private Integer acentosVeiculo;

    public DetalhesVeiculos() {
    }

    public DetalhesVeiculos(Long idDetalhesVeiculo, String placaVeiculo, String corVeiculo, Integer acentosVeiclo) {
        this.idDetalhesVeiculo = idDetalhesVeiculo;
        this.placaVeiculo = placaVeiculo;
        this.corVeiculo = corVeiculo;
        this.acentosVeiculo = acentosVeiclo;
    }

    public Long getIdDetalhesVeiculo() {
        return idDetalhesVeiculo;
    }

    public void setIdDetalhesVeiculo(Long idDetalhesVeiculo) {
        this.idDetalhesVeiculo = idDetalhesVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getCorVeiculo() {
        return corVeiculo;
    }

    public void setCorVeiculo(String corVeiculo) {
        this.corVeiculo = corVeiculo;
    }

    public Integer getAcentosVeiculo() {
        return acentosVeiculo;
    }

    public void setAcentosVeiculo(Integer acentosVeiculo) {
        this.acentosVeiculo = acentosVeiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalhesVeiculos that = (DetalhesVeiculos) o;
        return Objects.equals(idDetalhesVeiculo, that.idDetalhesVeiculo) &&
                Objects.equals(placaVeiculo, that.placaVeiculo) &&
                Objects.equals(corVeiculo, that.corVeiculo) &&
                Objects.equals(acentosVeiculo, that.acentosVeiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDetalhesVeiculo, placaVeiculo, corVeiculo, acentosVeiculo);
    }

    @Override
    public String toString() {
        return "DetalhesVeiculos{" +
                "idDetalhesVeiculo=" + idDetalhesVeiculo +
                ", placaVeiculo='" + placaVeiculo + '\'' +
                ", corVeiculo='" + corVeiculo + '\'' +
                ", acentosVeiclo=" + acentosVeiculo +
                '}';
    }
}
