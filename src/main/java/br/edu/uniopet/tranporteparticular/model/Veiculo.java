package br.edu.uniopet.tranporteparticular.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "VEICULO_TABLE")
public class Veiculo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VEICULO")
    @Id
    private Long idVeiculo;

    @Column(name = "MODELO_VEICULO")
    private String modeloVeiculo;

    @Column(name = "MARCA_VEICULO")
    private String marcaVeiculo;

    @Column(name = "DATA_FABRICACAO")
    private Date dataFabricacao;

    @OneToMany(mappedBy = "veiculo")
    private List<Motorista> motoristas = new ArrayList<>();

    public Veiculo() {
    }

    public Veiculo(Long idVeiculo, String modeloVeiculo, String marcaVeiculo, Date dataFabricacao) {
        this.idVeiculo = idVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.marcaVeiculo = marcaVeiculo;
        this.dataFabricacao = dataFabricacao;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public List<Motorista> getMotoristas() {
        return motoristas;
    }

    public void setMotoristas(List<Motorista> motoristas) {
        this.motoristas = motoristas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(idVeiculo, veiculo.idVeiculo) &&
                Objects.equals(modeloVeiculo, veiculo.modeloVeiculo) &&
                Objects.equals(marcaVeiculo, veiculo.marcaVeiculo) &&
                Objects.equals(dataFabricacao, veiculo.dataFabricacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVeiculo, modeloVeiculo, marcaVeiculo, dataFabricacao);
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "idVeiculo=" + idVeiculo +
                ", modeloVeiculo='" + modeloVeiculo + '\'' +
                ", marcaVeiculo='" + marcaVeiculo + '\'' +
                ", dataFabricacao=" + dataFabricacao +
                '}';
    }
}
