package br.edu.uniopet.tranporteparticular.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "MOTORISTA_TABLE")
public class Motorista {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MOTORISTA")
    @Id
    private Long idMotorista;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DETALHES_VEICULOS")
    private DetalhesVeiculos detalhesVeiculos;

    @ManyToOne
    @JoinColumn(name = "ID_VEICULO")
    @JsonIgnore
    private Veiculo veiculo;

    @Column(name = "NOME_MOTORISTA")
    private String nomeMotorista;

    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;

    @Column(name = "SEXO")
    private Character sexo;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "NUMERO_CELULAR")
    private String numeroCelular;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "DATA_CADASTRO")
    private Date dataCadastro;

    @Column(name = "STATUS_MOTORISTA")
    private Character status;

    @Column(name = "CARTEIRA_MOTORISTA")
    private String carteiraMotorista;

    @OneToMany(mappedBy = "motorista")
    private List<Viagem> viagens = new ArrayList<>();

    public Motorista() {
    }

    public Motorista(String nomeMotorista, Date dataNascimento, Character sexo, String cpf, String numeroCelular, String email, String senha, Date dataCadastro, Character status, String carteiraMotorista) {
        this.nomeMotorista = nomeMotorista;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.cpf = cpf;
        this.numeroCelular = numeroCelular;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.status = status;
        this.carteiraMotorista = carteiraMotorista;
    }

    public Long getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(Long idMotorista) {
        this.idMotorista = idMotorista;
    }

    public DetalhesVeiculos getDetalhesVeiculos() {
        return detalhesVeiculos;
    }

    public void setDetalhesVeiculos(DetalhesVeiculos detalhesVeiculos) {
        this.detalhesVeiculos = detalhesVeiculos;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getCarteiraMotorista() {
        return carteiraMotorista;
    }

    public void setCarteiraMotorista(String carteiraMotorista) {
        this.carteiraMotorista = carteiraMotorista;
    }

    public List<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorista motorista = (Motorista) o;
        return Objects.equals(idMotorista, motorista.idMotorista) &&
                Objects.equals(detalhesVeiculos, motorista.detalhesVeiculos) &&
                Objects.equals(veiculo, motorista.veiculo) &&
                Objects.equals(nomeMotorista, motorista.nomeMotorista) &&
                Objects.equals(dataNascimento, motorista.dataNascimento) &&
                Objects.equals(sexo, motorista.sexo) &&
                Objects.equals(cpf, motorista.cpf) &&
                Objects.equals(numeroCelular, motorista.numeroCelular) &&
                Objects.equals(email, motorista.email) &&
                Objects.equals(senha, motorista.senha) &&
                Objects.equals(dataCadastro, motorista.dataCadastro) &&
                Objects.equals(status, motorista.status) &&
                Objects.equals(carteiraMotorista, motorista.carteiraMotorista) &&
                Objects.equals(viagens, motorista.viagens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMotorista, detalhesVeiculos, veiculo, nomeMotorista, dataNascimento, sexo, cpf, numeroCelular, email, senha, dataCadastro, status, carteiraMotorista, viagens);
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "idMotorista=" + idMotorista +
                ", detalhesVeiculos=" + detalhesVeiculos +
                ", veiculo=" + veiculo +
                ", nomeMotorista='" + nomeMotorista + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", sexo=" + sexo +
                ", cpf='" + cpf + '\'' +
                ", numeroCelular='" + numeroCelular + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", status=" + status +
                ", carteiraMotorista='" + carteiraMotorista + '\'' +
                ", viagens=" + viagens +
                '}';
    }
}
